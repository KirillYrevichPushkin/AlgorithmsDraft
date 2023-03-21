package HTTP.MKRF.JsonClasses;

import com.fasterxml.jackson.annotation.*;

@lombok.Data
public class Recommendation {
    @lombok.Getter(onMethod_ = {@JsonProperty("name")})
    @lombok.Setter(onMethod_ = {@JsonProperty("name")})
    private String name;
    @lombok.Getter(onMethod_ = {@JsonProperty("id")})
    @lombok.Setter(onMethod_ = {@JsonProperty("id")})
    private long id;
}
