package io.micronaut.configuration.lettuce.basic;

import io.lettuce.core.RedisClient;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.pubsub.StatefulRedisPubSubConnection;
import io.micronaut.configuration.lettuce.AbstractRedisClientFactory;
import io.micronaut.configuration.lettuce.AbstractRedisConfiguration;
import io.micronaut.context.annotation.Bean;
import io.micronaut.context.annotation.Factory;
import io.micronaut.context.annotation.Primary;

import javax.inject.Singleton;

@Singleton
@Factory
public class DefaultRedisClientFactory extends AbstractRedisClientFactory {

    @Bean(preDestroy = "shutdown")
    @Singleton
    @Primary
    @Override
    public RedisClient redisClient(@Primary AbstractRedisConfiguration config) {
        return super.redisClient(config);
    }

    @Override
    @Bean(preDestroy = "close")
    @Singleton
    @Primary
    public StatefulRedisConnection<String, String> redisConnection(@Primary RedisClient redisClient) {
        return super.redisConnection(redisClient);
    }

    @Override
    @Bean(preDestroy = "close")
    @Singleton
    public StatefulRedisPubSubConnection<String, String> redisPubSubConnection(@Primary RedisClient redisClient) {
        return super.redisPubSubConnection(redisClient);
    }
}
