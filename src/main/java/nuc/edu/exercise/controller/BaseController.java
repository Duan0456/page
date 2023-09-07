package nuc.edu.exercise.controller;


import lombok.extern.slf4j.Slf4j;
import nuc.edu.exercise.base.BaseRequest;
import nuc.edu.exercise.base.BaseResponse;
import nuc.edu.exercise.execption.ErrorMessage;
import nuc.edu.exercise.model.SeckillOrder;
import nuc.edu.exercise.model.http.SeckillReq;
import nuc.edu.exercise.service.impl.BaseImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@Slf4j
@RequestMapping("/4")
public class BaseController {
    @Autowired
    private BaseImpl base;


    @RequestMapping("insert")
    public BaseResponse insert(@Valid @RequestBody BaseRequest<SeckillOrder> request){
        SeckillOrder order = request.getData();
        if(order == null){
            return BaseResponse.error(ErrorMessage.ORDER_ERROR);
        }

        return base.insert(order);

    }

    @RequestMapping("delete")
    public BaseResponse delete(@Valid @RequestBody BaseRequest<SeckillOrder> request) {
        SeckillOrder order = request.getData();
        return base.delete(order);
    }
    @RequestMapping("update")
    public BaseResponse update(@Valid @RequestBody BaseRequest<SeckillOrder> request) {
        SeckillOrder order = request.getData();
        return base.update(order);
    }
    @RequestMapping("search")
    public BaseResponse search(@Valid @RequestBody BaseRequest<SeckillOrder> request) {
        SeckillOrder order = request.getData();
        base.search(order.getId());
        return BaseResponse.OK;
    }





//@RequestMapping("insert")
//public BaseResponse insert(@Valid @RequestBody SeckillOrder order){
//    if(order == null){
//        return BaseResponse.error(ErrorMessage.ORDER_ERROR);
//    }
//
//    return base.insert(order);

//}
}
