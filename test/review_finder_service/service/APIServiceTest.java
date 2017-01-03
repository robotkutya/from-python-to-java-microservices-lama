package review_finder_service.service;

import java.net.URI;
import java.net.URISyntaxException;

import static org.junit.Assert.*;

/**
 * Created by prezi on 2017. 01. 03..
 */
public class APIServiceTest {

    String title = "product";
    APIService service = APIService.getInstance();

    public static boolean isValidURI(String uriString){
        try {
            URI uri = new URI(uriString);
            return true;
        }
        catch (URISyntaxException e) {
            return false;
        }
    }


    @org.junit.Test
    public void findReviews() throws Exception {
        String[][] reviews = service.findReviews(title);
        assertEquals(true, isValidURI(reviews[0][1]));
        assertEquals(true, isValidURI(reviews[1][1]));
        assertEquals(true, isValidURI(reviews[2][1]));
        assertEquals(true, isValidURI(reviews[3][1]));
        assertEquals(true, isValidURI(reviews[4][1]));
    }

}