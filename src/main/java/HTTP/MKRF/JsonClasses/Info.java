package HTTP.MKRF.JsonClasses;

import com.fasterxml.jackson.annotation.*;
import java.time.OffsetDateTime;

@lombok.Data
public class Info {
    @lombok.Getter(onMethod_ = {@JsonProperty("path")})
    @lombok.Setter(onMethod_ = {@JsonProperty("path")})
    private String path;
    @lombok.Getter(onMethod_ = {@JsonProperty("category")})
    @lombok.Setter(onMethod_ = {@JsonProperty("category")})
    private String category;
    @lombok.Getter(onMethod_ = {@JsonProperty("createDate")})
    @lombok.Setter(onMethod_ = {@JsonProperty("createDate")})
    private OffsetDateTime createDate;
    @lombok.Getter(onMethod_ = {@JsonProperty("updateDate")})
    @lombok.Setter(onMethod_ = {@JsonProperty("updateDate")})
    private OffsetDateTime updateDate;
}
