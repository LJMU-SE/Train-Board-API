package train.Service;

import java.util.ArrayList;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty; // version 2.11.1

// @JsonIgnoreProperties(ignoreUnknown = true)
public class Root {
    @JsonProperty("trainServices")
    public ArrayList<TrainService> getTrainServices() {
        return this.trainServices;
    }

    public void setTrainServices(ArrayList<TrainService> trainServices) {
        this.trainServices = trainServices;
    }

    ArrayList<TrainService> trainServices;

    @JsonProperty("busServices")
    public ArrayList<BusService> getBusServices() {
        return this.busServices;
    }

    public void setBusServices(ArrayList<BusService> busServices) {
        this.busServices = busServices;
    }

    ArrayList<BusService> busServices;

    @JsonProperty("Xmlns")
    public Xmlns getXmlns() {
        return this.xmlns;
    }

    public void setXmlns(Xmlns xmlns) {
        this.xmlns = xmlns;
    }

    Xmlns xmlns;

    @JsonProperty("generatedAt")
    public Date getGeneratedAt() {
        return this.generatedAt;
    }

    public void setGeneratedAt(Date generatedAt) {
        this.generatedAt = generatedAt;
    }

    Date generatedAt;

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

    @JsonProperty("filterLocationName")
    public String getFilterLocationName() {
        return this.filterLocationName;
    }

    public void setFilterLocationName(String filterLocationName) {
        this.filterLocationName = filterLocationName;
    }

    String filterLocationName;

    @JsonProperty("filtercrs")
    public String getFiltercrs() {
        return this.filtercrs;
    }

    public void setFiltercrs(String filtercrs) {
        this.filtercrs = filtercrs;
    }

    String filtercrs;

    @JsonProperty("filterType")
    public String getFilterType() {
        return this.filterType;
    }

    public void setFilterType(String filterType) {
        this.filterType = filterType;
    }

    String filterType;

    @JsonProperty("nrccMessages")
    public ArrayList<NrccMessage> getNrccMessages() {
        return this.nrccMessages;
    }

    public void setNrccMessages(ArrayList<NrccMessage> nrccMessages) {
        this.nrccMessages = nrccMessages;
    }

    ArrayList<NrccMessage> nrccMessages;

    @JsonProperty("platformAvailable")
    public boolean getPlatformAvailable() {
        return this.platformAvailable;
    }

    public void setPlatformAvailable(boolean platformAvailable) {
        this.platformAvailable = platformAvailable;
    }

    boolean platformAvailable;

    @JsonProperty("areServicesAvailable")
    public boolean getAreServicesAvailable() {
        return this.areServicesAvailable;
    }

    public void setAreServicesAvailable(boolean areServicesAvailable) {
        this.areServicesAvailable = areServicesAvailable;
    }

    boolean areServicesAvailable;
}
