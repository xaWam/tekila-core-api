package com.jaravir.tekila.base.auth.persistence;

import com.fasterxml.jackson.annotation.JsonView;
import com.jaravir.tekila.base.auth.Privilege;
import com.jaravir.tekila.base.entity.BaseEntity;
import com.jaravir.tekila.jsonview.JsonViews;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by sajabrayilov on 12/8/2014.
 */
public class SubModule extends BaseEntity {
    private String name;
    @JsonView(JsonViews.Submodule.class)
    private Module module;
    private Map<String, Privilege> pathMap;

    public SubModule () {
        pathMap = new ConcurrentHashMap<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }

    public Map<String, Privilege> getPathMap() {
        return pathMap;
    }

    public void setPathMap(Map<String, Privilege> pathMap) {
        this.pathMap = pathMap;
    }

    public Privilege getPrivilege (String path) {
        return pathMap.get(path);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        SubModule subModule = (SubModule) o;

        if (module != null ? !module.equals(subModule.module) : subModule.module != null) return false;
        if (name != null ? !name.equals(subModule.name) : subModule.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (module != null ? module.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("SubModule{");
        sb.append(super.toString());
        sb.append(", name='").append(name).append('\'');
        sb.append(", pathMap=").append(pathMap);
        sb.append(", module=").append(module);
        sb.append('}');
        return sb.toString();
    }
}
