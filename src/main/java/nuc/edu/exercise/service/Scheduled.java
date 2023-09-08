package nuc.edu.exercise.service;

import nuc.edu.exercise.base.BaseResponse;
import nuc.edu.exercise.model.SeckillOrder;
import nuc.edu.exercise.model.http.SeckillReq;

public interface Scheduled {
    BaseResponse createOrder(SeckillReq req);
    BaseResponse check(int state);
    BaseResponse pay(SeckillReq req);

}
