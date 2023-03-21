package HTTP.MKRF.JsonClasses;

import com.fasterxml.jackson.annotation.*;
import java.util.List;

@lombok.Data
public class Organization {
    @lombok.Getter(onMethod_ = {@JsonProperty("id")})
    @lombok.Setter(onMethod_ = {@JsonProperty("id")})
    private long id;
    @lombok.Getter(onMethod_ = {@JsonProperty("name")})
    @lombok.Setter(onMethod_ = {@JsonProperty("name")})
    private String name;
    @lombok.Getter(onMethod_ = {@JsonProperty("type")})
    @lombok.Setter(onMethod_ = {@JsonProperty("type")})
    private String type;
    @lombok.Getter(onMethod_ = {@JsonProperty("subordinationIds")})
    @lombok.Setter(onMethod_ = {@JsonProperty("subordinationIds")})
    private List<Long> subordinationIDS;
    @lombok.Getter(onMethod_ = {@JsonProperty("subordination")})
    @lombok.Setter(onMethod_ = {@JsonProperty("subordination")})
    private Category subordination;
    @lombok.Getter(onMethod_ = {@JsonProperty("localeIds")})
    @lombok.Setter(onMethod_ = {@JsonProperty("localeIds")})
    private List<Object> localeIDS;
    @lombok.Getter(onMethod_ = {@JsonProperty("locale")})
    @lombok.Setter(onMethod_ = {@JsonProperty("locale")})
    private Category locale;
}
