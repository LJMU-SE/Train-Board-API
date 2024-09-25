package train.Service;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Coach {
    @JsonProperty("coachClass")
    public String getCoachClass() {
        return this.coachClass;
    }

    public void setCoachClass(String coachClass) {
        this.coachClass = coachClass;
    }

    String coachClass;

    @JsonProperty("loadingSpecified")
    public boolean getLoadingSpecified() {
        return this.loadingSpecified;
    }

    public void setLoadingSpecified(boolean loadingSpecified) {
        this.loadingSpecified = loadingSpecified;
    }

    boolean loadingSpecified;

    @JsonProperty("number")
    public String getNumber() {
        return this.number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    String number;

    @JsonProperty("toilet")
    public Toilet getToilet() {
        return this.toilet;
    }

    public void setToilet(Toilet toilet) {
        this.toilet = toilet;
    }

    Toilet toilet;
}