package HTTP.MKRF.JsonClasses;

import com.fasterxml.jackson.annotation.*;
import java.time.OffsetDateTime;

@lombok.Data
public class Seance {
    @lombok.Getter(onMethod_ = {@JsonProperty("start")})
    @lombok.Setter(onMethod_ = {@JsonProperty("start")})
    private OffsetDateTime start;
    @lombok.Getter(onMethod_ = {@JsonProperty("end")})
    @lombok.Setter(onMethod_ = {@JsonProperty("end")})
    private OffsetDateTime end;
}
