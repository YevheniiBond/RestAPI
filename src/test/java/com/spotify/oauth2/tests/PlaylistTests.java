package com.spotify.oauth2.tests;

import com.spotify.oauth2.api.applicationApi.PlaylistApi;
import com.spotify.oauth2.pojo.Error;
import com.spotify.oauth2.pojo.Playlist1;
import com.spotify.oauth2.utils.DataLoader;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@Epic("Spotify Oauth 2.0")
@Feature("Playlist API")
public class PlaylistTests {

    @Story("Create a playlist story")
    @Step("Creating playlist with parameters: name, description and access modifiers")
    public Playlist1 playlistBuilder(String name, String description, boolean _public) {
        Playlist1 playlist1 = new Playlist1();
        playlist1.setName(name);
        playlist1.setDescription(description);
        playlist1.set_public(_public);
        return playlist1;
    }

    @Step("assert that name, description and access modifiers is correct")
    public void assertPlaylistEquals(Playlist1 responsePlaylist1, Playlist1 requestPlaylist1) {

        assertThat(responsePlaylist1.getName(), equalTo(requestPlaylist1.getName()));
        assertThat(responsePlaylist1.getDescription(), equalTo(requestPlaylist1.getDescription()));
        assertThat(responsePlaylist1.get_public(), equalTo(requestPlaylist1.get_public()));

    }

    @Step("Status code assertation result")
    public void assertStatusCode(int actualStatusCode, int expectedStatusCode) {
        assertThat(actualStatusCode, equalTo(expectedStatusCode));
    }

    public void assertError(Error responseErr, int expectedStatusCode, String expectedMsg) {
        assertThat(responseErr.getError().getStatus(), equalTo(expectedStatusCode));
        assertThat(responseErr.getError().getMessage(), equalTo(expectedMsg));
    }

    @Test(description = "Should be able to create a playlist")
    public void ShouldBeAbleToCreatePlaylist() {
        Playlist1 requestPlaylist1 = playlistBuilder("Lovely Playlist by API", null, false);
        Response response = PlaylistApi.post(requestPlaylist1);
        assertStatusCode(response.statusCode(), 201);
        assertPlaylistEquals(response.as(Playlist1.class), requestPlaylist1);
    }

    @Test(description = "Should be able to get a playlist")
    public void ShouldBeAbleToGetAPlaylist() {
        Playlist1 requestPlaylist1 = playlistBuilder("Lovely Playlist by API", "New playlist description", false);
        Response response = PlaylistApi.get(DataLoader.getInstance().getGetPlaylistId());
        assertStatusCode(response.statusCode(), 200);
        assertPlaylistEquals(response.as(Playlist1.class), requestPlaylist1);
    }

    @Test(description = "Should be able to update a playlist")
    public void ShouldBeAbleToUpdateAPlaylist() {

        Playlist1 requestPlaylist = playlistBuilder("我♥爱♥你", "New playlist description", false);

        Response response = PlaylistApi.put(DataLoader.getInstance().getUpdatePlaylistId(), requestPlaylist);

        assertStatusCode(response.statusCode(), 200);
    }

    @Test(description = "Should not be able to create playlist without name")
    public void ShouldNotBeAbleToCreatePlaylistWithoutName() {
        Playlist1 requestPlaylist = playlistBuilder("", "New playlist description", false);
        Response response = PlaylistApi.post(requestPlaylist);
        assertStatusCode(response.statusCode(), 400);
        assertError(response.as(Error.class), 400, "Missing required field: name");
    }

    @Test(description = "Should not be able to create playlist with expired token")
    public void ShouldNotBeAbleToCreatePlaylistWithExpiredToken() {
        String invalid_token = "12345";
        Playlist1 requestPlaylist = playlistBuilder("", "New playlist description", false);
        Response response = PlaylistApi.post(invalid_token, requestPlaylist);
        assertStatusCode(response.statusCode(), 401);
        assertError(response.as(Error.class), 401, "Invalid access token");
    }
}

