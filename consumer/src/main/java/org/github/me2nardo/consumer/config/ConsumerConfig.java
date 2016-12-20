package org.github.me2nardo.consumer.config;


import ca.radiant3.redisq.RedisMessageQueue;
import ca.radiant3.redisq.consumer.MessageConsumer;
import ca.radiant3.redisq.consumer.MultiThreadingStrategy;
import ca.radiant3.redisq.consumer.retry.MaxRetriesStrategy;
import ca.radiant3.redisq.persistence.RedisOps;
import org.github.me2nardo.consumer.service.CampaignListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by leo on 20.12.16.
 */
@Configuration
public class ConsumerConfig {

    @Autowired
    private RedisMessageQueue messageQueue;

    @Autowired
    private RedisOps redisOps;

    @Bean
    public MessageConsumer messageConsumer(){
        MessageConsumer messageConsumer = new MessageConsumer();
        messageConsumer.setQueue(messageQueue);
        messageConsumer.setConsumerId("someConsumerId");
        messageConsumer.setMessageListener(new CampaignListener());
        messageConsumer.setAutoStartConsumers(true);
        messageConsumer.setRedisOps(redisOps);
        messageConsumer.setRetryStrategy(new MaxRetriesStrategy(5));

        messageConsumer.setThreadingStrategy(new MultiThreadingStrategy(4));
        return messageConsumer;
    }
}
