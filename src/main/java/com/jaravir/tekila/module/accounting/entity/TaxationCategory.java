/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jaravir.tekila.module.accounting.entity;

import com.jaravir.tekila.base.entity.BaseEntity;

/**
 *
 * @author sajabrayilov
 */
public class TaxationCategory extends BaseEntity {
    private String name;
    private long VATRate;
    private String dsc;
    private boolean isDefault;
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getVATRate() {
        return VATRate;
    }

    public void setVATRate(long VATRate) {
        this.VATRate = VATRate;
    }   

    public String getDsc() {
        return dsc;
    }

    public void setDsc(String dsc) {
        this.dsc = dsc;
    }

    public boolean getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(boolean isDefault) {
        this.isDefault = isDefault;
    }

    @Override
    public int hashCode() {
        int hash = 3 * super.hashCode();
        hash = 97 * hash + (this.name != null ? this.name.hashCode() : 0);
        hash = 97 * hash + (int) (this.VATRate ^ (this.VATRate >>> 32));
        hash = 97 * hash + (this.dsc != null ? this.dsc.hashCode() : 0);
        hash = 97 * hash + (this.isDefault ? 1 : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        
        if (!super.equals(obj)) {
            return false;
        }
        
        final TaxationCategory other = (TaxationCategory) obj;
        if ((this.name == null) ? (other.name != null) : !this.name.equals(other.name)) {
            return false;
        }
        if (this.VATRate != other.VATRate) {
            return false;
        }
        if ((this.dsc == null) ? (other.dsc != null) : !this.dsc.equals(other.dsc)) {
            return false;
        }
        if (this.isDefault != other.isDefault) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("TaxactionCategory{");
        sb.append(super.toString());
        sb.append(", name=").append(name);
        sb.append(", VATRate=").append(VATRate);
        sb.append(" isDefault=").append(isDefault);
        sb.append(", dsc=").append(dsc);
        return sb.append('}').toString();
    }
}
