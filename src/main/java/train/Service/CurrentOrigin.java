package train.Service;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CurrentOrigin{
    @JsonProperty("locationName") 
    public String getLocationName() { 
		 return this.locationName; } 
    public void setLocationName(String locationName) { 
		 this.locationName = locationName; } 
    String locationName;
    @JsonProperty("crs") 
    public String getCrs() { 
		 return this.crs; } 
    public void setCrs(String crs) { 
		 this.crs = crs; } 
    String crs;
    @JsonProperty("assocIsCancelled") 
    public boolean getAssocIsCancelled() { 
		 return this.assocIsCancelled; } 
    public void setAssocIsCancelled(boolean assocIsCancelled) { 
		 this.assocIsCancelled = assocIsCancelled; } 
    boolean assocIsCancelled;
}
