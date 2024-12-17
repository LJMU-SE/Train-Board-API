package train;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class DataLoader {

    public ArrayList<StationInformation> loadCSV(){
    ArrayList<StationInformation> stations = new ArrayList<>();
    String line = "";
    String splitBy = ",";
    try {
        BufferedReader br = new BufferedReader(new FileReader("./src/main/java/train/Data/stations.csv"));
        while ((line = br.readLine()) != null) {
            String[] station = line.split(splitBy); // use comma as separator
            StationInformation stationInformation = new StationInformation(station[0], station[3]);
            stations.add(stationInformation);
        }
        br.close();
    } 
    catch(IOException e)
    {
        e.printStackTrace();
    }

    return stations;
    }

}