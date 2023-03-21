package HTTP.MKRF.JsonClasses;

import com.fasterxml.jackson.annotation.*;


import java.util.List;

@lombok.Data
public class Place {
    @lombok.Getter(onMethod_ = {@JsonProperty("address")})
    @lombok.Setter(onMethod_ = {@JsonProperty("address")})
    private Address address;
    @lombok.Getter(onMethod_ = {@JsonProperty("externalInfo")})
    @lombok.Setter(onMethod_ = {@JsonProperty("externalInfo")})
    private List<Object> externalInfo;
    @lombok.Getter(onMethod_ = {@JsonProperty("gallery")})
    @lombok.Setter(onMethod_ = {@JsonProperty("gallery")})
    private List<Object> gallery;
    @lombok.Getter(onMethod_ = {@JsonProperty("localeIds")})
    @lombok.Setter(onMethod_ = {@JsonProperty("localeIds")})
    private List<Long> localeIDS;
    @lombok.Getter(onMethod_ = {@JsonProperty("locale")})
    @lombok.Setter(onMethod_ = {@JsonProperty("locale")})
    private Category locale;
    @lombok.Getter(onMethod_ = {@JsonProperty("recommendations")})
    @lombok.Setter(onMethod_ = {@JsonProperty("recommendations")})
    private List<Object> recommendations;
    @lombok.Getter(onMethod_ = {@JsonProperty("seances")})
    @lombok.Setter(onMethod_ = {@JsonProperty("seances")})
    private List<Seance> seances;
    @lombok.Getter(onMethod_ = {@JsonProperty("tags")})
    @lombok.Setter(onMethod_ = {@JsonProperty("tags")})
    private List<Object> tags;
    @lombok.Getter(onMethod_ = {@JsonProperty("videoHostings")})
    @lombok.Setter(onMethod_ = {@JsonProperty("videoHostings")})
    private List<Object> videoHostings;
    @lombok.Getter(onMethod_ = {@JsonProperty("ticketReport")})
    @lombok.Setter(onMethod_ = {@JsonProperty("ticketReport")})
    private List<Object> ticketReport;
}
