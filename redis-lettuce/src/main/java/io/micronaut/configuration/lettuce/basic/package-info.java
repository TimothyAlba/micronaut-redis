@Requires(missingProperty = RedisSetting.REDIS_URIS)
@Requires(missingProperty = RedisSetting.REDIS_URI)
package io.micronaut.configuration.lettuce.basic;

import io.micronaut.configuration.lettuce.RedisSetting;
import io.micronaut.context.annotation.Requires;