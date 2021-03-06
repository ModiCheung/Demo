package com.jwt.demo.delayqueue.common.redis;

import lombok.Data;
import org.springframework.context.annotation.Configuration;

/**
 * redis lua脚本配置类
 */
@Data
@Configuration("redis-lua")
public class RedisLuaConfig {

    private String delayQueueLua;

}
