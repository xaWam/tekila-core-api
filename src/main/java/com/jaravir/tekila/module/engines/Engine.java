package com.jaravir.tekila.module.engines;

import com.jaravir.tekila.base.entity.BaseEntity;
import com.jaravir.tekila.module.service.entity.ServiceProvider;

/**
 * Created by khsadigov on 5/16/2017.
 */
public class Engine extends BaseEntity {

    ServiceProvider provider;
    EngineType type;
    String jndiName;

    public ServiceProvider getProvider() {
        return provider;
    }

    public void setProvider(ServiceProvider provider) {
        this.provider = provider;
    }

    public EngineType getType() {
        return type;
    }

    public void setType(EngineType type) {
        this.type = type;
    }

    public String getJndiName() {
        return jndiName;
    }

    public void setJndiName(String jndiName) {
        this.jndiName = jndiName;
    }
}
