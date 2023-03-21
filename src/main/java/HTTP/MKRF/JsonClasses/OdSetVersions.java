package HTTP.MKRF.JsonClasses;

import com.fasterxml.jackson.annotation.*;
import java.util.List;

@lombok.Data
public class OdSetVersions {
    @lombok.Getter(onMethod_ = {@JsonProperty("$in")})
    @lombok.Setter(onMethod_ = {@JsonProperty("$in")})
    private List<String> in;
}
