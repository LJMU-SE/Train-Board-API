package train.Service;

import com.fasterxml.jackson.annotation.JsonProperty; // version 2.11.1

public class Xmlns {
    @JsonProperty("Count")
    public int getCount() {
        return this.count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    int count;
}
