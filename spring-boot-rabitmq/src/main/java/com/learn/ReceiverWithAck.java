package com.learn;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

/**
 * Consumer with manual acknowledgement
 * 
 * @author MALLIKARJUN
 *
 */
public class ReceiverWithAck {
    private static final String QUEUE_NAME = "hello";
    
    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("localhost");
        
        Connection connection = connectionFactory.newConnection();
        Channel channel = connection.createChannel();
        /*
         * DeliverCallback deliverCallback = (consumerTag, delivery) -> { String message = new
         * String(delivery.getBody(), "UTF-8"); System.out.println(" [x] Received '" + message + "'"); };
         */
        boolean autoAck = false;
        channel.basicConsume(QUEUE_NAME, autoAck, "a-consumer-tag", new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties,
                    byte[] body) throws IOException {
                long deliveryTag = envelope.getDeliveryTag();
                System.out.println(" [x] Received '" + new String(body) + "' Delivery Tag '" + deliveryTag + "'");
                // positively acknowledge a single delivery, the message will
                // be discarded
                channel.basicAck(deliveryTag, false);
            }
        });
    }
}
