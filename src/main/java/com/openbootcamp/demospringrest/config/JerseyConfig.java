package com.openbootcamp.demospringrest.config;


import com.openbootcamp.demospringrest.services.BootcamperService;
import com.openbootcamp.demospringrest.services.UserService;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


import javax.ws.rs.ApplicationPath;

@Configuration
@ApplicationPath("/")
public class JerseyConfig extends ResourceConfig{
    public JerseyConfig(){
        this.packages("com.openbootcamp.demospringrest.controllers");
    }

    @Bean
    public BootcamperService bootcamperService() {
        return new BootcamperService();
    }

    @Bean
    public UserService userService() {
        return new UserService();
    }
}
