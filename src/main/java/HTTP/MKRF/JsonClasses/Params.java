package HTTP.MKRF.JsonClasses;

import com.fasterxml.jackson.annotation.*;

@lombok.Data
public class Params {
    @lombok.Getter(onMethod_ = {@JsonProperty("type")})
    @lombok.Setter(onMethod_ = {@JsonProperty("type")})
    private String type;
}
