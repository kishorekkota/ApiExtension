package com.example.depositsaccountapi;

import com.example.common.BaseController;
import org.apache.commons.logging.Log;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DepositsRestController implements BaseController<DepositAccountPOJO> {

    Log log = org.apache.commons.logging.LogFactory.getLog(DepositsRestController.class);

    @Override
    public DepositAccountPOJO validation(DepositAccountPOJO pojo) {

        log.info("validation");

        return pojo;
    }

    @Override
    public DepositAccountPOJO pre_processing(DepositAccountPOJO pojo) {
        log.info("pre_processing");

        pojo.getDeposits_api_ext().setPre_processing("pre_processing");

        System.out.println(pojo);
        return pojo;
    }

    @Override
    public DepositAccountPOJO execute(DepositAccountPOJO pojo) {
        log.info("execute");

        return pojo;
    }

    @Override
    public DepositAccountPOJO post_processing(DepositAccountPOJO pojo) {
        log.info("post_processing");

        pojo.getDeposits_api_ext().setPost_processing("post_processing");

        return pojo;
    }

    @Override
    public DepositAccountPOJO event_publishing(DepositAccountPOJO pojo) {
        log.info("event_publishing");

        pojo.getDeposits_api_ext().setEvent_publishing("event_publishing");
        return pojo;
    }
}
