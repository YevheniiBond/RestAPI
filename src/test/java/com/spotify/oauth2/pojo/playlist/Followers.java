package com.spotify.oauth2.pojo.playlist;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

public class Followers {

    @Getter @Setter
    @JsonProperty("href")
    private String href;
    @JsonProperty("total")
    private Integer total;
}
