/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jaravir.tekila.module.subscription.persistence.entity;

/**
 *
 * @author sajabrayilov
 */
public enum SubscriptionType {
   DYNAMIC(0), STATIC(1);
   
   public final int TYPE;

    private SubscriptionType(int code) {
        this.TYPE = code;        
    }
    
    public static SubscriptionType convertFromCode(int code) {
        for (SubscriptionType s : SubscriptionType.values())
            if (s.TYPE == code)
                return s;
        
        return null;        
    }
    
    
}
