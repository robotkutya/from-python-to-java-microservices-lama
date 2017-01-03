package delivery_label_generator_service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static spark.Spark.get;
import static spark.Spark.port;

/**
 * Created by cave on 2017.01.03..
 */
public class DeliveryLabelGeneratorService {
    private static final Logger logger = LoggerFactory.getLogger(DeliveryLabelGeneratorService.class);

    private DeliveryLabelGeneratorController controller;

    public static void main(String[] args) {
        logger.debug("Starting " + DeliveryLabelGeneratorService.class.getName() + "...");

        setup(args);

        DeliveryLabelGeneratorService application = new DeliveryLabelGeneratorService();
        application.controller = new DeliveryLabelGeneratorController();

        get("/api/status", (application.controller::status));
        get("/api/create-label", (application.controller::getLabel));
    }

    private static void setup(String[] args) {
        if (args == null || args.length == 0) {
            logger.error("Port must be given as the first argument.");
            System.exit(-1);
        }

        try {
            port(Integer.parseInt(args[0]));
        } catch (NumberFormatException e) {
            logger.error("Invalid port given '{}', it should be number.", args[0]);
            System.exit(-1);
        }
    }
}
