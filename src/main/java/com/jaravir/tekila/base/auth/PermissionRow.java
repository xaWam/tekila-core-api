package com.jaravir.tekila.base.auth;

import com.jaravir.tekila.base.auth.persistence.SubModule;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.jaravir.tekila.base.auth.Privilege;
import com.jaravir.tekila.base.auth.persistence.SubModule;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sajabrayilov on 12/10/2014.
 */
public class PermissionRow implements Serializable {
    private SubModule subModule;
    private List<Privilege> privilegeList;
    private List<String> selectedPrivilegeList;

    public PermissionRow() {
        privilegeList = new ArrayList<>();
    }

    public SubModule getSubModule() {
        return subModule;
    }

    public void setSubModule(SubModule subModule) {
        this.subModule = subModule;
    }

    public List<Privilege> getPrivilegeList() {
        return privilegeList;
    }

    public void setPrivilegeList(List<Privilege> privilegeList) {
        this.privilegeList = privilegeList;
    }

    public void addPrivilege (Privilege privilege) {
        if (!privilegeList.contains(privilege))
            privilegeList.add(privilege);
    }

    public List<String> getSelectedPrivilegeList() {
        return selectedPrivilegeList;
    }

    public void setSelectedPrivilegeList(List<String> selectedPrivilegeList) {
        this.selectedPrivilegeList = selectedPrivilegeList;
    }

    public List<Privilege> getSelectedPrivilegeListAsPrivs() {
        if (selectedPrivilegeList == null || selectedPrivilegeList.isEmpty())
            return null;
        List<Privilege> privList = new ArrayList<>();

        for (String priv : selectedPrivilegeList) {
            privList.add(Privilege.convertFromCode(priv));
        }

        return privList;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PermissionRow{");
        sb.append("subModule=").append(subModule);
        sb.append(", privilegeList=").append(privilegeList);
        sb.append(", selectedPrivilegeList=").append(selectedPrivilegeList);
        sb.append('}');
        return sb.toString();
    }
}
