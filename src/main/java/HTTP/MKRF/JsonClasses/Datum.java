package HTTP.MKRF.JsonClasses;

import com.fasterxml.jackson.annotation.*;

import java.time.OffsetDateTime;
import java.util.List;

@lombok.Data
public class Datum {
    @lombok.Getter(onMethod_ = {@JsonProperty("_id")})
    @lombok.Setter(onMethod_ = {@JsonProperty("_id")})
    private String id;
    @lombok.Getter(onMethod_ = {@JsonProperty("nativeId")})
    @lombok.Setter(onMethod_ = {@JsonProperty("nativeId")})
    private String nativeID;
    @lombok.Getter(onMethod_ = {@JsonProperty("hash")})
    @lombok.Setter(onMethod_ = {@JsonProperty("hash")})
    private OffsetDateTime hash;
    @lombok.Getter(onMethod_ = {@JsonProperty("data")})
    @lombok.Setter(onMethod_ = {@JsonProperty("data")})
    private Data data;
    @lombok.Getter(onMethod_ = {@JsonProperty("status")})
    @lombok.Setter(onMethod_ = {@JsonProperty("status")})
    private long status;
    @lombok.Getter(onMethod_ = {@JsonProperty("errorFields")})
    @lombok.Setter(onMethod_ = {@JsonProperty("errorFields")})
    private List<ErrorField> errorFields;
    @lombok.Getter(onMethod_ = {@JsonProperty("nativeName")})
    @lombok.Setter(onMethod_ = {@JsonProperty("nativeName")})
    private String nativeName;
    @lombok.Getter(onMethod_ = {@JsonProperty("activated")})
    @lombok.Setter(onMethod_ = {@JsonProperty("activated")})
    private OffsetDateTime activated;
    @lombok.Getter(onMethod_ = {@JsonProperty("created")})
    @lombok.Setter(onMethod_ = {@JsonProperty("created")})
    private OffsetDateTime created;
    @lombok.Getter(onMethod_ = {@JsonProperty("modified")})
    @lombok.Setter(onMethod_ = {@JsonProperty("modified")})
    private OffsetDateTime modified;
    @lombok.Getter(onMethod_ = {@JsonProperty("odSetVersions")})
    @lombok.Setter(onMethod_ = {@JsonProperty("odSetVersions")})
    private List<String> odSetVersions;
    @lombok.Getter(onMethod_ = {@JsonProperty("odSetVersion")})
    @lombok.Setter(onMethod_ = {@JsonProperty("odSetVersion")})
    private String odSetVersion;
    @lombok.Getter(onMethod_ = {@JsonProperty("updateSession")})
    @lombok.Setter(onMethod_ = {@JsonProperty("updateSession")})
    private String updateSession;
    @lombok.Getter(onMethod_ = {@JsonProperty("odSchema")})
    @lombok.Setter(onMethod_ = {@JsonProperty("odSchema")})
    private String odSchema;
    @lombok.Getter(onMethod_ = {@JsonProperty("dataset")})
    @lombok.Setter(onMethod_ = {@JsonProperty("dataset")})
    private String dataset;


}
