package com.jaravir.tekila.module.campaign;

import com.fasterxml.jackson.annotation.JsonView;
import com.jaravir.tekila.base.entity.BaseEntity;
import com.jaravir.tekila.jsonview.JsonViews;
import com.jaravir.tekila.module.service.entity.ValueAddedService;
import com.jaravir.tekila.module.subscription.persistence.entity.Subscription;
import com.jaravir.tekila.module.subscription.persistence.entity.SubscriptionStatus;
import org.joda.time.DateTime;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.List;

/**
 * Created by sajabrayilov on 5/29/2015.
 */
public class CampaignRegister extends BaseEntity {
    private Campaign campaign;
    @JsonView(JsonViews.CampaignRegister.class)
    private Subscription subscription;
    private DateTime joinDate;
    private DateTime processedDate;
    private int lifeCycleCount;
    private CampaignStatus status;
    private Long bonusAmount;
    private List<ValueAddedService> vasList;
    private Double serviceRateBonusAmount;
    private String campaignNotes;
    private DateTime bonusDate;
    private DateTime nobonusDate;

    public Campaign getCampaign() {
        return campaign;
    }

    public void setCampaign(Campaign campaign) {
        this.campaign = campaign;
    }

    public Subscription getSubscription() {
        return subscription;
    }

    public void setSubscription(Subscription subscription) {
        this.subscription = subscription;
    }

    public DateTime getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(DateTime joinDate) {
        this.joinDate = joinDate;
    }

    public int getLifeCycleCount() {
        return lifeCycleCount;
    }

    public void setLifeCycleCount(int lifeCycleCount) {
        this.lifeCycleCount = lifeCycleCount;
    }

    public CampaignStatus getStatus() {
        return status;
    }

    public void setStatus(CampaignStatus status) {
        this.status = status;
    }

    public DateTime getProcessedDate() {
        return processedDate;
    }

    public void setProcessedDate(DateTime processedDate) {
        this.processedDate = processedDate;
    }

    public Long getBonusAmount() {
        return bonusAmount;
    }

    public void setBonusAmount(Long bonusAmount) {
        this.bonusAmount = bonusAmount;
    }

    public List<ValueAddedService> getVasList() {
        return vasList;
    }

    public void setVasList(List<ValueAddedService> vasList) {
        this.vasList = vasList;
    }

    public Double getServiceRateBonusAmount() {
        return serviceRateBonusAmount;
    }

    public void setServiceRateBonusAmount(Double serviceRateBonusAmount) {
        this.serviceRateBonusAmount = serviceRateBonusAmount;
    }

    public String getCampaignNotes() {
        return campaignNotes;
    }

    public void setCampaignNotes(String campaignNotes) {
        this.campaignNotes = campaignNotes;
    }

    public DateTime getBonusDate() {
        return bonusDate;
    }

    public void setBonusDate(DateTime bonusDate) {
        this.bonusDate = bonusDate;
    }

    public DateTime getNobonusDate() {
        return nobonusDate;
    }

    public void setNobonusDate(DateTime nobonusDate) {
        this.nobonusDate = nobonusDate;
    }

    public void decrementLifecycleCount () {
        lifeCycleCount--;
    }

    public String getBonusAmountForView() {
        if (bonusAmount != null) {
            if (String.valueOf(bonusAmount).length() < 6) {
                return String.format("%d", bonusAmount);
            }

            double interim = bonusAmount / 100000d;
            DecimalFormat df = new DecimalFormat();
            df.setRoundingMode(RoundingMode.UNNECESSARY);
            return String.format("%.2f AZN", interim);
        } else if (serviceRateBonusAmount != null) {
            return String.format("%.1f %%", serviceRateBonusAmount * 100.0);
        }
        return "N/A";
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CampaignRegister{");
        sb.append("campaignId=").append(campaign.getId());
        sb.append(", joinDate=").append(joinDate);
        sb.append(", processedDate=").append(processedDate);
        sb.append(", lifeCycleCount=").append(lifeCycleCount);
        sb.append(", status=").append(status);
        sb.append(", bonusAmount=").append(bonusAmount);
        sb.append(", serviceRateBonusAmount=").append(serviceRateBonusAmount);
        sb.append(", campaignNotes='").append(campaignNotes).append('\'');
        sb.append(", bonusDate=").append(bonusDate);
        sb.append(", nobonusDate=").append(nobonusDate);
        sb.append('}');
        return sb.toString();
    }
}
