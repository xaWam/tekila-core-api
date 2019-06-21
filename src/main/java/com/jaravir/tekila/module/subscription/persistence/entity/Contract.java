package com.jaravir.tekila.module.subscription.persistence.entity;

import com.jaravir.tekila.base.auth.persistence.User;
import com.jaravir.tekila.base.entity.BaseEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sajabrayilov on 09.02.2015.
 */
public class Contract extends BaseEntity {
    private byte[] document;
    private List<Addendum> addendumList;
    private User user;

    public Contract() {
        addendumList = new ArrayList<>();
    }

    public byte[] getDocument() {
        return document;
    }

    public void setDocument(byte[] document) {
        this.document = document;
    }

    public List<Addendum> getAddendumList() {
        return addendumList;
    }

    public void setAddendumList(List<Addendum> addendumList) {
        this.addendumList = addendumList;
    }

    public void addAddendum(Addendum addendum) {
        addendumList.add(addendum);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
