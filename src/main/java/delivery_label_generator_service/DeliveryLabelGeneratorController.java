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

    private String qrGenerator(String id){


        return "url";
    }

    private ArrayList<JSONObject> createListOfJSONObjects(String jsonString) {
        ArrayList<JSONObject> deliveryLabels = new ArrayList<JSONObject>();
        JSONArray jsonArray = new JSONArray(jsonString);
        for (Object object: jsonArray) {
            deliveryLabels.add(new JSONObject(object.toString()));
        }
        return deliveryLabels;
    }

    private String htmlGenerator(ArrayList<JSONObject> orderList){
        System.out.println("COMMENT html");
        String htmlCode = "<html><body>";
        System.out.println(orderList);
        System.out.println(htmlCode);
        for (JSONObject order : orderList) {
            System.out.println(order);
            System.out.println(order.getString("name"));
            System.out.println("itt meg futok");
            htmlCode= htmlCode.concat("<div><img src=\"" +
                    "height=\"42\" width=\"42\">" + "<ul><li>" + order.getString("name") + "</li>" +
                    "<li>" + order.getString("address") + "</li></ul></ul></div>");
//            " + qrGenerator(order.getString("id")) + "
            System.out.println("itt már nem");
            System.out.println(htmlCode);
        }
        System.out.println(htmlCode);
        htmlCode= htmlCode.concat("</body></html>");
        System.out.println("COMMENT végigért");
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
//        ArrayList<JSONObject> deliveryDatas = createListOfJSONObjects(request.queryString());
//        JSONObject json = new JSONObject();
//        json.put("code", htmlGenerator(exampleJson()));
        return htmlGenerator(exampleJson());
    }

    public String status(Request request, Response response) {
        return "OK";
    }

    private ArrayList<JSONObject> exampleJson(){
        JSONObject jss = new JSONObject();
        JSONObject js = new JSONObject();
        js.put("name", "anna");
        js.put("address", "sdf");
        jss.put("id", "sdfgsd");

        jss.put("name", "anna");
        jss.put("address", "sdf");
        jss.put("id", "sdfgsd");

        ArrayList <JSONObject> list = new ArrayList<>();
        list.add(js);
        list.add(jss);
        return list;
    }
}


