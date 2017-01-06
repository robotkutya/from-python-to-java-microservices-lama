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


    /**
     * Constructor of the class
     * @param data What the qr code will return after scan
     */
    public QrCodeGenerator(String data) {
        this.data = data;
    }


    /**
     * Setter for the private String data field
     * @param data
     */
    public void setData(String data) {
        this.data = data;
    }


    /**
     * Getter for the private String data field
     * @return data
     */
    public String getData() {
        return data;
    }


    /**
     * Get the url of the necessary QR based on the data field (what the QR code should return)
     * @return Url for the generated QR code with the necessary Data
     * @throws NoSuchFieldException throws with the "Please set the 'data' field with a string!" message, when the data field is null.
     */
    public String getUrlOfQr() throws NoSuchFieldException {
        if (data == null) throw new NoSuchFieldException("Please set the 'data' field with a string!");

        logger.debug("url to return: " + API_URL + data);
        return API_URL + data;
    }
}
