package review_finder_service;

import org.apache.http.client.fluent.Request;
import org.apache.http.client.utils.URIBuilder;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by leviathan on 2017.01.04..
 */
public class ReviewFinderTest {
    /*
    Requires running service server, and specify the port number.
     */
    private final String port = "60001";
    private final String uriBase = "http://localhost:" + port + "/api/review";
    private final String paramKey = "title";

    private JSONObject getJson(String param) throws URISyntaxException, IOException {
        URIBuilder builder = new URIBuilder(uriBase);
        builder.addParameter(paramKey, param);
        return new JSONObject(Request.Get(builder.build())
                .execute()
                .returnContent()
                .asString());
    }

    /*
    Testing returned Json schema (5*2).
     */
    @org.junit.Test
    public void validJsonTest() throws URISyntaxException, IOException {
        JSONObject json = getJson("asus zenbook");
        Iterator<String> keys = json.keys();
        assertEquals(5, json.length());
        while (keys.hasNext()){
            assertEquals(2, json.getJSONObject(keys.next()).length());
        }
    }

    @org.junit.Test
    public void emptyJsonTest() throws URISyntaxException, IOException {
        JSONObject json = getJson("");
        Iterator<String> keys = json.keys();
        assertEquals(5, json.length());
        while (keys.hasNext()){
            assertEquals(2, json.getJSONObject(keys.next()).length());
        }
    }

    @org.junit.Test
    public void randomJsonTest() throws URISyntaxException, IOException {
        JSONObject json = getJson("asdaf");
        Iterator<String> keys = json.keys();
        assertEquals(5, json.length());
        while (keys.hasNext()){
            assertEquals(2, json.getJSONObject(keys.next()).length());
        }
    }

    @org.junit.Test
    public void whitespaceJsonTest() throws URISyntaxException, IOException {
        JSONObject json = getJson("  ");
        Iterator<String> keys = json.keys();
        assertEquals(5, json.length());
        while (keys.hasNext()){
            assertEquals(2, json.getJSONObject(keys.next()).length());
        }
    }

    @org.junit.Test
    public void numJsonTest() throws URISyntaxException, IOException {
        JSONObject json = getJson("3421");
        Iterator<String> keys = json.keys();
        assertEquals(5, json.length());
        while (keys.hasNext()){
            assertEquals(2, json.getJSONObject(keys.next()).length());
        }
    }
}
