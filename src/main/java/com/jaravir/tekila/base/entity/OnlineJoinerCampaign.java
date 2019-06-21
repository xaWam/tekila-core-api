package com.jaravir.tekila.base.entity;

/**
 * @author ElmarMa on 7/31/2018
 */
public class OnlineJoinerCampaign extends BaseEntity {

    private long campaignId;
    private long amount;

    public long getCampaignId() {
        return campaignId;
    }

    public void setCampaignId(long campaignId) {
        this.campaignId = campaignId;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "OnlineJoinerCampaign{" +
                "campaignId=" + campaignId +
                ", amount=" + amount +
                '}';
    }
}
