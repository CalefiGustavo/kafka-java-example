package br.com.paygo.kafka.runners;

import br.com.paygo.kafka.services.impl.FraudDetectorService;

public class FraudDetectorRunner {

    public static void main(String[] args) {
        FraudDetectorService service = new FraudDetectorService();
        service.run();
    }

}
