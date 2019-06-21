package com.jaravir.tekila.test.module.event.notification.parser;

import com.jaravir.tekila.module.event.notification.parser.Parser;
import com.jaravir.tekila.module.subscription.persistence.entity.Subscription;
import org.junit.Test;

import java.util.logging.Logger;

import static org.junit.Assert.*;

public class ParserTest {
    private final static Logger log = Logger.getLogger("ParserTest");
    @Test
    public void testParseText() throws Exception {
        Parser parser = new Parser();
        String text = "NarHome. Контракт № {%BALANCE%} ";
        //log.info("Parsed text: " + parser.parseText(text, new Subscription()));
    }
}