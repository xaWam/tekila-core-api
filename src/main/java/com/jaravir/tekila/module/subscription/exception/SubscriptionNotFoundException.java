/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jaravir.tekila.module.subscription.exception;

/**
 *
 * @author sajabrayilov
 */
public class SubscriptionNotFoundException extends Exception {
    public SubscriptionNotFoundException() {
        super();
    }
    
    public SubscriptionNotFoundException(String message) {
        super(message);
    }
    
}
