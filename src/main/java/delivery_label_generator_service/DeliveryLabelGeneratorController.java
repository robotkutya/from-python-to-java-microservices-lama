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

    private ArrayList<JSONObject> createListOfJSONObjects(String jsonString) {
        ArrayList<JSONObject> deliveryLabels = new ArrayList<JSONObject>();
        JSONArray jsonArray = new JSONArray(jsonString);
        for (Object object: jsonArray) {
            deliveryLabels.add(new JSONObject(object.toString()));
        }
        return deliveryLabels;
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
