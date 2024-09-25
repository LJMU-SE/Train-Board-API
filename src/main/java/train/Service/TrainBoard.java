package train.Service;

import java.util.ArrayList;

public class TrainBoard {

    String departureTime;
    String platformNo;
    String destination;
    ArrayList<CallingPoint> callingStations;
    String trainService;
    String onTime;
    int noCarriages;
    String cancelReason;
    String estTime;
    String origin;

    public String getOrigin(){
        return origin;
    }

    public void setOrigin(String origin){
        this.origin = origin;
    }
    
    public String getEstTime() {
        return estTime;
    }

    public void setEstTime(String estTime) {
        this.estTime = estTime;
    }

    public String getCancelReason() {
        return cancelReason;
    }

    public void setCancelReason(String cancelReason) {
        this.cancelReason = cancelReason;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getDepartureTime() {
        return this.departureTime;
    }

    public void setPlatformNo(String platformNo) {
        this.platformNo = platformNo;
    }

    public String getPlatformNo() {
        return this.platformNo;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDestination() {
        return this.destination;
    }

    public void setCallingStations(ArrayList<CallingPoint> callingStations) {
        this.callingStations = callingStations;
    }

    public ArrayList<CallingPoint> getCallingStations() {
        return this.callingStations;
    }

    public void setTrainService(String trainService) {
        this.trainService = trainService;
    }

    public String getTrainService() {
        return this.trainService;
    }

    public void setOnTime(String onTime) {
        this.onTime = onTime;
    }

    public String getOnTime(){
        return this.onTime;
    }

    public void setNoCarriages(int noCarriages) {
        this.noCarriages = noCarriages;
    }

    public int getNoCarriages(){
        return this.noCarriages;
    }

    
}
