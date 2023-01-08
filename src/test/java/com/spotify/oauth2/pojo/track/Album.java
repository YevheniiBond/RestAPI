
package com.spotify.oauth2.pojo.track;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Getter @Setter
public class Album {

    @JsonProperty("album_type")
    private String albumType;
    @JsonProperty("artists")
    private List<Artist> artists = null;
    @JsonProperty("available_markets")
    private List<String> availableMarkets = null;
    @JsonProperty("external_urls")
    private ExternalUrls__1 externalUrls;
    @JsonProperty("href")
    private String href;
    @JsonProperty("id")
    private String id;
    @JsonProperty("images")
    private List<Image> images = null;
    @JsonProperty("name")
    private String name;
    @JsonProperty("release_date")
    private String releaseDate;
    @JsonProperty("release_date_precision")
    private String releaseDatePrecision;
    @JsonProperty("total_tracks")
    private Integer totalTracks;
    @JsonProperty("type")
    private String type;
    @JsonProperty("uri")
    private String uri;

}
