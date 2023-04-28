package org.example.ServiceBus;

import com.azure.messaging.servicebus.*;
import org.example.util.PropertiesUtil;

import java.util.List;
import java.util.stream.StreamSupport;

public class ServiceBusReceiver {
    public static void main(String[] args) {
        String connectionString = PropertiesUtil.getProperty("spring.jms.servicebus.connection-string");
        String queueName = PropertiesUtil.getProperty("app.queueName");

        ServiceBusReceiverClient receiver = new ServiceBusClientBuilder()
                .connectionString(connectionString)
                .receiver()
                .queueName(queueName)
                .buildClient();

        List<ServiceBusReceivedMessage> receivedMessages =
                StreamSupport.stream(receiver.receiveMessages(10000).spliterator(), false)
                        .toList();

        for (ServiceBusReceivedMessage message : receivedMessages) {
            System.out.printf("Received message with ID: %s, Body: %s%n",
                    message.getMessageId(), message.getBody());
            receiver.complete(message);
        }

        receiver.close();
    }
}
