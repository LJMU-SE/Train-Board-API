package train.Service;

import com.fasterxml.jackson.annotation.JsonProperty; // version 2.11.1

public class NrccMessage {
    @JsonProperty("Value")
    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    String value;
}
