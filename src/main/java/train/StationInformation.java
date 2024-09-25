package train;

public class StationInformation {

    String stationName;
    String crs;

    public StationInformation(String stationName, String crs) {
        this.stationName = stationName;
        this.crs = crs;
      }

    public String getStationName(){
        return this.stationName;
    }

    public String getCrs(){
        return this.crs;
    }
}