package train.Service;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Formation {
    @JsonProperty("coaches")
    public ArrayList<Coach> getCoaches() {
        return this.coaches;
    }

    public void setCoaches(ArrayList<Coach> coaches) {
        this.coaches = coaches;
    }

    ArrayList<Coach> coaches;
}
