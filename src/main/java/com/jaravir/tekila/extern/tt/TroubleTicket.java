package com.jaravir.tekila.extern.tt;

import com.jaravir.tekila.base.entity.BaseEntity;

import java.util.Date;

/**
 * Created by sajabrayilov on 12/16/2014.
 */
public class TroubleTicket extends BaseEntity {
    private String group;
    private String responsiblePerson;
    private String status;
    private String classification;
    private String creator;
    private Date created;
    private String agreement;

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getResponsiblePerson() {
        return responsiblePerson;
    }

    public void setResponsiblePerson(String responsiblePerson) {
        this.responsiblePerson = responsiblePerson;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreattor(String creattor) {
        this.creator = creattor;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public String getAgreement() {
        return agreement;
    }

    public void setAgreement(String agreement) {
        this.agreement = agreement;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("TroubleTicket{");
        sb.append(super.toString());
        sb.append(", group='").append(group).append('\'');
        sb.append(", responsiblePerson='").append(responsiblePerson).append('\'');
        sb.append(", status='").append(status).append('\'');
        sb.append(", creator='").append(creator).append('\'');
        sb.append(", created=").append(created);
        sb.append(", agreement=").append(agreement);
        sb.append('}');
        return sb.toString();
    }
}