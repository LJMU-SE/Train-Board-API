package train.Service;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Toilet {
    @JsonProperty("status")
    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    String status;

    @JsonProperty("Value")
    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    String value;
}