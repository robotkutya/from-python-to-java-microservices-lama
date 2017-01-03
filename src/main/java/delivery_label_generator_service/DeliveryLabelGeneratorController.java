package delivery_label_generator_service;

import org.json.JSONArray;
import org.json.JSONObject;
import spark.Request;
import spark.Response;

import java.util.ArrayList;

/**
 * Created by cave on 2017.01.03..
 */
public class DeliveryLabelGeneratorController {

    private ArrayList<JSONObject> createListOfJSONObjects(String jsonString) {
        ArrayList<JSONObject> deliveryLabels = new ArrayList<>();
        JSONArray jsonArray = new JSONArray(jsonString);
        for (Object object: jsonArray) {
            deliveryLabels.add(new JSONObject(object.toString()));
        }
        return deliveryLabels;
    }

    private String htmlGenerator(ArrayList<JSONObject> orderList){
        String htmlCode = "<html><body>";
        for (JSONObject order : orderList) {
            htmlCode += "<div>";
            htmlCode += "<img src=\"" + new QrCodeGenerator(order.getString("id")).getUrlOfQr() + "\" height=\"42\" width=\"42\">";
            htmlCode += "<ul><li>" + order.getString("name") + "</li><li>" + order.getString("address") + "</li></ul>";
            htmlCode += "</ul></div>";
        }
        htmlCode += "</body></html";
        return htmlCode;
    }

//    private void createPDF(){
//        try {
//            String k = "<html><body> This is my Project </body></html>";
//            OutputStream file = new FileOutputStream(new File("C:\\Test.pdf"));
//            Document document = new Document();
//            PdfWriter.getInstance(document, file);
//            document.open();
//            HTMLWorker htmlWorker = new HTMLWorker(document);
//            htmlWorker.parse(new StringReader(k));
//            document.close();
//            file.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    public String getLabel(Request request, Response response){
        ArrayList<JSONObject> orders = createListOfJSONObjects(request.queryParams("orders"));
        System.out.println(request.queryParams("orders"));
        // TODO: return the correctly formatted pdf bytecode (with necessary headers, etc)
        return htmlGenerator(orders);
    }

    public String status(Request request, Response response) {
        return "OK";
    }
}
