package com.jaravir.tekila.base.auth;

/**
 * Created by sajabrayilov on 02.03.2015.
 */
public class PathPrivilegeItem {
    private String subModuleName;
    private Privilege privilege;

    public PathPrivilegeItem(String subModuleName, Privilege privilege) {
        this.subModuleName = subModuleName;
        this.privilege = privilege;
    }

    public String getSubModuleName() {
        return subModuleName;
    }

    public void setSubModuleName(String subModuleName) {
        this.subModuleName = subModuleName;
    }

    public Privilege getPrivilege() {
        return privilege;
    }

    public void setPrivilege(Privilege privilege) {
        this.privilege = privilege;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PathPrivilegeItem that = (PathPrivilegeItem) o;

        if (subModuleName.equals(that.subModuleName)
            && privilege == that.privilege
                )
            return true;

        return false;
    }

    @Override
    public int hashCode() {
        int result = subModuleName.hashCode();
        result = 31 * result + privilege.hashCode();
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PathPrivilegeItem{");
        sb.append("subModuleName='").append(subModuleName).append('\'');
        sb.append(", privilege=").append(privilege);
        sb.append('}');
        return sb.toString();
    }
}
