/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jaravir.tekila.module.store.scratchcard.persistence.entity;

import com.jaravir.tekila.base.entity.BaseEntity;

import java.io.Serializable;

/**
 *
 * @author shnovruzov
 */
public class BatchID extends BaseEntity implements Serializable{
    
    private long batchID;
    
    public long getBatchID(){
        return batchID;
    }
    
    public void setBatchID(long batchID){
        this.batchID = batchID;
    }
}
