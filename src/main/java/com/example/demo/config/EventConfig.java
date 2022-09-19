package com.example.demo.config;

import org.hibernate.event.service.spi.EventListenerRegistry;
import org.hibernate.event.spi.EventType;
import org.hibernate.internal.SessionFactoryImpl;
import org.hibernate.service.spi.ServiceRegistryImplementor;
import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import javax.persistence.EntityManagerFactory;
//
//@Configuration
//public class EventConfig {
//
//    @Bean
//    public EventListenerRegistry listenerRegistry(EntityManagerFactory entityManagerFactory) {
//        ServiceRegistryImplementor serviceRegistry = entityManagerFactory.unwrap(SessionFactoryImpl.class).getServiceRegistry();
//
//        EventListenerRegistry listenerRegistry = serviceRegistry.getService(EventListenerRegistry.class);
//
//    }
//
//}
