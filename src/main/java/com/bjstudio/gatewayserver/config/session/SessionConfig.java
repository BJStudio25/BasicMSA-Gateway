package com.bjstudio.gatewayserver.config.session;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.FlushMode;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.session.web.context.AbstractHttpSessionApplicationInitializer;

/**
 * SessionConfig
 */
@EnableRedisHttpSession(flushMode = FlushMode.IMMEDIATE)
@Configuration
public class SessionConfig extends AbstractHttpSessionApplicationInitializer {

    
}