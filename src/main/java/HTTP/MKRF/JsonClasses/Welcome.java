package HTTP.MKRF.JsonClasses;

import com.fasterxml.jackson.annotation.*;
import java.util.List;

@lombok.Data
public class Welcome {
    @lombok.Getter(onMethod_ = {@JsonProperty("status")})
    @lombok.Setter(onMethod_ = {@JsonProperty("status")})
    private long status;
    @lombok.Getter(onMethod_ = {@JsonProperty("nextPage")})
    @lombok.Setter(onMethod_ = {@JsonProperty("nextPage")})
    private String nextPage;
    @lombok.Getter(onMethod_ = {@JsonProperty("cursor")})
    @lombok.Setter(onMethod_ = {@JsonProperty("cursor")})
    private String cursor;
    @lombok.Getter(onMethod_ = {@JsonProperty("total")})
    @lombok.Setter(onMethod_ = {@JsonProperty("total")})
    private long total;
    @lombok.Getter(onMethod_ = {@JsonProperty("filter")})
    @lombok.Setter(onMethod_ = {@JsonProperty("filter")})
    private Filter filter;
    @lombok.Getter(onMethod_ = {@JsonProperty("o")})
    @lombok.Setter(onMethod_ = {@JsonProperty("o")})
    private boolean o;
    @lombok.Getter(onMethod_ = {@JsonProperty("s")})
    @lombok.Setter(onMethod_ = {@JsonProperty("s")})
    private long s;
    @lombok.Getter(onMethod_ = {@JsonProperty("l")})
    @lombok.Setter(onMethod_ = {@JsonProperty("l")})
    private long l;
    @lombok.Getter(onMethod_ = {@JsonProperty("data")})
    @lombok.Setter(onMethod_ = {@JsonProperty("data")})
    private List<Datum> data;
    @lombok.Getter(onMethod_ = {@JsonProperty("count")})
    @lombok.Setter(onMethod_ = {@JsonProperty("count")})
    private long count;
}
