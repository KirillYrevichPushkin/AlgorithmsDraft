package HTTP.MKRF.JsonClasses;

import com.fasterxml.jackson.annotation.*;


@lombok.Data
public class Filter {
    @lombok.Getter(onMethod_ = {@JsonProperty("odSetVersions")})
    @lombok.Setter(onMethod_ = {@JsonProperty("odSetVersions")})
    private OdSetVersions odSetVersions;
}
