package com.spotify.oauth2.pojo.playlist;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.jackson.Jacksonized;

@Jacksonized
@Getter @Setter
@JsonInclude(JsonInclude.Include.NON_NULL)

public class Error {

    @JsonProperty("error")
    private InnerError error;
}