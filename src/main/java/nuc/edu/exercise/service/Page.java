package nuc.edu.exercise.service;

import nuc.edu.exercise.model.SeckillUser;
import nuc.edu.exercise.util.bean.CommonQueryBean;
import nuc.edu.exercise.util.bean.PageReq;
import nuc.edu.exercise.util.bean.PageResp;

public interface Page {
    PageResp<SeckillUser> page(PageReq req);
}
