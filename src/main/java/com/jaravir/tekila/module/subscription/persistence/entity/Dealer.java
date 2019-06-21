package com.jaravir.tekila.module.subscription.persistence.entity;

import com.jaravir.tekila.base.entity.BaseEntity;
import com.jaravir.tekila.module.service.entity.ServiceProvider;

/**
 * Created by khsadigov on 29/05/2017.
 */
public class Dealer extends BaseEntity {
    String name;
    boolean isDealWithSubscribers;
    boolean isDealWithCards;
    int discount;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isDealWithSubscribers() {
        return isDealWithSubscribers;
    }

    public void setDealWithSubscribers(boolean dealWithSubscribers) {
        isDealWithSubscribers = dealWithSubscribers;
    }

    public boolean isDealWithCards() {
        return isDealWithCards;
    }

    public void setDealWithCards(boolean dealWithCards) {
        isDealWithCards = dealWithCards;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }
}
