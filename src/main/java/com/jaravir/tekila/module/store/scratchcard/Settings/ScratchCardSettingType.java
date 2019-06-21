package com.jaravir.tekila.module.store.scratchcard.Settings;

/**
 * Created by shnovruzov on 5/5/2016.
 */
public enum ScratchCardSettingType {
    BLOCKING(0);

    public final int TYPE;

    private ScratchCardSettingType(int code) {
        this.TYPE = code;
    }

    public static ScratchCardSettingType convertFromCode(int code) {
        for (ScratchCardSettingType s : ScratchCardSettingType.values())
            if (s.TYPE == code)
                return s;

        return null;
    }

}
