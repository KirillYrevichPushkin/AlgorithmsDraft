package WTG.draft.scriptDB;


import java.time.LocalDateTime;
import java.time.LocalTime;


public class LocationDTO {

    private Long id;
    private String title;
    private String description;
    private String fullDescription;
    private String address;
    private LocalTime workTimeStart;
    private LocalTime workTimeEnd;
    private LocalTime workBreakStart;
    private LocalTime workBreakEnd;
    private String linkImage;
    private String linkSite;
    private Double latitude;
    private Double longitude;

    public LocationDTO(String title, String description, String address, LocalTime workTimeStart, LocalTime workTimeEnd, LocalTime workBreakStart, LocalTime workBreakEnd, String linkSite) {
        this.title = title;
        this.description = description;
        this.address = address;
        this.workTimeStart = workTimeStart;
        this.workTimeEnd = workTimeEnd;
        this.workBreakStart = workBreakStart;
        this.workBreakEnd = workBreakEnd;
        this.linkSite = linkSite;
    }

    public LocationDTO() {
    }

    @Override
    public String toString() {
        return "LocationDTO{" +
                "title='" + title + '\'' +
                ", address='" + address + '\'' +
                ", workTimeStart=" + workTimeStart +
                ", workTimeEnd=" + workTimeEnd +
                ", linkSite='" + linkSite + '\'' +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFullDescription() {
        return fullDescription;
    }

    public void setFullDescription(String fullDescription) {
        this.fullDescription = fullDescription;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalTime getWorkTimeStart() {
        return workTimeStart;
    }

    public void setWorkTimeStart(LocalTime workTimeStart) {
        this.workTimeStart = workTimeStart;
    }

    public LocalTime getWorkTimeEnd() {
        return workTimeEnd;
    }

    public void setWorkTimeEnd(LocalTime workTimeEnd) {
        this.workTimeEnd = workTimeEnd;
    }

    public LocalTime getWorkBreakStart() {
        return workBreakStart;
    }

    public void setWorkBreakStart(LocalTime workBreakStart) {
        this.workBreakStart = workBreakStart;
    }

    public LocalTime getWorkBreakEnd() {
        return workBreakEnd;
    }

    public void setWorkBreakEnd(LocalTime workBreakEnd) {
        this.workBreakEnd = workBreakEnd;
    }

    public String getLinkImage() {
        return linkImage;
    }

    public void setLinkImage(String linkImage) {
        this.linkImage = linkImage;
    }

    public String getLinkSite() {
        return linkSite;
    }

    public void setLinkSite(String linkSite) {
        this.linkSite = linkSite;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }
}
