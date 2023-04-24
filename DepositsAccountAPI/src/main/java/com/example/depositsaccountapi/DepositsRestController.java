package com.example.depositsaccountapi;

import com.example.common.BaseController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DepositsRestController implements BaseController<DepositAccountPOJO> {


    @Override
    public DepositAccountPOJO validation(DepositAccountPOJO pojo) {

        System.out.println(pojo);

        return pojo;
    }

    @Override
    public DepositAccountPOJO pre_processing(DepositAccountPOJO pojo) {
        System.out.println(pojo);

        pojo.getDeposits_api_ext().setPre_processing("pre_processing");

        System.out.println(pojo);
        return pojo;
    }

    @Override
    public DepositAccountPOJO execute(DepositAccountPOJO pojo) {
        System.out.println(pojo);

        return pojo;
    }

    @Override
    public DepositAccountPOJO post_processing(DepositAccountPOJO pojo) {
        System.out.println(pojo);

        pojo.getDeposits_api_ext().setPost_processing("post_processing");

        return pojo;
    }

    @Override
    public DepositAccountPOJO event_publishing(DepositAccountPOJO pojo) {
        System.out.println(pojo);

        pojo.getDeposits_api_ext().setEvent_publishing("event_publishing");
        return pojo;
    }
}
