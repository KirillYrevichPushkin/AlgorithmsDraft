package HTTP.MKRF.JsonClasses;

import com.fasterxml.jackson.annotation.*;
import lombok.Getter;
import lombok.Setter;

@lombok.Data
public class Data {
    @Getter(onMethod_ = {@JsonProperty("info")})
    @Setter(onMethod_ = {@JsonProperty("info")})
    private Info info;
    @Getter(onMethod_ = {@JsonProperty("general")})
    @Setter(onMethod_ = {@JsonProperty("general")})
    private General general;
}
