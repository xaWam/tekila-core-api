/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jaravir.tekila.base.transaction.exception;

/**
 *
 * @author sajabrayilov
 */
public class TransactionFailedException extends Exception {
    public TransactionFailedException() {
        super();
    }
    
    public TransactionFailedException(String message) {
        super(message);
    }
}
