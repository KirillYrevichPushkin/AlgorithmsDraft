package HTTP.MKRF.JsonClasses;

import com.fasterxml.jackson.annotation.*;

import java.time.OffsetDateTime;
import java.util.List;

@lombok.Data
public class General {
    @lombok.Getter(onMethod_ = {@JsonProperty("id")})
    @lombok.Setter(onMethod_ = {@JsonProperty("id")})
    private long id;
    @lombok.Getter(onMethod_ = {@JsonProperty("name")})
    @lombok.Setter(onMethod_ = {@JsonProperty("name")})
    private String name;
    @lombok.Getter(onMethod_ = {@JsonProperty("shortDescription")})
    @lombok.Setter(onMethod_ = {@JsonProperty("shortDescription")})
    private String shortDescription;
    @lombok.Getter(onMethod_ = {@JsonProperty("description")})
    @lombok.Setter(onMethod_ = {@JsonProperty("description")})
    private String description;
    @lombok.Getter(onMethod_ = {@JsonProperty("ageRestriction")})
    @lombok.Setter(onMethod_ = {@JsonProperty("ageRestriction")})
    private long ageRestriction;
    @lombok.Getter(onMethod_ = {@JsonProperty("isFree")})
    @lombok.Setter(onMethod_ = {@JsonProperty("isFree")})
    private boolean isFree;
    @lombok.Getter(onMethod_ = {@JsonProperty("status")})
    @lombok.Setter(onMethod_ = {@JsonProperty("status")})
    private String status;
    @lombok.Getter(onMethod_ = {@JsonProperty("start")})
    @lombok.Setter(onMethod_ = {@JsonProperty("start")})
    private OffsetDateTime start;
    @lombok.Getter(onMethod_ = {@JsonProperty("end")})
    @lombok.Setter(onMethod_ = {@JsonProperty("end")})
    private OffsetDateTime end;
    @lombok.Getter(onMethod_ = {@JsonProperty("tags")})
    @lombok.Setter(onMethod_ = {@JsonProperty("tags")})
    private List<Category> tags;
    @lombok.Getter(onMethod_ = {@JsonProperty("image")})
    @lombok.Setter(onMethod_ = {@JsonProperty("image")})
    private Image image;
    @lombok.Getter(onMethod_ = {@JsonProperty("gallery")})
    @lombok.Setter(onMethod_ = {@JsonProperty("gallery")})
    private List<Image> gallery;
    @lombok.Getter(onMethod_ = {@JsonProperty("recommendations")})
    @lombok.Setter(onMethod_ = {@JsonProperty("recommendations")})
    private List<Recommendation> recommendations;
    @lombok.Getter(onMethod_ = {@JsonProperty("category")})
    @lombok.Setter(onMethod_ = {@JsonProperty("category")})
    private Category category;
    @lombok.Getter(onMethod_ = {@JsonProperty("organization")})
    @lombok.Setter(onMethod_ = {@JsonProperty("organization")})
    private Organization organization;
    @lombok.Getter(onMethod_ = {@JsonProperty("places")})
    @lombok.Setter(onMethod_ = {@JsonProperty("places")})
    private List<Place> places;
    @lombok.Getter(onMethod_ = {@JsonProperty("seances")})
    @lombok.Setter(onMethod_ = {@JsonProperty("seances")})
    private List<Seance> seances;
}
