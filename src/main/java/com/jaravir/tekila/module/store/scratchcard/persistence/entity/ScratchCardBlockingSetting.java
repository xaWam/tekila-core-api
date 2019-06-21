package com.jaravir.tekila.module.store.scratchcard.persistence.entity;

import com.jaravir.tekila.base.entity.BaseEntity;
import com.jaravir.tekila.module.store.scratchcard.Settings.ScratchCardSettingType;
import com.jaravir.tekila.module.admin.setting.AdminSetting;
import org.joda.time.DateTime;

import java.io.Serializable;

/**
 * Created by shnovruzov on 5/5/2016.
 */
public class ScratchCardBlockingSetting extends BaseEntity {
    private int maxAttemptCount;
    private int blockingHours;

    public int getMaxAttemptCount() {
        return maxAttemptCount;
    }

    public void setMaxAttemptCount(int maxAttemptCount) {
        this.maxAttemptCount = maxAttemptCount;
    }

    public int getBlockingHours() {
        return blockingHours;
    }

    public void setBlockingHours(int blockingHours) {
        this.blockingHours = blockingHours;
    }

}
