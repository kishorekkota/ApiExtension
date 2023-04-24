package com.example.apiextension;

import com.fasterxml.jackson.databind.ser.Serializers;

public interface GenericService <T> {

    public T validation(T pojo);

    public T pre_processing(T pojo);

    public T execute(T pojo);

    public T post_processing(T pojo);

    public T event_publishing(T pojo);



}
