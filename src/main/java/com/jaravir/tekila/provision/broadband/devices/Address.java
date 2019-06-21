/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jaravir.tekila.provision.broadband.devices;

/**
 *
 * @author sajabrayilov
 */
public class Address {
    private String fullAddress;
    
    public Address (String addr) {
        this.fullAddress = addr;
    }
    
    public String getFullAddress() {
        return this.fullAddress;
    }
    
    public void setFullAddress(String addr) {
        this.fullAddress = addr;
    }
}
