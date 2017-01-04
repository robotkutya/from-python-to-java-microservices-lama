package delivery_label_generator_service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class QrCodeGenerator {
    private static final Logger logger = LoggerFactory.getLogger(QrCodeGenerator.class);
    private static final String API_URL = "http://api.qrserver.com/v1/create-qr-code/?data=";

    private String data;

    public QrCodeGenerator() {
        super();
    }

    public QrCodeGenerator(String data) {
        this.data = data;
    }

    public String getUrlOfQr(){
        logger.debug("url to return: " + API_URL + data);
        return API_URL + data;
    }
}
