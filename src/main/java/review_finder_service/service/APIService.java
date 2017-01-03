package review_finder_service.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by leviathan on 2017.01.03..
 */
public class APIService {
    private static final Logger logger = LoggerFactory.getLogger(APIService.class);
    private static final String API_URL = "https://www.google.com/search";
    private static APIService INSTANCE;

    private APIService(){}

    public static APIService getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new APIService();
        }
        return INSTANCE;
    }

    public String findReviews(String title){
        return null;
    }
}
