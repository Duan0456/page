package nuc.edu.exercise.service.impl;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import nuc.edu.exercise.base.BaseResponse;
import nuc.edu.exercise.dao.SeckillOrderDao;
import nuc.edu.exercise.execption.ErrorMessage;
import nuc.edu.exercise.model.SeckillOrder;
import nuc.edu.exercise.service.Base4;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;

@Service
@Slf4j
public class BaseImpl implements Base4 {
    @Autowired
    private SeckillOrderDao seckillOrderDao;

    @Override
    public BaseResponse insert(SeckillOrder order) {
        LocalDateTime currentTime = LocalDateTime.now();
        Date date = new Date();
        order.setCreateTime(date);
//        order.setCreateTime(currentTime);
        if(order == null){
            return BaseResponse.error(ErrorMessage.ORDER_ERROR);
        }
        seckillOrderDao.insert(order);
        return BaseResponse.OK;
    }

    @Override
    public BaseResponse delete(SeckillOrder order) {
        seckillOrderDao.deleteByPrimaryKey(order.getId());
        return BaseResponse.OK;
    }

    @Override
    public BaseResponse update(SeckillOrder order) {
        seckillOrderDao.updateByPrimaryKeySelective(order);
        return BaseResponse.OK;
    }

    @Override
    public SeckillOrder search(Long id) {
        seckillOrderDao.selectByPrimaryKey(id);
        return seckillOrderDao.selectByPrimaryKey(id);
    }
}
