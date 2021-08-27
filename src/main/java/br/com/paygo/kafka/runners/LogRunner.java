package br.com.paygo.kafka.runners;

import br.com.paygo.kafka.services.impl.LogService;

public class LogRunner {

    public static void main(String[] args) {
        LogService service = new LogService();
        service.run();
    }

}
