package nuc.edu.exercise.controller;


import lombok.extern.slf4j.Slf4j;
import nuc.edu.exercise.base.BaseRequest;
import nuc.edu.exercise.base.BaseResponse;
import nuc.edu.exercise.model.SeckillOrder;
import nuc.edu.exercise.model.http.SeckillReq;
import nuc.edu.exercise.service.impl.ScheduledImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@Slf4j
@RequestMapping("/Sche")
public class ScheduledController {

    @Autowired
    private ScheduledImpl scheduled;

    @RequestMapping("/insert")
    public BaseResponse insert(@Valid @RequestBody BaseRequest<SeckillReq> request){
        SeckillReq req = request.getData();
        scheduled.createOrder(req);
        return BaseResponse.OK;
    }

    @RequestMapping("/pay")
    public BaseResponse pay(@Valid @RequestBody BaseRequest<SeckillReq> request){
        SeckillReq req = request.getData();
        scheduled.pay(req);
        return BaseResponse.OK;
    }
}
