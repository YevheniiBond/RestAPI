package com.spotify.oauth2.tests;

import com.spotify.oauth2.api.applicationApi.TrackApi;
import com.spotify.oauth2.pojo.track.Album;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class TrackTest {

    public Album trackBuilder() {
        Album track = new Album();
        return track;
    }

    public void assertStatusCode(int actualStatusCode, int expectedStatusCode) {
        assertThat(actualStatusCode, equalTo(expectedStatusCode));
    }

    public void assertPlaylistEquals(Album responseTrack, Album requestTrack) {

        assertThat(responseTrack.getId(), equalTo(requestTrack.getId()));
        assertThat(responseTrack.getName(), equalTo(requestTrack.getName()));
    }

    @Test
    public void addTrackToPlaylist() {

        Album requestTrack = trackBuilder();
        Response response = TrackApi.post(requestTrack);
        assertStatusCode(response.statusCode(), 201);
        assertPlaylistEquals(response.as(Album.class), requestTrack);
    }
}
