package br.com.paygo.kafka;

import br.com.paygo.kafka.dispatchers.KafkaDispatcher;
import br.com.paygo.kafka.models.Order;
import br.com.paygo.kafka.models.Partner;
import br.com.paygo.kafka.utils.LoremIpsum;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.kafka.clients.producer.Callback;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;


public class NewOrderMain {

    private static LoremIpsum loremGenerator = new LoremIpsum();

    public static void main(String[] args) throws ExecutionException, InterruptedException, IOException {
        KafkaDispatcher dispatcher = new KafkaDispatcher<Order>();
        sendMessage(dispatcher, "dev.Merchant");
//        sendMessage(dispatcher, "dev.cron.PartnerData");
//        sendMessage(dispatcher, "KAFKA_SEND_EMAIL");
        dispatcher.close();
    }

    private static void sendMessageRandom(KafkaDispatcher dispatcher, String topic) throws ExecutionException, InterruptedException {
        String userId = novaPalavra();
        Order newOrder = new Order(userId, true, randomPartners());
        dispatcher.send(topic, userId, newOrder, getCallback());
    }

    private static void sendMessage(KafkaDispatcher dispatcher, String topic) throws ExecutionException, InterruptedException {
        String userId = "37171822000145";
        Order newOrder = new Order(userId, true, getPartners());
        dispatcher.send(topic, userId, newOrder, getCallback());
    }

    private static List<Partner> randomPartners() {
        List<Partner> partners = new ArrayList<>();
        for (int i = 0; i <= randomInt(); i++) {
            partners.add(new Partner(novaPalavra(), novaPalavra(), novaPalavra(), novaPalavra()));
        }
        return partners;
    }

    private static List<Partner> getPartners() {
        List<Partner> partners = new ArrayList<>();
        partners.add(new Partner("64232733000134", "ALEATORIO UM", "DISTRIBUTOR", "AWAITING_INSTALLATION"));
        partners.add(new Partner("58249703000138", "ALEATORIO DOIS", "INTEGRATOR", "INSTALLED"));
        partners.add(new Partner("78597573000131", "ALEATORIO TRES", "REPRESENTATIVE", "CANCELLED"));
        partners.add(new Partner("52142000000120", "ALEATORIO QUATRO", "INTEGRATOR", "CANCELLED"));
        return partners;
    }

    private static String novaPalavra() {
        return RandomStringUtils.random(5, true, false);
    }

    public static int randomInt(){
        return new Random().nextInt(10) + 1;
    }

    private static Callback getCallback() {
        return (data, ex) -> {
            if (ex != null) {
                ex.printStackTrace();
                return;
            }
            System.out.println(data.toString());
        };
    }

}
