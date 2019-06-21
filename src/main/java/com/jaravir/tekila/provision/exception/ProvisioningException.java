/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jaravir.tekila.provision.exception;

/**
 *
 * @author sajabrayilov
 */
public class ProvisioningException extends Exception {

    /**
     * Creates a new instance of <code>ProvisioningException</code> without
     * detail message.
     */
    public ProvisioningException() {
    }

    /**
     * Constructs an instance of <code>ProvisioningException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public ProvisioningException(String msg) {
        super(msg);
    }
    
    public ProvisioningException(Throwable cause) {
        super(cause);
    }
    
    public ProvisioningException (String message, Throwable cause) {
        super(message, cause);
    }
    
    
}
