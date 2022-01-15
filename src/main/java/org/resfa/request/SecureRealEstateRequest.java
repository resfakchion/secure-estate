package org.resfa.request;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({
        "costMin",
        "costMax",
        "floorMin",
        "floorMax",
        "limit",
})
@Schema(name = "Параметры недвижимости")
public class SecureRealEstateRequest {

    @Schema(example = "5.000.000.00", description = "Цена недвижимости")
    @Positive(message = "Цена недвижимости должна быть больше нуля")
    @Digits(integer = 9, fraction = 2, message = "Указана неверная цена недвижимости")
    @Min(value = 350_000, message = "Цена недвижимости не может быть меньше 350.000")
    @Max(value = 1_000_000_000, message = "Цена недвижимости не может быть больше 1.000.000.000")
    private Integer costMin;

    @Schema(example = "5.000.000.00", description = "Цена недвижимости")
    @Positive(message = "Цена недвижимости должна быть больше нуля")
    @Digits(integer = 9, fraction = 2, message = "Указана неверная цена недвижимости")
    @Min(value = 350_000, message = "Цена недвижимости не может быть меньше 350.000")
    @Max(value = 1_000_000_000, message = "Цена недвижимости не может быть больше 1.000.000.000")
    private Integer costMax;

    @Schema(example = "3", description = "Цена недвижимости")
    private String countFlat;

    private Integer floorMin;
    private Integer floorMax;
    private Integer limit;

    public SecureRealEstateRequest() {
    }

    public SecureRealEstateRequest(int costMin, int costMax, String countFlat, int floorMin, int floorMax, int limit) {
        this.costMin = costMin;
        this.costMax = costMax;
        this.countFlat = countFlat;
        this.floorMin = floorMin;
        this.floorMax = floorMax;
        this.limit = limit;
    }

    public Integer getCostMin() {
        return costMin;
    }

    public void setCostMin(Integer costMin) {
        this.costMin = costMin;
    }

    public Integer getCostMax() {
        return costMax;
    }

    public void setCostMax(Integer costMax) {
        this.costMax = costMax;
    }

    public String getCountFlat() {
        return countFlat;
    }

    public void setCountFlat(String countFlat) {
        this.countFlat = countFlat;
    }

    public Integer getFloorMin() {
        return floorMin;
    }

    public void setFloorMin(Integer floorMin) {
        this.floorMin = floorMin;
    }

    public Integer getFloorMax() {
        return floorMax;
    }

    public void setFloorMax(Integer floorMax) {
        this.floorMax = floorMax;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }
}

