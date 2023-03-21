package HTTP.MKRF.JsonClasses;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


import java.util.UUID;

@Data
public class Address {
    @Getter(onMethod_ = {@JsonProperty("street")})
    @Setter(onMethod_ = {@JsonProperty("street")})
    private String street;
    @Getter(onMethod_ = {@JsonProperty("comment")})
    @Setter(onMethod_ = {@JsonProperty("comment")})
    private String comment;
    @Getter(onMethod_ = {@JsonProperty("fiasHouseId")})
    @Setter(onMethod_ = {@JsonProperty("fiasHouseId")})
    private UUID fiasHouseID;
    @Getter(onMethod_ = {@JsonProperty("fiasStreetId")})
    @Setter(onMethod_ = {@JsonProperty("fiasStreetId")})
    private UUID fiasStreetID;
    @Getter(onMethod_ = {@JsonProperty("fiasSettlementId")})
    @Setter(onMethod_ = {@JsonProperty("fiasSettlementId")})
    private UUID fiasSettlementID;
    @Getter(onMethod_ = {@JsonProperty("fiasAreaId")})
    @Setter(onMethod_ = {@JsonProperty("fiasAreaId")})
    private UUID fiasAreaID;
    @Getter(onMethod_ = {@JsonProperty("fiasRegionId")})
    @Setter(onMethod_ = {@JsonProperty("fiasRegionId")})
    private UUID fiasRegionID;
    @Getter(onMethod_ = {@JsonProperty("fullAddress")})
    @Setter(onMethod_ = {@JsonProperty("fullAddress")})
    private String fullAddress;
    @Getter(onMethod_ = {@JsonProperty("mapPosition")})
    @Setter(onMethod_ = {@JsonProperty("mapPosition")})
    private MapPosition mapPosition;
}
