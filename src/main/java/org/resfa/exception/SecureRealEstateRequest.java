package org.resfa.exception;



import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import okhttp3.Address;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.List;

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
    private int costMin;

    @Schema(example = "5.000.000.00", description = "Цена недвижимости")
    @Positive(message = "Цена недвижимости должна быть больше нуля")
    @Digits(integer = 9, fraction = 2, message = "Указана неверная цена недвижимости")
    @Min(value = 350_000, message = "Цена недвижимости не может быть меньше 350.000")
    @Max(value = 1_000_000_000, message = "Цена недвижимости не может быть больше 1.000.000.000")
    private int costMax;

    @Schema(example = "3", description = "Цена недвижимости")
    private String countFlat;

    private int floorMin;
    private int floorMax;
    private int limit;

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

    public int getCostMin() {
        return costMin;
    }

    public int getCostMax() {
        return costMax;
    }

    public String getCountFlat() {
        return countFlat;
    }

    public int getFloorMin() {
        return floorMin;
    }

    public int getFloorMax() {
        return floorMax;
    }

    public int getLimit() {
        return limit;
    }

    public void setCostMin(int costMin) {
        this.costMin = costMin;
    }

    public void setCostMax(int costMax) {
        this.costMax = costMax;
    }

    public void setCountFlat(String countFlat) {
        this.countFlat = countFlat;
    }

    public void setFloorMin(int floorMin) {
        this.floorMin = floorMin;
    }

    public void setFloorMax(int floorMax) {
        this.floorMax = floorMax;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }
}

