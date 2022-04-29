
package com.erole.moviErole.APIQuery.model.contentQuery;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "budget",
    "openingWeekendUSA",
    "grossUSA",
    "cumulativeWorldwideGross"
})
@Generated("jsonschema2pojo")
public class BoxOffice {

    @JsonProperty("budget")
    private String budget;
    @JsonProperty("openingWeekendUSA")
    private String openingWeekendUSA;
    @JsonProperty("grossUSA")
    private String grossUSA;
    @JsonProperty("cumulativeWorldwideGross")
    private String cumulativeWorldwideGross;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("budget")
    public String getBudget() {
        return budget;
    }

    @JsonProperty("budget")
    public void setBudget(String budget) {
        this.budget = budget;
    }

    @JsonProperty("openingWeekendUSA")
    public String getOpeningWeekendUSA() {
        return openingWeekendUSA;
    }

    @JsonProperty("openingWeekendUSA")
    public void setOpeningWeekendUSA(String openingWeekendUSA) {
        this.openingWeekendUSA = openingWeekendUSA;
    }

    @JsonProperty("grossUSA")
    public String getGrossUSA() {
        return grossUSA;
    }

    @JsonProperty("grossUSA")
    public void setGrossUSA(String grossUSA) {
        this.grossUSA = grossUSA;
    }

    @JsonProperty("cumulativeWorldwideGross")
    public String getCumulativeWorldwideGross() {
        return cumulativeWorldwideGross;
    }

    @JsonProperty("cumulativeWorldwideGross")
    public void setCumulativeWorldwideGross(String cumulativeWorldwideGross) {
        this.cumulativeWorldwideGross = cumulativeWorldwideGross;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(BoxOffice.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("budget");
        sb.append('=');
        sb.append(((this.budget == null)?"<null>":this.budget));
        sb.append(',');
        sb.append("openingWeekendUSA");
        sb.append('=');
        sb.append(((this.openingWeekendUSA == null)?"<null>":this.openingWeekendUSA));
        sb.append(',');
        sb.append("grossUSA");
        sb.append('=');
        sb.append(((this.grossUSA == null)?"<null>":this.grossUSA));
        sb.append(',');
        sb.append("cumulativeWorldwideGross");
        sb.append('=');
        sb.append(((this.cumulativeWorldwideGross == null)?"<null>":this.cumulativeWorldwideGross));
        sb.append(',');
        sb.append("additionalProperties");
        sb.append('=');
        sb.append(((this.additionalProperties == null)?"<null>":this.additionalProperties));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.grossUSA == null)? 0 :this.grossUSA.hashCode()));
        result = ((result* 31)+((this.openingWeekendUSA == null)? 0 :this.openingWeekendUSA.hashCode()));
        result = ((result* 31)+((this.cumulativeWorldwideGross == null)? 0 :this.cumulativeWorldwideGross.hashCode()));
        result = ((result* 31)+((this.budget == null)? 0 :this.budget.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof BoxOffice) == false) {
            return false;
        }
        BoxOffice rhs = ((BoxOffice) other);
        return ((((((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties)))&&((this.grossUSA == rhs.grossUSA)||((this.grossUSA!= null)&&this.grossUSA.equals(rhs.grossUSA))))&&((this.openingWeekendUSA == rhs.openingWeekendUSA)||((this.openingWeekendUSA!= null)&&this.openingWeekendUSA.equals(rhs.openingWeekendUSA))))&&((this.cumulativeWorldwideGross == rhs.cumulativeWorldwideGross)||((this.cumulativeWorldwideGross!= null)&&this.cumulativeWorldwideGross.equals(rhs.cumulativeWorldwideGross))))&&((this.budget == rhs.budget)||((this.budget!= null)&&this.budget.equals(rhs.budget))));
    }

}
