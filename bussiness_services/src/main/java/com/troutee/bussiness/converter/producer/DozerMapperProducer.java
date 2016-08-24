package com.troutee.bussiness.converter.producer;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

@ApplicationScoped
public class DozerMapperProducer {
    @Produces
    public Mapper get() {
        return new DozerBeanMapper();
    }
}
