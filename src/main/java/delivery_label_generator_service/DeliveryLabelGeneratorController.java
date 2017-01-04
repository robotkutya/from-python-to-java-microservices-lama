package delivery_label_generator_service;

import com.itextpdf.text.Document;
import com.itextpdf.text.html.simpleparser.HTMLWorker;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.codec.Base64;
import org.json.JSONArray;
import org.json.JSONObject;
import spark.Request;
import spark.Response;

import java.io.ByteArrayOutputStream;
import java.io.StringReader;
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
        String htmlCode = "<html style=\"size: 21cm 29.7cm; margin: 30mm 45mm 30mm 45mm;\"><body>";
        for (JSONObject order : orderList) {
            htmlCode += "<div>";
            try {
                htmlCode += "<img src=\""
                        + new QrCodeGenerator(order.getString("id")).getUrlOfQr()
                        + "\" height=\"42\" width=\"42\">";
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }
            htmlCode += "<ul><li>" + order.getString("name") + "</li><li>" + order.getString("address") + "</li></ul>";
            htmlCode += "</ul></div>";
        }
        htmlCode += "</body></html";
        return htmlCode;
    }

    private static String createPDF(){
        try {
            String k = "<html><body> This is my project </body></html>";
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            Document document = new Document();
            PdfWriter.getInstance(document, baos);
            document.open();
            HTMLWorker htmlWorker = new HTMLWorker(document);
            htmlWorker.parse(new StringReader(k));
            document.close();
            byte[] b = baos.toByteArray();
            String code = Base64.encodeBytes(b).toString();
            return "data:application/pdf;base64,"+code;

        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }

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
