package com.jaravir.tekila.test.module.event.notification.channel;

import com.cloudhopper.commons.charset.CharsetUtil;
import com.cloudhopper.commons.util.windowing.WindowFuture;
import com.cloudhopper.smpp.SmppBindType;
import com.cloudhopper.smpp.SmppConstants;
import com.cloudhopper.smpp.SmppSession;
import com.cloudhopper.smpp.SmppSessionConfiguration;
import com.cloudhopper.smpp.impl.DefaultSmppClient;
import com.cloudhopper.smpp.impl.DefaultSmppSessionHandler;
import com.cloudhopper.smpp.pdu.*;
import com.cloudhopper.smpp.tlv.Tlv;
import com.cloudhopper.smpp.type.Address;
import org.junit.Ignore;
import org.junit.Test;

import java.util.logging.Logger;

/**
 * Created by sajabrayilov on 1/9/2015.
 */
public class SmsNotifierTest {
    private final static Logger logger = Logger.getLogger("SMSNOTIFER");

    @Ignore
    @Test
    public void testSendSsms() throws Exception {
        DefaultSmppClient client = new DefaultSmppClient();
        DefaultSmppSessionHandler sessionHandler = new DefaultSmppSessionHandler();

        SmppSessionConfiguration config0 = new SmppSessionConfiguration();
        config0.setWindowSize(1);
        config0.setName("Tester.Session.0");
        config0.setType(SmppBindType.TRANSCEIVER);
        config0.setHost("10.13.166.105");
        config0.setPort(2775);
        config0.setConnectTimeout(10000);
        config0.setSystemId("tekila_bps");
        config0.setPassword("#tek1l@_!!");
        config0.getLoggingOptions().setLogBytes(true);
        // to enable monitoring (request expiration)
        config0.setRequestExpiryTimeout(30000);
        config0.setWindowMonitorInterval(15000);
        config0.setCountersEnabled(true);

        SmppSession session0 = null;

        try {
            session0 = client.bind(config0, sessionHandler);

            // and then optionally choose to pick when we wait for it
            WindowFuture<Integer,PduRequest,PduResponse> future0 = session0.sendRequestPdu(new EnquireLink(), 10000, true);
            if (!future0.await()) {
                logger.severe("Failed to receive enquire_link_resp within specified time");
            } else if (future0.isSuccess()) {
                EnquireLinkResp enquireLinkResp2 = (EnquireLinkResp)future0.getResponse();
                logger.info("enquire_link_resp #2: commandStatus [" + enquireLinkResp2.getCommandStatus() + "=" + enquireLinkResp2.getResultMessage() + "]");
            } else {
                logger.severe("Failed to properly receive enquire_link_resp: " + future0.getCause());
            }

            //String text160 = "\u20AC Lorem [ipsum] dolor sit amet, consectetur adipiscing elit. Proin feugiat, leo id commodo tincidunt, nibh diam ornare est, vitae accumsan risus lacus sed sem metus.";
            String text160 = "Hormetli A1bunechi, odenishiniz ugurla yerine yetirildi.NarHome xidmetinden istifade etdiyiniz uchun teshekkurler! Info:744/0365500744.."

                    ;
            byte[] textBytes = CharsetUtil.encode(text160, CharsetUtil.CHARSET_GSM);

            SubmitSm submit0 = new SubmitSm();

            // add delivery receipt
            //submit0.setRegisteredDelivery(SmppConstants.REGISTERED_DELIVERY_SMSC_RECEIPT_REQUESTED);
            submit0.setOptionalParameter(new Tlv(SmppConstants.TAG_MESSAGE_PAYLOAD, textBytes));
            submit0.setSourceAddress(new Address((byte)0x05, (byte)0x00, "NarHome"));
            submit0.setDestAddress(new Address((byte)0x01, (byte)0x01, "994772011329"));
            //submit0.setDestAddress(new Address((byte)0x01, (byte)0x01, "994772011329"));
            //submit0.setShortMessage(textBytes);
            submit0.setShortMessage("".getBytes());

            SubmitSmResp submitResp = session0.submit(submit0, 10000);

            logger.info(String.format("sendWindow.size: %s", session0.getSendWindow().getSize()));

                session0.unbind(5000);
        }
        catch (Exception  ex) {
            ex.printStackTrace();
        }

        if (session0 != null)
            session0.destroy();
    }
}
