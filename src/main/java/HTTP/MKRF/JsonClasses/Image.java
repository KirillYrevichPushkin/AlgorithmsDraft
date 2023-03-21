package HTTP.MKRF.JsonClasses;

import com.fasterxml.jackson.annotation.*;

@lombok.Data
public class Image {
    @lombok.Getter(onMethod_ = {@JsonProperty("url")})
    @lombok.Setter(onMethod_ = {@JsonProperty("url")})
    private String url;
    @lombok.Getter(onMethod_ = {@JsonProperty("title")})
    @lombok.Setter(onMethod_ = {@JsonProperty("title")})
    private String title;
}
