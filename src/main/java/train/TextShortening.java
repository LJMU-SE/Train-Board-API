package train;

import java.util.HashMap;

public class TextShortening {

    public String shortStationName(String station){

        HashMap<String, String> shortWords = new HashMap<String, String>();
        shortWords.put("Street", "St");
        shortWords.put("Saint", "St");
        shortWords.put("Lane", "Ln");
        shortWords.put("Road", "Rd");
        shortWords.put("Avenue", "Ave");
        shortWords.put("Drive", "Dr");
        shortWords.put("Boulevard", "Blvd");
        shortWords.put("International", "Int'l'");
        shortWords.put("Airport", "Apt'");
        shortWords.put("Station", "Stn'");
        shortWords.put("Terminal", "Trm'");
        shortWords.put("Terminals", "Trms'");
        shortWords.put("Hospital", "Hosp'");
        shortWords.put("Center", "Ctr'");
        shortWords.put("Central", "Ctrl'");
        shortWords.put("Junction", "Jct'");
        shortWords.put("Junctions", "Jcts'");
        shortWords.put("Place", "Pl'");
        shortWords.put("Plaza", "Plz'");
        shortWords.put("South", "Sth'");
        shortWords.put("North", "Nth'");
        shortWords.put("East", "Est'");
        shortWords.put("Western", "Wstn'");
        shortWords.put("West", "Wst'");
        shortWords.put("Parkway", "P'way'");
        shortWords.put("Park", "Pk'");
        shortWords.put("Hill", "Hl'");
        shortWords.put("Hills", "Hls'");
        shortWords.put("Valley", "Vly'");
        shortWords.put("Valleys", "Vlys'");
        shortWords.put("Mount", "Mt'");
        shortWords.put("Lake", "Lk'");
        shortWords.put("District", "Dist'");
        shortWords.put("Football Club", "FC'");
        shortWords.put("United", "Utd'");
        shortWords.put("Upon-Avon", "");
        shortWords.put("Technology", "Tech'");
        shortWords.put("Bridge", "Brg");
        shortWords.put("Bank", "Bnk");
        shortWords.put("Quay", "Qy");


        String[] stationWords = station.split(" ");

        for (String word : stationWords) {
            if (shortWords.containsKey(word)) {
                station = station.replace(word, shortWords.get(word));
            }
        }
 
        return station;

}

    public String shortCityNames(String station){
        HashMap<String, String> shortCities = new HashMap<String, String>();
        shortCities.put("Merseyside", "M'side");
        shortCities.put("Liverpool", "L'pool");
        shortCities.put("Manchester", "Man'c");
        shortCities.put("Wealdstone", "W'stone");
        shortCities.put("Birmingham", "B'ham");
        shortCities.put("Glasgow", "G'gow");
        shortCities.put("Edinburgh", "Edin'");
        shortCities.put("Newcastle", "N'castle");
        shortCities.put("Sheffield", "Sheff'");
        shortCities.put("Lancashire", "Lancs'");
        shortCities.put("Cardiff", "C'diff");
        shortCities.put("London", "L'don");
        shortCities.put("Nottingham", "Nott'm");
        shortCities.put("Oxford", "Ox'd");
        shortCities.put("Cambridge", "Camb'");
        shortCities.put("Southampton", "S'ton");
        shortCities.put("Brighton", "B'ton");
        shortCities.put("Plymouth", "P'mouth");
        shortCities.put("Birkenhead", "B'head");
        shortCities.put("Smethwick", "Sm'thwick");


        String[] stationWords = station.split("[^a-zA-Z0-9]+|[\\\\[\\\\](){}]");

        for (String word : stationWords) {
            if (shortCities.containsKey(word)) {
                station = station.replace(word, shortCities.get(word));
            }
        }
        return station;
    }
}