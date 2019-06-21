package com.jaravir.tekila.test.provision.broadband.payment;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.*;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by sajabrayilov on 03.02.2015.
 */
public class AccountCheckerTest {
    public void testParse () {
        Logger log = Logger.getLogger("com.jaravir.test");
        String text = "<?xml version='1.0' encoding='UTF-8'?><data><accountresult>True</accountresult><accountname>Nigar M. B.</accountname></data>";
        Pattern pat = Pattern.compile("<accountresult>([^<]+)</accountresult>\\.*<accountname>([^<]+)</accountname>");
        Matcher mt = pat.matcher(text);

        boolean isFound = mt.find();

        log.info("Found?:" + isFound);

        if (isFound) {
            log.info(String.format("Match groups: 0=%s, 1=%s, 2=%s", mt.group(0), mt.group(1), mt.group(2)));

            boolean result = Boolean.valueOf(mt.group(1));
            if (result) {
                log.info("Account exists");
            }
        }
    }

    public void testCheckAccount() throws Exception {

        URL url = new URL("http://fttx-billing.azertelecom.az/card.aspx");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();

        con.setRequestMethod("POST");
        con.setRequestProperty("User-Agent", "Mozilla/5.0");
        con.setDoOutput(true);

        DataOutputStream out = new DataOutputStream(con.getOutputStream());
        out.writeBytes("function=account&login=farman&password=farman!azer2015fon!&accountid=121");
        out.flush();
        out.close();

        int responseCode = con.getResponseCode();

        BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine = null;
        StringBuffer buffer = new StringBuffer();

        while ((inputLine = reader.readLine()) != null) {
            buffer.append(inputLine);
        }

        reader.close();

    }
}
