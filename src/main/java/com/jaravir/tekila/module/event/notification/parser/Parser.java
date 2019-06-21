package com.jaravir.tekila.module.event.notification.parser;

import com.jaravir.tekila.module.accounting.entity.Invoice;
import com.jaravir.tekila.module.service.ServiceSettingType;
import com.jaravir.tekila.module.service.entity.ServiceSetting;
import com.jaravir.tekila.module.service.entity.ValueAddedService;
import com.jaravir.tekila.module.subscription.persistence.entity.Subscription;
import com.jaravir.tekila.module.subscription.persistence.entity.SubscriptionSetting;
import org.joda.time.format.DateTimeFormat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by sajabrayilov on 12/3/2014.
 */
public class Parser {
    private String text;
    private final static List<String> patternList = new ArrayList<>();

    static {
        patternList.addAll(Arrays.asList(
                "{%BALANCE%}"
                , "{%PAYMENT%}",
                "{%SERVICE%}", "{%SERVICE_FEE%}", "{%DEBT%}", "{%EXPIRATION_DATE%}", "{%AGREEMENT%}", "{%STATUS%}", "{%INVOICE_ID%}",
                "{%PASSWORD%}", "{%USERNAME%}", "{%SUBSCRIBER%}", "{%VAS_SERVICE%}", "{%SMS_CODE%}", "{%EXPIRATION_DATE_NO_TIME%}"
        ));
    }

    public String parseText(String text, Subscription subscription, Double payment, Invoice invoice, ValueAddedService vas) {
        for (String pattern : patternList) {

            if (text.contains(pattern)) {
                pattern = pattern.replace("{", "\\{");
                pattern = pattern.replaceAll("}", "\\}");
                if (pattern.contains("BALANCE")) {
                    text = text.replaceAll(pattern, subscription.getBalance().getRealBalanceForView());
                }
                else if (pattern.contains("PAYMENT") && payment != null) {
                    text = text.replaceAll(pattern, String.valueOf(payment));
                }
                else if (pattern.contains("SERVICE")) {
                    text = text.replaceAll(pattern, subscription.getService().getName());
                }
                else if (pattern.contains("SERVICE_FEE")) {
                    if (subscription.getService().getProvider().getId() == 454112
                            || subscription.getService().getProvider().getId() == 454113 ){
                        text = text.replaceAll(pattern, subscription.getServiceFeeRateForView());
                    }else{
                        text = text.replaceAll(pattern, subscription.getService().getServicePriceForView());
                    }

                }
                else if (pattern.contains("DEBT") && invoice != null) {
                    text = text.replaceAll(pattern, invoice.getBalanceForView());
                }
                else if (pattern.contains("EXPIRATION_DATE_NO_TIME")) {
                    text = text.replaceAll(pattern, subscription.getExpirationDateWithGracePeriod().toString(DateTimeFormat.forPattern("dd.MM.yyyy")));
                }
                else if (pattern.contains("EXPIRATION_DATE")) {
                    text = text.replaceAll(pattern, subscription.getExpirationDateWithGracePeriod().toString(DateTimeFormat.forPattern("HH:mm:ss dd.MM.yyyy")));
                }
                else if (pattern.contains("AGREEMENT")) {
                    text = text.replaceAll(pattern, subscription.getAgreement());
                }
                else if (pattern.contains("STATUS")) {
                    text = text.replaceAll(pattern, subscription.getStatus().toString());
                }
                else if (pattern.contains("INVOICE_ID") && invoice != null) {
                    text = text.replaceAll(pattern, String.valueOf(invoice.getId()));
                }
                else if (pattern.contains("PASSWORD")) {
                    SubscriptionSetting setting = subscription.getSettingByType(ServiceSettingType.PASSWORD);
                    text = (setting != null) ? text.replaceAll(pattern, setting.getValue()) : text.replaceAll(pattern, "");
                }
                else if (pattern.contains("USERNAME")) {
                    SubscriptionSetting setting = subscription.getSettingByType(ServiceSettingType.USERNAME);
                    text = (setting != null) ? text.replaceAll(pattern, setting.getValue()) : text.replaceAll(pattern, "");
                }
                else if (pattern.contains("SUBSCRIBER")) {
                    text = text.replaceAll(pattern,
                            String.format("%s %s",
                                    subscription.getSubscriber().getDetails().getFirstName(),
                                    subscription.getSubscriber().getDetails().getSurname()
                            ));
                } else if (pattern.contains("VAS_SERVICE") && vas != null) {
                    text = text.replaceAll(pattern, vas.getName());
                } else if (pattern.contains("SMS_CODE")) {
                    text = text.replaceAll(pattern, subscription.getSubscriber().getRuntimeDetails().getSmsCode());
                }
            }
        }

        return text;
    }

}
