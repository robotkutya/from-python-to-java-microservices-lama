package delivery_label_generator_service;


import org.json.JSONObject;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;

/**
 * Created by cave on 2017.01.03..
 */
public class DeliveryLabelGeneratorController {

    private String qrGenerator(String id){


        return "url";
    }

    private String htmlGenerator(ArrayList<JSONObject> orderList){
        String htmlCode = "<html><body>";
        for (JSONObject order : orderList) {
            htmlCode += "<div>";
            htmlCode += "<img src=\"" + qrGenerator(order.getString("id")) + "\" height=\"42\" width=\"42\">";
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

    public String getLabel(req){
        return "response";
    }
}
