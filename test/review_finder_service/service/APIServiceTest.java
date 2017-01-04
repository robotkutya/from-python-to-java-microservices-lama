package review_finder_service.service;

import org.apache.commons.validator.routines.UrlValidator;

import static org.junit.Assert.*;

/**
 * Created by prezi on 2017. 01. 03..
 */
public class APIServiceTest {
    private APIService service = APIService.getInstance();


    @org.junit.Test
    public void validUrlTest() throws Exception {
        String[][] reviews = service.findReviews("asus zenbook");
        for (int i=0; i<5; i++){
            assertTrue(UrlValidator.getInstance().isValid(reviews[i][1]));
        }
    }

    @org.junit.Test
    public void whitespaceUrlTest() throws Exception {
        String[][] reviews = service.findReviews("   ");
        for (int i=0; i<5; i++){
            assertTrue(UrlValidator.getInstance().isValid(reviews[i][1]));
        }
    }

    @org.junit.Test
    public void numberUrlTest() throws Exception {
        String[][] reviews = service.findReviews("31241");
        for (int i=0; i<5; i++){
            assertTrue(UrlValidator.getInstance().isValid(reviews[i][1]));
        }
    }

    @org.junit.Test
    public void emptyUrlTest() throws Exception {
        String[][] reviews = service.findReviews("");
        for (int i=0; i<5; i++){
            assertTrue(UrlValidator.getInstance().isValid(reviews[i][1]));
        }
    }

    @org.junit.Test
    public void randomUrlTest() throws Exception {
        String[][] reviews = service.findReviews("asdefe");
        for (int i=0; i<5; i++){
            assertTrue(UrlValidator.getInstance().isValid(reviews[i][1]));
        }
    }

}