package delivery_label_generator_service;

import org.json.JSONArray;
import org.json.JSONObject;
import spark.Request;
import spark.Response;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by cave on 2017.01.03..
 */
public class DeliveryLabelGeneratorController {

    public String createLabel(Request request, Response response){
        return "response";
    }

    private ArrayList<JSONObject> createListOfJSONObjects(String jsonString) {
        ArrayList<JSONObject> deliveryLabels = new ArrayList<>();
        JSONArray jsonArray = new JSONArray(jsonString);
        for (Object object: jsonArray) {
            deliveryLabels.add(new JSONObject(object.toString()));
        }
        return deliveryLabels;
    }

    private String qrGenerator(){
        return "url";
    }

    private String htmlGenerator(){
        return "html code";
    }

    private void pdfCreator(){
    }

    public String status(Request request, Response response) {
        return "OK";
    }
}
