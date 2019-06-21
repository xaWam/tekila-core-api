/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jaravir.tekila.base.entity;

import java.util.Date;
import org.joda.time.DateTime;

/**
 *
 * @author sajabrayilov
 */
public class Test extends BaseEntity {    
    private DateTime dt;
    private DateTime dtDate;
    private Date creationDate;
    
    public DateTime getDt() {
        return dt;
    }

    public void setDt(DateTime dt) {
        this.dt = dt;
    }

    public DateTime getDtDate() {
        return dtDate;
    }

    public void setDtDate(DateTime dtDate) {
        this.dtDate = dtDate;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }    
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Test{id=").append(getId());
        
        if (dt != null) 
            sb.append(", dt=").append(dt.toString());
        
        if (dtDate != null)
            sb.append(", dtDate=").append(dtDate.toString());
        
        if (creationDate != null)
            sb.append(", createdOn=").append(creationDate.toString());
        
        return sb.append("}").toString();
    }
    
    
}
