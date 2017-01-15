package review_finder_service.controller;

import review_finder_service.service.APIService;
import spark.Request;
import spark.Response;
import javax.json.Json;
import javax.json.JsonObjectBuilder;

import java.io.IOException;

/**
 * @author      Misi Furedi <address @ example.com>
 * @version     Beta                 (current version number of program)
 * @since       The beginning of time          (the version of the package this class was first added to)
 */
public class ReviewAPIController {
    public static final String CATEGORY_PARAM_KEY = "title";
    private final APIService apiService;

    public ReviewAPIController(APIService apiService){
        this.apiService = apiService;
    }

    /**
     * Uses the APIService's findReview and converts it to a JSON
     * @param  req
     * @param  res
     * @return It returns the input JSON as a String or null
     */
    public String getReviews(Request req, Response res){
        try {
            String[][] reviews = apiService.findReviews(req.queryParams(CATEGORY_PARAM_KEY));
            JsonObjectBuilder builder = Json.createObjectBuilder();
            for (int i=0; i<reviews.length; i++){
                builder.add(Integer.toString(i), Json.createObjectBuilder()
                                                        .add("text", reviews[i][0])
                                                        .add("url", reviews[i][1])
                                                        .build());
            }
            return builder.build().toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
