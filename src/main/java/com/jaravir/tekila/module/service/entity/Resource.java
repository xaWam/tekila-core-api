package com.jaravir.tekila.module.service.entity;

import com.jaravir.tekila.base.entity.BaseEntity;
import com.jaravir.tekila.module.service.SpecialDateRegister;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.CopyOnWriteArrayList;
import org.joda.time.DateTime;
import org.joda.time.DateTimeConstants;
import org.joda.time.LocalTime;

public class Resource extends BaseEntity implements Serializable{
	
	private static final long serialVersionUID = 8849529587751959671L;
	private String name;
	private List<ResourceBucket> bucketList; 
	private DateTime expirationDate;
	private LocalTime activeFrom;
	private LocalTime activeTill;
	private List<Integer> activeDaysOfWeekList;
	private boolean isActiveOnSpecialDays;
	private String dsc;
        
	public Resource () {
		this.bucketList = new CopyOnWriteArrayList<ResourceBucket>();		
		this.activeDaysOfWeekList = new CopyOnWriteArrayList<Integer>();
		this.isActiveOnSpecialDays = true;
	}

	public Resource(DateTime expirationDate,
			LocalTime activeFrom, LocalTime activeTill, List<Integer> activeDaysOfWeekList) {
		this();
		this.expirationDate = expirationDate;
		this.activeFrom = activeFrom;
		this.activeTill = activeTill;
		this.activeDaysOfWeekList = new CopyOnWriteArrayList<Integer>(activeDaysOfWeekList);
		
	}
	
