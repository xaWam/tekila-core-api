package com.jaravir.tekila.module.accounting.entity;

import com.jaravir.tekila.base.entity.BaseEntity;

/**
 * Created by shnovruzov on 8/15/2016.
 */
public class ChequeSequence extends BaseEntity{

    private Long chequeNum;

    public Long getChequeNum() {
        return chequeNum;
    }

    public void setChequeNum(Long chequeNum) {
        this.chequeNum = chequeNum;
    }
}
