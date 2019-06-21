package com.jaravir.tekila.base.entity;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Locale;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

import org.joda.time.DateTime;

import java.util.TimeZone;

import com.jaravir.tekila.base.binding.xml.mapper.XmlSchemaNamespace;
import org.joda.time.DateTimeZone;

@XmlType(namespace = XmlSchemaNamespace.BASE_NS)
public class BaseEntity implements Serializable {
    protected long id;
    protected DateTime lastUpdateDate;
    private static final long serialVersionUID = 1L;

    public BaseEntity() {
        super();
        TimeZone.setDefault(TimeZone.getTimeZone("GMT+4"));
        System.setProperty("user.timezone", "GMT+4");
        DateTimeZone.setDefault(DateTimeZone.forTimeZone(TimeZone.getTimeZone("GMT+4")));
    }

    @XmlAttribute
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setLastUpdateDate() {
        this.lastUpdateDate = DateTime.now();
    }

    @XmlTransient
    public DateTime getLastUpdateDate() {
        return this.lastUpdateDate;
    }

    @XmlAttribute
    public Calendar getTimestamp() {
        return (this.lastUpdateDate != null ? this.lastUpdateDate.toCalendar(
                new Locale("en")
        ) : null);
    }

    public void setTimestamp(Calendar ts) {
        this.lastUpdateDate = new DateTime(ts);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
        result = prime * result
                + ((lastUpdateDate == null) ? 0 : lastUpdateDate.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof BaseEntity)) {
            return false;
        }
        BaseEntity other = (BaseEntity) obj;
        if (id != other.id) {
            return false;
        }
        if (lastUpdateDate == null) {
            if (other.lastUpdateDate != null) {
                return false;
            }
        } else if (!lastUpdateDate.equals(other.lastUpdateDate)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("id=");
        sb.append(id);
        sb.append(", lastUpdateDate=");
        sb.append(lastUpdateDate != null ? lastUpdateDate : null);
        return sb.toString();
    }
}
