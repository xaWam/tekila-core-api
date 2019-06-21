package com.jaravir.tekila.module.archive.accounting;

import com.jaravir.tekila.base.auth.persistence.User;
import com.jaravir.tekila.base.entity.BaseEntity;
import com.jaravir.tekila.module.accounting.entity.Payment;
import com.jaravir.tekila.module.archive.ArchiveEntity;

import java.lang.reflect.Field;

/**
 * Created by sajabrayilov on 8/5/2015.
 */
public class PaymentArchived  extends Payment {
    private ArchiveEntity<Payment,PaymentArchived> archiveEntity;

    public PaymentArchived () {}

    public PaymentArchived (Payment source) {
        archiveEntity = new ArchiveEntity<>(source, this);
    }

    public PaymentArchived (Payment source, User user) {
        archiveEntity = new ArchiveEntity<>(source, this, user);
    }
}
