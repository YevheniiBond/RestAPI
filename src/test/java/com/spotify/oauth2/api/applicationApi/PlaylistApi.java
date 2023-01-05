package com.spotify.oauth2.api.applicationApi;

import com.spotify.oauth2.api.RestResource;
import com.spotify.oauth2.pojo.Playlist1;
import com.spotify.oauth2.utils.ConfigLoader;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import static com.spotify.oauth2.api.Route.PLAYLISTS;
import static com.spotify.oauth2.api.Route.USERS;
import static com.spotify.oauth2.api.TokenManager.getToken;


public class PlaylistApi {
    @Step("POST request")
    public static Response post(Playlist1 requestPlaylist) {
        return RestResource.post(USERS + "/" + ConfigLoader.getInstance().getUser() + PLAYLISTS, getToken(), requestPlaylist);

    }
    public static Response post(String token, Playlist1 requestPlaylist) {
        return RestResource.post(USERS + "/"+ ConfigLoader.getInstance().getUser() + PLAYLISTS, token, requestPlaylist);
    }

    public static Response get(String playlistId) {
        return RestResource.get(PLAYLISTS +"/"+ playlistId, getToken());
    }

    public static Response put(String playlistId, Playlist1 requestPlaylist) {
        return RestResource.put(PLAYLISTS + "/" + playlistId, getToken(), requestPlaylist);
    }
}