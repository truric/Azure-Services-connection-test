package org.example.ServiceBus;

import com.azure.messaging.servicebus.ServiceBusClientBuilder;
import com.azure.messaging.servicebus.ServiceBusMessage;
import com.azure.messaging.servicebus.ServiceBusSenderClient;
import org.example.util.PropertiesUtil;

public class ServiceBusSender {
    public static void main(String[] args) {
        String connectionString = PropertiesUtil.getProperty("spring.jms.servicebus.connection-string");
        String queueName = PropertiesUtil.getProperty("app.queueName");

        ServiceBusSenderClient sender = new ServiceBusClientBuilder()
                .connectionString(connectionString)
                .sender()
                .queueName(queueName)
                .buildClient();

        for (int i = 0; i < 10; i++) {
            ServiceBusMessage message = new ServiceBusMessage("Message " + i);
            sender.sendMessage(message);
        }

        sender.close();
    }
}