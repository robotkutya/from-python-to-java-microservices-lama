package delivery_label_generator_service;

import com.itextpdf.text.Document;
import com.itextpdf.text.html.simpleparser.HTMLWorker;
import com.itextpdf.text.pdf.PdfWriter;
import org.json.JSONArray;
import org.json.JSONObject;
import spark.Request;
import spark.Response;

import javax.servlet.ServletOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;

/**
 * Created by cave on 2017.01.03..
 */
public class DeliveryLabelGeneratorController {

    /* private -> testing */ ArrayList<JSONObject> createListOfJSONObjects(String jsonString) {
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


    private static byte[] createPDF(ArrayList<JSONObject> orders){
        LabelFormatter formatter = new LabelFormatter();
        String htmlcode = formatter.createCode(orders);

        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            Document document = new Document();
            PdfWriter.getInstance(document, baos);
            document.open();
            HTMLWorker htmlWorker = new HTMLWorker(document);
            htmlWorker.parse(new StringReader(htmlcode));
            document.close();
            return baos.toByteArray();

        } catch (Exception e) {
            e.printStackTrace();
            return null;

        }
    }


    public int getLabel(Request request, Response response) throws IOException {

        ArrayList<JSONObject> orders = createListOfJSONObjects(request.queryParams("orders"));
        response.header("Content-Type", "application/pdf");
        ServletOutputStream outputStream = response.raw().getOutputStream();
        outputStream.write(createPDF(orders));
        outputStream.flush();
        outputStream.close();

        return 200;
    }

    public String status(Request request, Response response) {
        return "OK";
    }
}
