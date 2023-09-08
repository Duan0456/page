package nuc.edu.exercise.service.impl;

import lombok.extern.slf4j.Slf4j;
import nuc.edu.exercise.base.BaseResponse;
import nuc.edu.exercise.dao.SeckillOrderDao;
import nuc.edu.exercise.dao.SeckillProductsDao;
import nuc.edu.exercise.dao.SeckillUserDao;
import nuc.edu.exercise.model.SeckillOrder;
import nuc.edu.exercise.model.SeckillProducts;
import nuc.edu.exercise.model.SeckillUser;
import nuc.edu.exercise.model.http.SeckillReq;
import nuc.edu.exercise.service.Scheduled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@Slf4j
public class ScheduledImpl implements Scheduled {

    @Autowired
    private SeckillOrderDao seckillOrderDao;

    @Autowired
    private SeckillProductsDao seckillProductsDao;

    @Override
    public BaseResponse createOrder(SeckillReq req) {
        Long productId = req.getProductId();
        Long userId = req.getUserId();
        SeckillProducts products = seckillProductsDao.selectByPrimaryKey(productId);

        Date date = new Date();

        SeckillOrder order = new SeckillOrder();
        order.setCreateTime(date);
        order.setProductId(productId);
        order.setProductName(products.getName());
        order.setUserId(userId);
        seckillOrderDao.insert(order);
        log.info("订单创建成功");
        return BaseResponse.OK;
    }

    @Override
    public BaseResponse check(int state) {
        seckillOrderDao.check(state);
        return BaseResponse.OK;
    }

    @Override
    public BaseResponse pay(SeckillReq req) {
        SeckillOrder order = seckillOrderDao.selectByPrimaryKey(req.getId());
        seckillOrderDao.pay(order);
        return BaseResponse.OK;
    }

}
