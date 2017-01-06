package delivery_label_generator_service;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

/**
 * Created by cave on 2017.01.04..
 */
public class QrCodeGeneratorTest {

    @Test
    public void getValidUrlOfQr() throws Exception {
        QrCodeGenerator qrCodeGenerator = new QrCodeGenerator("test");

        String qrCodeUrl = qrCodeGenerator.getUrlOfQr();

        assertEquals(qrCodeUrl, "http://api.qrserver.com/v1/create-qr-code/?data=test");
    }

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void noDataGiven() throws Exception {
        expectedException.expect(NoSuchFieldException.class);
        expectedException.expectMessage("Please set the 'data' field with a string!");
        QrCodeGenerator qrCodeGenerator = new QrCodeGenerator();

        qrCodeGenerator.getUrlOfQr();
    }
}