package review_finder_service.controller;

import review_finder_service.service.APIService;
import spark.Request;
import spark.Response;

/**
 * Created by leviathan on 2017.01.03..
 */
public class ReviewAPIController {
    public static final String CATEGORY_PARAM_KEY = "title";
    private final APIService apiService;

    public ReviewAPIController(APIService apiService){
        this.apiService = apiService;
    }

    /*
    Returns 5 review URLs with titles
     */
    public String getReviews(Request req, Response res){
        return apiService.findReviews(req.queryParams(CATEGORY_PARAM_KEY));
    }
}
