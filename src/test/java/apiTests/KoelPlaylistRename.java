package apiTests;

import helpers.DbAdapter;
import helpers.RandomGenerator;
import helpers.Token;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import models.Playlist;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class KoelPlaylistRename {
    private String token;
    private int playlistId;
    @BeforeClass
    public void runBeforeClassOnlyOneTime(){
        token = Token.get();
    }
    @AfterMethod
    public void tearDown(){
        given()
                .baseUri("https://koelapp.testpro.io/")
                .basePath("api/playlist/"+playlistId)
                .header("Authorization","Bearer "+token)
                .delete();
    }
    @BeforeMethod
    public void startUp(){
        String newName = RandomGenerator.randomStringGenerator(8);
        Playlist newPlaylist = new Playlist(newName);
        Response response =
                given()
                        .baseUri("https://koelapp.testpro.io/")
                        .basePath("api/playlist")
                        .header("Content-Type","application/json")
                        .header("Authorization","Bearer "+token)
                        .body(newPlaylist)
                        .when()
                        .post()
                        .then()
                        .extract()
                        .response();
        JsonPath jsonPath = response.jsonPath();
        Playlist playlistResponse = jsonPath.getObject("$",Playlist.class);
        playlistId = playlistResponse.id;
    }
    @Test
    public void renamePlaylist(){
        String newName = RandomGenerator.randomStringGenerator(8);
        Playlist updateName = new Playlist(newName);
        Response response =
                given()
                        .baseUri("https://koelapp.testpro.io/")
                        .basePath("api/playlist/"+playlistId)
                        .header("Content-Type","application/json")
                        .header("Authorization","Bearer "+token)
                        .body(updateName)
                        .when()
                        .put()
                        .then()
                        .extract()
                        .response();
        JsonPath jsonPath = response.jsonPath();
        Playlist playlistResponse = jsonPath.getObject("$",Playlist.class);
        Assert.assertEquals(newName,playlistResponse.name);

        Playlist plFromDb = DbAdapter.getPlaylistById(playlistId);
        Assert.assertEquals(newName,plFromDb.name);
    }
}
