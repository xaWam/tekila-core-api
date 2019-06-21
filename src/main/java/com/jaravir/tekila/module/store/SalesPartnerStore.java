package com.jaravir.tekila.module.store;

import com.jaravir.tekila.base.auth.persistence.User;
import com.jaravir.tekila.base.entity.BaseEntity;
import com.jaravir.tekila.module.sales.persistence.entity.SalesPartner;
import com.jaravir.tekila.module.store.equip.Equipment;
import org.joda.time.DateTime;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sajabrayilov on 11/24/2015.
 */
public class SalesPartnerStore extends BaseEntity implements Serializable {
    private String name;
    private SalesPartner owner;
    private List<Equipment> equipmentList;
    private User user;
    private DateTime creationDate;
    private String desc;

    public SalesPartnerStore () {
        equipmentList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SalesPartner getOwner() {
        return owner;
    }

    public void setOwner(SalesPartner owner) {
        this.owner = owner;
    }

    public List<Equipment> getEquipmentList() {
        return equipmentList;
    }

    public void setEquipmentList(List<Equipment> equipmentList) {
        this.equipmentList = equipmentList;
    }

    public void add (Equipment equipment) {
        equipmentList.add(equipment);
    }

    public void remove (Equipment equipment) {
        equipmentList.remove(equipment);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public DateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(DateTime createdDate) {
        this.creationDate = createdDate;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String dsc) {
        this.desc = dsc;
    }
}
