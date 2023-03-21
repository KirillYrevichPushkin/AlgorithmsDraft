package HTTP.MKRF.JsonClasses;

import com.fasterxml.jackson.annotation.*;
import java.util.List;

@lombok.Data
public class MapPosition {
    @lombok.Getter(onMethod_ = {@JsonProperty("type")})
    @lombok.Setter(onMethod_ = {@JsonProperty("type")})
    private String type;
    @lombok.Getter(onMethod_ = {@JsonProperty("coordinates")})
    @lombok.Setter(onMethod_ = {@JsonProperty("coordinates")})
    private List<Double> coordinates;
}
