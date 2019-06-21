package com.jaravir.tekila.base.auth.persistence;

import com.jaravir.tekila.base.entity.BaseEntity;

import java.util.List;

/**
 * Created by sajabrayilov on 12/8/2014.
 */
public class Module extends BaseEntity {
    private String name;
    private List<SubModule> subModules;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<SubModule> getSubModules() {
        return subModules;
    }

    public void setSubModules(List<SubModule> subModules) {
        this.subModules = subModules;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Module{");
        sb.append(super.toString());
        sb.append(", name='").append(name).append('\'');
        //sb.append(", submodule=").append(subModules);
        sb.append('}');
        return sb.toString();
    }
}
