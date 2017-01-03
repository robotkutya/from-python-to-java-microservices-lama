package delivery_label_generator_service;

/**
 * Created by cave on 2017.01.03..
 */
public class DeliveryLabelGeneratorController {

    private String qrGenerator(){
        return "url";
    }

    private String htmlGenerator(){
        return "html code";
    }

    private void pdfCreator(){
    }

    public String getLabel(){
        return "response";
    }
}
