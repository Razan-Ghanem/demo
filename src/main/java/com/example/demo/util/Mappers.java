package com.example.demo.util;

import com.example.demo.controllar.dto.InvoiceDto;
import com.example.demo.model.Invoice;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

import java.util.List;

public class Mappers {
    private static MapperFactory factory = new DefaultMapperFactory.Builder().build();

    static {

    }
    public static <T> T map(Class dest, Object object) {
        if (object == null) {
            return null;
        }
        MapperFacade mapper = factory.getMapperFacade();
        return (T) mapper.map(object, dest);
    }

    public static <T> List<T> mapAsList(Class dest, List<Object> objects) {
        if (objects == null) {
            return null;
        }
        MapperFacade mapper = factory.getMapperFacade();
        return (List<T>) mapper.mapAsList(objects, dest);
    }

}
