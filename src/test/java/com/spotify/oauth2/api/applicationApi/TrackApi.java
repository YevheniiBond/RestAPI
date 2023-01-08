package com.spotify.oauth2.api.applicationApi;

import com.spotify.oauth2.api.RestResource;
import com.spotify.oauth2.pojo.track.Album;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import static com.spotify.oauth2.api.Route.PLAYLISTS;
import static com.spotify.oauth2.api.Route.TRACKS;
import static com.spotify.oauth2.api.TokenManager.getToken;

public class TrackApi {
    @Step("POST request")
    public static Response post(Album requestTrack) {
        return RestResource.postTrack(PLAYLISTS +"/"+"3uaTSr9fC3nyvnM9KDFrZt" + TRACKS, getToken(), requestTrack);

    }
}
