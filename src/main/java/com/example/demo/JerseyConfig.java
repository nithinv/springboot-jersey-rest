package com.example.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

/**
 * Created by vadyan on 6/23/2017.
 */
@Component
@ApplicationPath("/v1")
public class JerseyConfig extends ResourceConfig {

    @Autowired
    public JerseyConfig(ObjectMapper objectMapper) {
        // register endpoints
        packages("com.example.demo") ;

        register(new ObjectMapperContextResolver(objectMapper));
    }

    @Provider
    public static class ObjectMapperContextResolver implements ContextResolver<ObjectMapper> {

        private final ObjectMapper mapper ;

        public ObjectMapperContextResolver(ObjectMapper mapper) {
            this.mapper = mapper;
        }

        @Override
        public ObjectMapper getContext(Class<?> type) {
            return mapper ;
        }
    }
}
