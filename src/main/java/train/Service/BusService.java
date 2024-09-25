package train.Service;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty; // version 2.11.1

public class BusService {
    @JsonProperty("subsequentCallingPoints")
    public ArrayList<SubsequentCallingPoint> getSubsequentCallingPoints() {
        return this.subsequentCallingPoints;
    }

    public void setSubsequentCallingPoints(ArrayList<SubsequentCallingPoint> subsequentCallingPoints) {
        this.subsequentCallingPoints = subsequentCallingPoints;
    }

    ArrayList<SubsequentCallingPoint> subsequentCallingPoints;

    @JsonProperty("futureCancellation")
    public boolean getFutureCancellation() {
        return this.futureCancellation;
    }

    public void setFutureCancellation(boolean futureCancellation) {
        this.futureCancellation = futureCancellation;
    }

    boolean futureCancellation;

    @JsonProperty("futureDelay")
    public boolean getFutureDelay() {
        return this.futureDelay;
    }

    public void setFutureDelay(boolean futureDelay) {
        this.futureDelay = futureDelay;
    }

    boolean futureDelay;

    @JsonProperty("origin")
    public ArrayList<Origin> getOrigin() {
        return this.origin;
    }

    public void setOrigin(ArrayList<Origin> origin) {
        this.origin = origin;
    }

    ArrayList<Origin> origin;

    @JsonProperty("destination")
    public ArrayList<Destination> getDestination() {
        return this.destination;
    }

    public void setDestination(ArrayList<Destination> destination) {
        this.destination = destination;
    }

    ArrayList<Destination> destination;

    @JsonProperty("std")
    public String getStd() {
        return this.std;
    }

    public void setStd(String std) {
        this.std = std;
    }

    String std;

    @JsonProperty("etd")
    public String getEtd() {
        return this.etd;
    }

    public void setEtd(String etd) {
        this.etd = etd;
    }

    String etd;

    @JsonProperty("platform")
    public String getPlatform() {
        return this.platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    String platform;

    @JsonProperty("operator")
    public String getOperator() {
        return this.operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    String operator;

    @JsonProperty("operatorCode")
    public String getOperatorCode() {
        return this.operatorCode;
    }

    public void setOperatorCode(String operatorCode) {
        this.operatorCode = operatorCode;
    }

    String operatorCode;

    @JsonProperty("isCircularRoute")
    public boolean getIsCircularRoute() {
        return this.isCircularRoute;
    }

    public void setIsCircularRoute(boolean isCircularRoute) {
        this.isCircularRoute = isCircularRoute;
    }

    boolean isCircularRoute;

    @JsonProperty("isCancelled")
    public boolean getIsCancelled() {
        return this.isCancelled;
    }

    public void setIsCancelled(boolean isCancelled) {
        this.isCancelled = isCancelled;
    }

    boolean isCancelled;

    @JsonProperty("filterLocationCancelled")
    public boolean getFilterLocationCancelled() {
        return this.filterLocationCancelled;
    }

    public void setFilterLocationCancelled(boolean filterLocationCancelled) {
        this.filterLocationCancelled = filterLocationCancelled;
    }

    boolean filterLocationCancelled;

    @JsonProperty("serviceType")
    public String getServiceType() {
        return this.serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    String serviceType;

    @JsonProperty("length")
    public int getLength() {
        return this.length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    int length;

    @JsonProperty("detachFront")
    public boolean getDetachFront() {
        return this.detachFront;
    }

    public void setDetachFront(boolean detachFront) {
        this.detachFront = detachFront;
    }

    boolean detachFront;

    @JsonProperty("isReverseFormation")
    public boolean getIsReverseFormation() {
        return this.isReverseFormation;
    }

    public void setIsReverseFormation(boolean isReverseFormation) {
        this.isReverseFormation = isReverseFormation;
    }

    boolean isReverseFormation;

    @JsonProperty("serviceID")
    public String getServiceID() {
        return this.serviceID;
    }

    public void setServiceID(String serviceID) {
        this.serviceID = serviceID;
    }

    String serviceID;
}
