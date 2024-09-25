package train.Service;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty; // version 2.11.1

public class SubsequentCallingPoint {
    @JsonProperty("callingPoint")
    public ArrayList<CallingPoint> getCallingPoint() {
        return this.callingPoint;
    }

    public void setCallingPoint(ArrayList<CallingPoint> callingPoint) {
        this.callingPoint = callingPoint;
    }

    ArrayList<CallingPoint> callingPoint;

    @JsonProperty("serviceType")
    public String getServiceType() {
        return this.serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    String serviceType;

    @JsonProperty("serviceChangeRequired")
    public boolean getServiceChangeRequired() {
        return this.serviceChangeRequired;
    }

    public void setServiceChangeRequired(boolean serviceChangeRequired) {
        this.serviceChangeRequired = serviceChangeRequired;
    }

    boolean serviceChangeRequired;

    @JsonProperty("assocIsCancelled")
    public boolean getAssocIsCancelled() {
        return this.assocIsCancelled;
    }

    public void setAssocIsCancelled(boolean assocIsCancelled) {
        this.assocIsCancelled = assocIsCancelled;
    }

    boolean assocIsCancelled;

}