	public Resource(Calendar expirationDate,
			LocalTime activeFrom, LocalTime activeTill, List<Integer> activeDaysOfWeek) {
		this(new DateTime(expirationDate), activeFrom, activeTill, activeDaysOfWeek);		
	}

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }	
        
	public List<ResourceBucket> getBucketList() {
		return bucketList;
	}

        public void setBucketList(List<ResourceBucket> bucketList) {
            this.bucketList = bucketList;
        }
        
	public DateTime getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(DateTime expirationDate) {
		this.expirationDate = expirationDate;
	}
        
	public LocalTime getActiveFrom() {
		return activeFrom;
	}

	public void setActiveFrom(LocalTime activeFrom) {
		this.activeFrom = activeFrom;
	}

	public LocalTime getActiveTill() {
		return activeTill;
	}

	public void setActiveTill(LocalTime activeTill) {
		this.activeTill = activeTill;
	}

	public List<Integer> getActiveDaysOfWeek() {
		return activeDaysOfWeekList;
	}

	public synchronized void setActiveDaysOfWeek(List<Integer> activeDaysOfWeekList) {
		this.activeDaysOfWeekList = new CopyOnWriteArrayList<Integer>(activeDaysOfWeekList);
	}
	
	public Calendar convertExpiratioDateToCalendar() {
		return this.expirationDate.toCalendar(
				new Locale("en")
				);
	}
	
	public void setExpirationDateFromCalendar(Calendar expDate) {
		this.expirationDate = new DateTime(expDate);
	}
	
	public void addBucket (ResourceBucket buck) {
		this.bucketList.add(buck);
	}
	
	public void addActiveDayOfWeek(int dayOfWeek) {
		this.activeDaysOfWeekList.add(dayOfWeek);
	}
	
	public boolean isExpired() {
		return this.expirationDate.isBeforeNow();
	}
	
	public boolean isInActivePeriod() {
		//this.isOnActiveWeekDays();
		return (DateTime.now().toLocalTime().isAfter(this.activeFrom) &&
		DateTime.now().toLocalTime().isBefore(this.activeTill));
	}
	/*
	 * Check present day is on the list of active weekdays
	 * 
	 * @return boolean - true if on active week day, false otherwise 
	 */
	public boolean isOnActiveWeekDays() {
		//TODO: return false on special days
		
		int dayOfWeek = DateTime.now().getDayOfWeek();
		//int dayOfWeek = DateTime.parse("13-04-2014", DateTimeFormat.forPattern("dd-MM-yyyy")).getDayOfWeek();
		Iterator<Integer> it = this.activeDaysOfWeekList.iterator();
		
		while (it.hasNext()) {
			if (it.next() == dayOfWeek)
				return true;
		}
		return false;
	}
	
	public ResourceBucket getBucketByType() {
	//TODO: search bucket list by type
		return null;
	}
	
        public Date getExpireAsDate() {
            if (expirationDate == null)
                return null;
            return this.expirationDate.toDate();
        }
        
        public void setExpireAsDate(Date expire) {
            this.expirationDate = new DateTime(expire);
        }
        
        public Date getActiveFromAsDate() {
            if (activeFrom == null)
                return null;
            //Calendar.getInstance().set(1970, Calendar.JANUARY, 1, this.activeFrom.getHourOfDay(), this.activeFrom.getMinuteOfHour());
            Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("Asia/Baku"));
            cal.set(1970, Calendar.JANUARY, 1, this.activeFrom.getHourOfDay(), this.activeFrom.getMinuteOfHour(), this.activeFrom.getSecondOfMinute());
            return cal.getTime();
        }
        
        public void setActiveFromAsDate (Date dt) {
            this.activeFrom = new LocalTime(dt);
        }
        
         public Date getActiveTillAsDate() {
             if (activeTill == null)
                 return null;
            //Calendar.getInstance().set(1970, Calendar.JANUARY, 1, this.activeFrom.getHourOfDay(), this.activeFrom.getMinuteOfHour());
            Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("Asia/Baku"));
            cal.set(1970, Calendar.JANUARY, 1, this.activeTill.getHourOfDay(), this.activeTill.getMinuteOfHour(), this.activeTill.getSecondOfMinute());
            return cal.getTime();
        }
        
        public void setActiveTillAsDate (Date dt) {
            this.activeTill = new LocalTime(dt);
        }
        
        public boolean removeBucket (ResourceBucket bucket) {
            return bucketList.remove(bucket);
        }
        
        public boolean addBuckets(List<ResourceBucket> bucketList) {
            return this.bucketList.addAll(bucketList);
        }
        
        public List<String> getListOfBucketIds () {
            if (bucketList == null || bucketList.isEmpty())
                return null;

            List<String> li = new ArrayList<String>();
            Iterator<ResourceBucket> it = bucketList.iterator();

            while (it.hasNext())
                li.add(String.valueOf(it.next().getId()));

            return li;
        }
	public boolean isActive() {
		if (this.isActiveOnSpecialDays 
				&& SpecialDateRegister.getInstance().isTodaySpecialDate() 
				&& this.isInActivePeriod() ) {
			return true;
		}
		
		else if (this.isOnActiveWeekDays() && this.isInActivePeriod()){
			return true;
		}
		
		else {
			return false;
		}
	}
	
	public void setActiveOnBusinessDays() {		
		this.activeDaysOfWeekList.add(DateTimeConstants.MONDAY);
		this.activeDaysOfWeekList.add(DateTimeConstants.TUESDAY);
		this.activeDaysOfWeekList.add(DateTimeConstants.WEDNESDAY);
		this.activeDaysOfWeekList.add(DateTimeConstants.THURSDAY);
		this.activeDaysOfWeekList.add(DateTimeConstants.FRIDAY);		
	}
        
        public void setActiveThroughWeek() {
            this.setActiveOnBusinessDays();
            this.addActiveDayOfWeek(DateTimeConstants.SATURDAY);
            this.addActiveDayOfWeek(DateTimeConstants.SUNDAY);
        }
        
        public String getDsc() {
            return dsc;
        }

        public void setDsc(String dsc) {
            this.dsc = dsc;
        }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + (this.name != null ? this.name.hashCode() : 0);
        hash = 53 * hash + (this.bucketList != null ? this.bucketList.hashCode() : 0);
        hash = 53 * hash + (this.expirationDate != null ? this.expirationDate.hashCode() : 0);
        hash = 53 * hash + (this.activeFrom != null ? this.activeFrom.hashCode() : 0);
        hash = 53 * hash + (this.activeTill != null ? this.activeTill.hashCode() : 0);
        hash = 53 * hash + (this.activeDaysOfWeekList != null ? this.activeDaysOfWeekList.hashCode() : 0);
        hash = 53 * hash + (this.isActiveOnSpecialDays ? 1 : 0);
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
        final Resource other = (Resource) obj;
        if ((this.name == null) ? (other.name != null) : !this.name.equals(other.name)) {
            return false;
        }
        if (this.bucketList != other.bucketList && (this.bucketList == null || !this.bucketList.equals(other.bucketList))) {
            return false;
        }
        if (this.expirationDate != other.expirationDate && (this.expirationDate == null || !this.expirationDate.equals(other.expirationDate))) {
            return false;
        }
        if (this.activeFrom != other.activeFrom && (this.activeFrom == null || !this.activeFrom.equals(other.activeFrom))) {
            return false;
        }
        if (this.activeTill != other.activeTill && (this.activeTill == null || !this.activeTill.equals(other.activeTill))) {
            return false;
        }
        if (this.activeDaysOfWeekList != other.activeDaysOfWeekList && (this.activeDaysOfWeekList == null || !this.activeDaysOfWeekList.equals(other.activeDaysOfWeekList))) {
            return false;
        }
        if (this.isActiveOnSpecialDays != other.isActiveOnSpecialDays) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder()
            .append("Resource{")
            .append("name=").append(name)
                .append(", bucketList=").append(bucketList)
                .append(", expirationDate=").append(expirationDate)
                .append(", activeFrom=").append(activeFrom)
                .append(", activeTill=").append(activeTill)
                .append(", activeDaysOfWeek=").append(activeDaysOfWeekList)
                .append(", isActiveOnSpecialDays=").append(isActiveOnSpecialDays)
                .append(", dsc=").append(dsc).append(", ")
                .append(super.toString())
                .append('}');    
        return builder.toString();
    }
    
    @Override
    public Resource clone() throws CloneNotSupportedException{
        
       Resource res = new Resource();
       res.setActiveDaysOfWeek(new ArrayList<Integer>(this.getActiveDaysOfWeek()));
       res.setBucketList(new ArrayList<ResourceBucket>(this.getBucketList()));
       res.setActiveTill(this.getActiveTill());
       res.setExpirationDate(this.getExpirationDate());
       res.setDsc(this.getDsc());
       res.setName(this.getName());
       
       return res;
    }
    

}
