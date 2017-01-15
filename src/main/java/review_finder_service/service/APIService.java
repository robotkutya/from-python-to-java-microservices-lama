package review_finder_service.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * @author      Misi Furedi <address @ example.com>
 * @version     Beta                 (current version number of program)
 * @since       The beginning of time          (the version of the package this class was first added to)
 */
public class APIService {
    private static final Logger logger = LoggerFactory.getLogger(APIService.class);
    private static final String API_URL = "https://www.google.com/search";
    private static APIService INSTANCE;

    private APIService(){}

    public static APIService getInstance() {
        if (INSTANCE == null) {
            logger.info("Creating new APIService.");
            INSTANCE = new APIService();
        }
        logger.info("Using existing APIService");
        return INSTANCE;
    }

    /**
     * Uses the Jsoup library to parse the html
     * @param  title What we search for, the search term
     * @return A String[5][2] Array containing the top 5 search results.
     */
    public String[][] findReviews(String title) throws IOException {
        logger.info("Building URL, trying to connect.");
        String searchURL = API_URL + "?q=" + title + "+review&num=5";
        Document doc = Jsoup.connect(searchURL).userAgent("Mozilla/5.0").get();
        String[][] reviews = new String[5][2];
        int idx = 0;

        Elements results = doc.select("h3.r > a");
        logger.info("Connection successful, parsing URLs");
        for (Element result : results) {
            String linkText = result.text();
            reviews[idx][0] = linkText;
            String linkHref = result.attr("href");
            reviews[idx][1] = linkHref.substring(7, linkHref.indexOf("&"));
            idx++;
            logger.info(idx + ". URL parsed.");
            logger.info("Text::" + linkText + ", URL::" + linkHref.substring(7, linkHref.indexOf("&")));
            if (idx == 5){
                break;
            }
        }
        return reviews;
    }
}
