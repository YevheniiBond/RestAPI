
package com.spotify.oauth2.pojo.track;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter @Setter
public class ExternalUrls__3 {

    @JsonProperty("spotify")
    private String spotify;

}
