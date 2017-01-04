package delivery_label_generator_service;

import org.apache.commons.codec.binary.Base64;
import org.json.JSONObject;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import spark.Request;
import spark.Response;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * Created by cave on 2017.01.04..
 */
public class DeliveryLabelGeneratorControllerTest {
    private DeliveryLabelGeneratorController controller;
    private String jsonString;
    private ArrayList<JSONObject> expectedListOfDeliveryDetails;

    @Before
    public void setUp() throws Exception {
        this.jsonString = "[{name: Bela, city: Belavar, address: Bela utca 1., id: id1}, " +
                "{name: Bela2, city: Belavar2, address: Bela utca 2., id: id2}]";
        this.controller = new DeliveryLabelGeneratorController();


        expectedListOfDeliveryDetails = new ArrayList<>();
        expectedListOfDeliveryDetails.add(new JSONObject());
        expectedListOfDeliveryDetails.add(new JSONObject());
        expectedListOfDeliveryDetails.get(0).put("name", "Bela");
        expectedListOfDeliveryDetails.get(0).put("city", "Belavar");
        expectedListOfDeliveryDetails.get(0).put("address", "Bela utca 1.");
        expectedListOfDeliveryDetails.get(0).put("id", "id1");
        expectedListOfDeliveryDetails.get(1).put("name", "Bela2");
        expectedListOfDeliveryDetails.get(1).put("city", "Belavar2");
        expectedListOfDeliveryDetails.get(1).put("address", "Bela utca 2.");
        expectedListOfDeliveryDetails.get(1).put("id", "id2");
    }

    @Test
    public void createListOfJSONObjects() throws Exception {

        ArrayList<JSONObject> listOfDeliveryDetails = controller.createListOfJSONObjects(jsonString);

        assertEquals(expectedListOfDeliveryDetails.get(0).getClass(), listOfDeliveryDetails.get(0).getClass());
        assertEquals(expectedListOfDeliveryDetails.get(1).getClass(), listOfDeliveryDetails.get(1).getClass());
    }

    @Test
    public void createListOfValidJSONObjects() throws Exception {

        ArrayList<JSONObject> listOfDeliveryDetails = controller.createListOfJSONObjects(jsonString);

        assertEquals(expectedListOfDeliveryDetails.toString(), listOfDeliveryDetails.toString());
    }

    @Test
    public void PDFByteArrayValid() throws Exception {
        File file = new File("src/test/java/delivery_label_generator_service/resource/PDF_byteCode.txt");
        FileInputStream fis = new FileInputStream(file);
        byte[] data = new byte[(int) file.length()];
        fis.read(data);
        fis.close();
        String expectedByteCode = new String(data);

        String actualByteCode = new String(Base64.encodeBase64(controller.createPDF(expectedListOfDeliveryDetails)));

        assertEquals(expectedByteCode.substring(0, 2450), actualByteCode.substring(0, 2450));
    }

//     TODO: correct this test
//    @Test
//    public void getLabelCallCreatePDF() throws Exception {
//        Request request = mock(Request.class);
//        Response response = mock(Response.class);
//        DeliveryLabelGeneratorController controller = mock(DeliveryLabelGeneratorController.class);
//        when(controller.createListOfJSONObjects(any())).thenReturn(expectedListOfDeliveryDetails);
//        when(controller.createPDF(any())).thenReturn(new byte[]{});
//        when(controller.getLabel(request, response)).thenCallRealMethod();
//
//        controller.getLabel(request, response);
//
//        verify(controller.createPDF(expectedListOfDeliveryDetails));
//    }

    @Test
    public void status() throws Exception {
        String expected = "OK";
        Request requestMock = mock(Request.class);
        Response responseMock = mock(Response.class);

        String actual = controller.status(requestMock, responseMock);
    }

}