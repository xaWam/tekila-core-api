package com.jaravir.tekila.module.store.ip;

import com.jaravir.tekila.module.store.ip.persistence.IpAddress;
import com.jaravir.tekila.module.store.ip.persistence.IpAddressRange;

/**
 * Created by shnovruzov on 10/22/2016.
 */
public class IpAddressResult {
    private IpAddress ipAddress;
    private IpAddressRange ipAddressRange;

    public IpAddressResult(IpAddress ipAddress, IpAddressRange ipAddressRange){
        this.ipAddress = ipAddress; this.ipAddressRange = ipAddressRange;
    }

    public IpAddress getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(IpAddress ipAddress) {
        this.ipAddress = ipAddress;
    }

    public IpAddressRange getIpAddressRange() {
        return ipAddressRange;
    }

    public void setIpAddressRange(IpAddressRange ipAddressRange) {
        this.ipAddressRange = ipAddressRange;
    }
}
