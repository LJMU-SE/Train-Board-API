package train.Service;

import com.fasterxml.jackson.annotation.JsonProperty; // version 2.11.1

public class CallingPoint {
    @JsonProperty("locationName")
    public String getLocationName() {
        return this.locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    String locationName;

    @JsonProperty("crs")
    public String getCrs() {
        return this.crs;
    }

    public void setCrs(String crs) {
        this.crs = crs;
    }

    String crs;

    @JsonProperty("st")
    public String getSt() {
        return this.st;
    }

    public void setSt(String st) {
        this.st = st;
    }

    String st;

    @JsonProperty("et")
    public String getEt() {
        return this.et;
    }

    public void setEt(String et) {
        this.et = et;
    }

    String et;

    @JsonProperty("isCancelled")
    public boolean getIsCancelled() {
        return this.isCancelled;
    }

    public void setIsCancelled(boolean isCancelled) {
        this.isCancelled = isCancelled;
    }

    boolean isCancelled;

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

    @JsonProperty("affectedByDiversion")
    public boolean getAffectedByDiversion() {
        return this.affectedByDiversion;
    }

    public void setAffectedByDiversion(boolean affectedByDiversion) {
        this.affectedByDiversion = affectedByDiversion;
    }

    boolean affectedByDiversion;

    @JsonProperty("rerouteDelay")
    public int getRerouteDelay() {
        return this.rerouteDelay;
    }

    public void setRerouteDelay(int rerouteDelay) {
        this.rerouteDelay = rerouteDelay;
    }

    int rerouteDelay;

    @JsonProperty("cancelReason")
    public String getCancelReason() {
        return this.cancelReason;
    }

    public void setCancelReason(String cancelReason) {
        this.cancelReason = cancelReason;
    }

    String cancelReason;

    @JsonProperty("formation")
    public Formation getFormation() {
        return this.formation;
    }

    public void setFormation(Formation formation) {
        this.formation = formation;
    }

    Formation formation;

    @JsonProperty("at")
    public String getAt() {
        return this.at;
    }

    public void setAt(String at) {
        this.at = at;
    }

    String at;

    @JsonProperty("delayReason")
    public String getDelayReason() {
        return this.delayReason;
    }

    public void setDelayReason(String delayReason) {
        this.delayReason = delayReason;
    }

    String delayReason;

}
