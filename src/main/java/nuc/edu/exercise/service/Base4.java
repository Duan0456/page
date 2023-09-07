package nuc.edu.exercise.service;

import nuc.edu.exercise.base.BaseResponse;
import nuc.edu.exercise.model.SeckillOrder;

public interface Base4 {
    BaseResponse insert(SeckillOrder order);
    BaseResponse delete(SeckillOrder order);
    BaseResponse update(SeckillOrder order);
    SeckillOrder search(Long id);
}
