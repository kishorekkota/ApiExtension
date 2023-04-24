package com.example.common;

import com.example.depositsaccountapi.DepositAccountPOJO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


public interface BaseController <T> {



    @PostMapping("/validation")
    public T validation(@RequestBody T pojo);

    @PostMapping("/pre_processing")
    public T pre_processing(@RequestBody T pojo);

    @PostMapping("/execute")
    public T execute(@RequestBody T pojo);

    @PostMapping("/post_processing")
    public T post_processing(@RequestBody T pojo);

    @PostMapping("/event_publishing")
    public T event_publishing(@RequestBody T pojo);

}
