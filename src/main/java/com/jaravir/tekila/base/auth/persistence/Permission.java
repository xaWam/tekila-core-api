package com.jaravir.tekila.base.auth.persistence;

import com.jaravir.tekila.base.auth.Privilege;
import com.jaravir.tekila.base.entity.BaseEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sajabrayilov on 12/9/2014.
 */
public class Permission extends BaseEntity {
    private SubModule subModule;
    private List<Privilege> privilegeList;

    public SubModule getSubModule() {
        return subModule;
    }

    public void setSubModule(SubModule subModule) {
        this.subModule = subModule;
    }

    public List<Privilege> getPrivilege() {
        return privilegeList;
    }

    public void setPrivilege(List<Privilege> privilege) {
        this.privilegeList = privilege;
    }

    public void addPrivilege (Privilege privilege) {
        if (privilegeList == null)
            privilegeList = new ArrayList<>();

        privilegeList.add(privilege);
    }

    public String getPriviligesForView() {
        StringBuilder sb = new StringBuilder();

        for (Privilege privilege : privilegeList) {
            sb.append(privilege).append(", ");
        }

        return sb.delete(sb.lastIndexOf(","), sb.length() - 1).toString();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Permission{");
        sb.append(super.toString());
        sb.append("subModule=").append(subModule);
        sb.append(", privileges=").append(privilegeList);
        sb.append('}');
        return sb.toString();
    }
}
