package com.jaravir.tekila.base.auth.module;

import com.jaravir.tekila.base.auth.persistence.SubModule;

/**
 * Created by sajabrayilov on 12/15/2014.
 */
public enum Submodule {
    SUBSCRIPTION (Module.SUBSCRIPTION),
    SUBSCRIBER (Module.SUBSCRIPTION);

    private final Module module;

    Submodule (Module module) {
        this.module = module;
    }
}
