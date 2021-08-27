package br.com.paygo.kafka.runners;

import br.com.paygo.kafka.services.impl.EmailService;

public class EmailRunner {

    public static void main(String[] args) {
        EmailService service = new EmailService();
        service.run();
    }

}
