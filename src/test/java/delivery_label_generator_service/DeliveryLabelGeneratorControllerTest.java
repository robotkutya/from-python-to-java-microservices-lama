package delivery_label_generator_service;

import org.json.JSONObject;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by cave on 2017.01.04..
 */
public class DeliveryLabelGeneratorControllerTest {
    private DeliveryLabelGeneratorController controller;
    private String jsonString;
    private ArrayList<JSONObject> expectedListOfDeliveryDetails;

    @Before
    public void setUp() throws Exception {
        this.jsonString = "[{name: Bela, city: Belavar, address: Bela utca 1.}, " +
                "{name: Bela2, city: Belavar2, address: Bela utca 2.}]";
        this.controller = new DeliveryLabelGeneratorController();


        expectedListOfDeliveryDetails = new ArrayList<>();
        expectedListOfDeliveryDetails.add(new JSONObject());
        expectedListOfDeliveryDetails.add(new JSONObject());
        expectedListOfDeliveryDetails.get(0).put("name", "Bela");
        expectedListOfDeliveryDetails.get(0).put("city", "Belavar");
        expectedListOfDeliveryDetails.get(0).put("address", "Bela utca 1.");
        expectedListOfDeliveryDetails.get(1).put("name", "Bela2");
        expectedListOfDeliveryDetails.get(1).put("city", "Belavar2");
        expectedListOfDeliveryDetails.get(1).put("address", "Bela utca 2.");
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
    public void getLabel() throws Exception {

    }

    @Test
    public void status() throws Exception {

    }

}