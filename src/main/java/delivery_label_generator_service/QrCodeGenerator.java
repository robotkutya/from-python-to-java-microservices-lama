package delivery_label_generator_service;

import org.apache.http.client.fluent.Request;
import org.apache.http.client.utils.URIBuilder;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * Created by cave on 2017.01.03..
 */
public class QrCodeGenerator {
    private String data;

    public QrCodeGenerator() {
        super();
    }

    public QrCodeGenerator(String data) {
        this.data = data;
    }

    public String getUrlOfQr(){
        return "https://api.qrserver.com/v1/create-qr-code/?data=" + data;
    }
}
