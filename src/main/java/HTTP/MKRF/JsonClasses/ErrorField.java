package HTTP.MKRF.JsonClasses;

import com.fasterxml.jackson.annotation.*;


@lombok.Data
public class ErrorField {
    @lombok.Getter(onMethod_ = {@JsonProperty("keyword")})
    @lombok.Setter(onMethod_ = {@JsonProperty("keyword")})
    private String keyword;
    @lombok.Getter(onMethod_ = {@JsonProperty("dataPath")})
    @lombok.Setter(onMethod_ = {@JsonProperty("dataPath")})
    private String dataPath;
    @lombok.Getter(onMethod_ = {@JsonProperty("schemaPath")})
    @lombok.Setter(onMethod_ = {@JsonProperty("schemaPath")})
    private String schemaPath;
    @lombok.Getter(onMethod_ = {@JsonProperty("params")})
    @lombok.Setter(onMethod_ = {@JsonProperty("params")})
    private Params params;
    @lombok.Getter(onMethod_ = {@JsonProperty("message")})
    @lombok.Setter(onMethod_ = {@JsonProperty("message")})
    private String message;
}
