package com.jaravir.tekila.module.subscription.persistence.entity;

import java.io.Serializable;
import java.math.RoundingMode;
import java.text.DecimalFormat;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.jaravir.tekila.base.binding.xml.mapper.XmlSchemaNamespace;
import com.jaravir.tekila.base.entity.BaseEntity;


/**
 * Entity implementation class for Entity: Balance
 *
 */
@XmlRootElement
@XmlType(namespace=XmlSchemaNamespace.SUBSCRIPTION_NS)
public class Balance extends BaseEntity implements Serializable {

	private long realBalance; 
	private long promoBalance;
        private long virtualBalance;
        
	private static final long serialVersionUID = 1L;	
	
	public Balance() {
		super();		
	} 
	 
	@XmlAttribute
	public long getRealBalance() {
 		return this.realBalance;
	}

	public void setRealBalance(long realBalance) {
		this.realBalance = realBalance;                
		this.setLastUpdateDate();
	}
	
        public String getRealBalanceForView() {            
            double interm = realBalance / 100000d;
            //return Long.valueOf(interm).doubleValue();
			DecimalFormat df = new DecimalFormat();
			df.setRoundingMode(RoundingMode.FLOOR);
            return String.format("%.2f", interm);
        }
 
        public void setRealBalanceForView(double balance) { }
        
	@XmlAttribute  
	public long getPromoBalance() {
 		return this.promoBalance;
	}

	public void setPromoBalance(long promoBalance) {
		this.promoBalance = promoBalance;
		//this.setLastUpdateDate(); //done through pre-persist/pre-update in persistence
	}
	
        public String getPromoBalanceForView() {
            double interm = promoBalance / 100000d;
			DecimalFormat df = new DecimalFormat();
			df.setRoundingMode(RoundingMode.FLOOR);
            //return Long.valueOf(interm).doubleValue();
            return String.format("%.2f", interm);
        }
 
        public void setPromoBalanceForView(double balance) { }
         
	public void creditReal (long amount) {
		this.realBalance += amount;
	}
	
	public void debitReal (long amount) {
		this.realBalance -= amount;
	}

	public void creditPromo(long amount) {
		this.promoBalance += amount;
	}

	public void debitPromo (long amount) {
		this.promoBalance -= amount;
	}

	public void overwriteReal (long amount) {
		this.realBalance = amount;
	}

        public long getVirtualBalance() {
            return virtualBalance;
        }

        public void setVirtualBalance(long virtualBalance) {
            this.virtualBalance = virtualBalance;
        }
        
        public void creditVirtual (long amount) {
            this.virtualBalance += amount;
        }
        
        public void debitVirtual (long amount) {
            this.virtualBalance -= amount;
        }
        
        public void overwriteVirtual (long amount) {
            this.virtualBalance = amount;
        }
        
	@Override
	public String toString() {            
		return "Balance [realBalance=" + realBalance + 
                        ", promoBalance=" + promoBalance + 
                        ", virtualBalance=" + virtualBalance + 
                        ", id=" + id + 
                        ", lastUpdateDate=" + lastUpdateDate.toString() + "]";
	}	
}
