package HTTP.MKRF.JsonClasses;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class Category {
    @Getter(onMethod_ = {@JsonProperty("type")})
    @Setter(onMethod_ = {@JsonProperty("type")})
    private String type;
    @Getter(onMethod_ = {@JsonProperty("name")})
    @Setter(onMethod_ = {@JsonProperty("name")})
    private String name;
    @Getter(onMethod_ = {@JsonProperty("sysName")})
    @Setter(onMethod_ = {@JsonProperty("sysName")})
    private String sysName;
    @Getter(onMethod_ = {@JsonProperty("id")})
    @Setter(onMethod_ = {@JsonProperty("id")})
    private long id;
    @Getter(onMethod_ = {@JsonProperty("timezone")})
    @Setter(onMethod_ = {@JsonProperty("timezone")})
    private String timezone;
}
