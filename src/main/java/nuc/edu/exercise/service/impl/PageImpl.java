package nuc.edu.exercise.service.impl;

import lombok.extern.slf4j.Slf4j;
import nuc.edu.exercise.dao.SeckillUserDao;
import nuc.edu.exercise.model.SeckillUser;
import nuc.edu.exercise.service.Page;
import nuc.edu.exercise.util.bean.CommonQueryBean;
import nuc.edu.exercise.util.bean.PageReq;
import nuc.edu.exercise.util.bean.PageResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Slf4j
@Service
public class PageImpl implements Page {

    @Autowired
    private SeckillUserDao seckillUserDao;

    /**
     *
     * @param count //总记录数
     * @param pageSize //每页的记录数
     * @return
     */
    public static int getPageCount(int count,int pageSize){
        if (pageSize == 0) {
            return 0;
        } else {
            return count % pageSize == 0 ? count / pageSize : count / pageSize + 1;
            //如果count能够被pageSize整除（即count % pageSize == 0），则总页数等于count除以pageSize。
            //如果count不能被pageSize整除（即count % pageSize != 0），则总页数等于count除以pageSize再加1。
        }

    }
    @Override
    public PageResp<SeckillUser> page(PageReq req) {
        int start = (req.getPage()-1) * req.getPageSize();//计算起始位置
        SeckillUser user = new SeckillUser();
        CommonQueryBean queryBean = new CommonQueryBean();
        queryBean.setStart(start);
        queryBean.setPageSize(req.getPageSize());

        List<SeckillUser> list = seckillUserDao.list4Page(user, queryBean);
        int count = (int)seckillUserDao.count(user);
        PageResp pageResp = new PageResp();
        pageResp.setList(list);
//        System.out.println(req.getPage());
//        System.out.println(getPageCount(start + 1, req.getPageSize()));
//        pageResp.setPageNum(getPageCount(start + 1, req.getPageSize()));
        pageResp.setPageNum(req.getPage());
        pageResp.setPageSize(req.getPageSize());
        pageResp.setTotalNum(count);
        pageResp.setTotalPage(getPageCount(count, req.getPageSize()));

        return pageResp;
    }
}
