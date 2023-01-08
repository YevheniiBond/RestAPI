package com.spotify.oauth2.api;

import com.spotify.oauth2.pojo.track.Album;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.HashMap;

import static com.spotify.oauth2.api.Route.*;
import static com.spotify.oauth2.api.SpecBuilder.getRequestSpec;
import static com.spotify.oauth2.api.SpecBuilder.getResponseSpec;
import static io.restassured.RestAssured.given;

public class RestResource {


    public static Response post(String path, String token, Object requestPlaylist){
        return given(getRequestSpec()).
                body(requestPlaylist).
                header("Authorization", "Bearer " + token).
                when().post(path).
                then().spec(getResponseSpec()).
                extract().
                response();
    }

    public static Response postAccount(HashMap<String , String > formParams){
        return given().
                baseUri("https://accounts.spotify.com").
                contentType(ContentType.URLENC).
                formParams(formParams).
                log().all().
                when().post(API+TOKEN).
                then().spec(getResponseSpec()).
                extract().
                response();
    }
    public static  Response postTrack(String path, String token, Album requestTrack){
        return given(getRequestSpec()).
                body(requestTrack).
                queryParam("uris","spotify:track:7mP4bBFQgt6B3sJfqkIzt2").
                header("Authorization","Bearer " + token).
                contentType(ContentType.URLENC).
                when().post(PLAYLISTS+"/"+"3uaTSr9fC3nyvnM9KDFrZt"+ TRACKS).
                then().spec(getResponseSpec()).
                extract().
                response();
    }

    public static Response get(String path, String token){
        return given(getRequestSpec()).
                header("Authorization", "Bearer " + token).
                when().get(path).
                then().spec(getResponseSpec()).
                extract().
                response();

    }

    public  static Response put(String path, String token, Object requestPlaylist){
        return given(getRequestSpec()).
                header("Authorization", "Bearer " + token).
                body(requestPlaylist).
                when().put(path).
                then().spec(getResponseSpec()).
                extract().
                response();
    }
}
