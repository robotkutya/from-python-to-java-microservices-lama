package delivery_label_generator_service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class QrCodeGenerator {
    private static final Logger logger = LoggerFactory.getLogger(QrCodeGenerator.class);
    private static final String API_URL = "https://api.qrserver.com/v1/create-qr-code/?data=";

    private String data;

    public QrCodeGenerator() {
        super();
    }

    public QrCodeGenerator(String data) {
        this.data = data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public String getUrlOfQr() throws NoSuchFieldException {
        if (data == null) throw new NoSuchFieldException("Please set the 'data' field with a string!");

        logger.debug("url to return: " + API_URL + data);
        return API_URL + data;
    }
}
