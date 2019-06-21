package com.jaravir.tekila.base.auth.persistence;

import com.jaravir.tekila.base.auth.Privilege;
import com.jaravir.tekila.base.auth.persistence.exception.NoPrivilegeFoundException;
import com.jaravir.tekila.base.entity.BaseEntity;
import com.jaravir.tekila.module.service.entity.ServiceProvider;

import java.util.List;

/**
 * Created by sajabrayilov on 12/8/2014.
 */
public class Role extends BaseEntity{
    private String name;
    private ServiceProvider provider;
    private List<Permission> permissions;
    private Module module;
    private String dsc;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }

    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }

    public ServiceProvider getProvider() {
        return provider;
    }

    public void setProvider(ServiceProvider provider) {
        this.provider = provider;
    }

    public String getDsc() {
        return dsc;
    }

    public void setDsc(String dsc) {
        this.dsc = dsc;
    }

    public boolean hasPrivilege (String subModule, Privilege privilege) throws NoPrivilegeFoundException {
        if (subModule == null)
            throw new IllegalArgumentException("Submodule is required");
        //System.out.println("Submodule is " + subModule);
        Permission permission = null;
        for (Permission perm : getPermissions()) {
           //System.out.println("Role - suModule name=" + perm.getSubModule().getName() + " - " + perm.getSubModule().getName().toLowerCase().equals(subModule.toLowerCase()));

            if (perm.getSubModule().getName().toLowerCase().equals(subModule.toLowerCase())) {
                permission = perm;
               //System.out.println("Permission is: " + permission.getPrivilege());

                break;
            }
        }
        if (permission == null)
            throw new NoPrivilegeFoundException();
        //System.out.println("Privilege is: " + privilege);

        for (Privilege priv : permission.getPrivilege()) {
            //System.out.println("Priv is: " + priv);
            if (priv.equals(privilege)) {
                //System.out.println("Privilege matched. Returning true");
                return true;
            }
        }

        throw new NoPrivilegeFoundException();
    }

    public boolean hasPrivilegeForModule (String moduleName, Privilege privilege) throws NoPrivilegeFoundException {
        if (moduleName == null)
            throw new IllegalArgumentException("Module is required");

        if (!getModule().getName().equals(moduleName))
            throw new NoPrivilegeFoundException();

        boolean permitted = false;

        for (Permission perm : getPermissions()) {
            for (Privilege priv : perm.getPrivilege()) {
                if (priv.equals(privilege)) {
                   permitted = true;
                }
            }
            if (!permitted)
                throw new NoPrivilegeFoundException();

            permitted = false;
        }

        return true;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Role{");
        sb.append(super.toString());
        sb.append(", name='").append(name).append('\'');
        sb.append(", module=").append(module);
        sb.append(", serviceProvider='").append(provider).append('\'');
        sb.append(", permission=").append(permissions);
        sb.append(", desc=").append(dsc);
        sb.append('}');
        return sb.toString();
    }
}
