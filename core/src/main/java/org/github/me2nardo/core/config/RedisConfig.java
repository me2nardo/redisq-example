package org.github.me2nardo.core.config;

import ca.radiant3.redisq.RedisMessageQueue;
import ca.radiant3.redisq.persistence.RedisOps;
import ca.radiant3.redisq.producer.MessageProducer;
import ca.radiant3.redisq.producer.MessageProducerImpl;
import ca.radiant3.redisq.serialization.Jackson2PayloadSerializer;
import ca.radiant3.redisq.serialization.PayloadSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.util.concurrent.TimeUnit;

/**
 * Created by leo on 20.12.16.
 */
@Configuration
public class RedisConfig {

    @Bean
    public RedisConnectionFactory connectionFactory() {
        JedisConnectionFactory factory = new JedisConnectionFactory();
        factory.setHostName("localhost");
        factory.setPort(6379);
        factory.setUsePool(true);
        return factory;
    }

    @Bean
    public PayloadSerializer payloadSerializer(){
        return new Jackson2PayloadSerializer();
    }

    @Bean
    public RedisTemplate redisTemplateQ(){
        RedisTemplate redisTemplate = new RedisTemplate();
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setConnectionFactory(connectionFactory());
        return redisTemplate;
    }

    @Bean
    public RedisOps redisOps(){
        RedisOps redisOps = new RedisOps();
        redisOps.setRedisTemplate(redisTemplateQ());

        return redisOps;
    }

    @Bean
    public RedisMessageQueue myQueue(){
        RedisMessageQueue redisMessageQueue = new RedisMessageQueue();
        redisMessageQueue.setQueueName("Sending");
        redisMessageQueue.setRedisOps(redisOps());


        redisMessageQueue.setDefaultConsumerId("someConsumerId");

        return redisMessageQueue;
    }

    @Bean
    public MessageProducer messageProducer(){
        MessageProducerImpl messageProducer = new MessageProducerImpl();
        messageProducer.setQueue(myQueue());
        messageProducer.setRedisOps(redisOps());
        messageProducer.setDefaultTimeToLive(10);
        messageProducer.setDefaultTimeToLiveUnit(TimeUnit.MINUTES);
        return messageProducer;
    }
}
