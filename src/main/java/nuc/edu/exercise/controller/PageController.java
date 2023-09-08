package nuc.edu.exercise.controller;

import lombok.extern.slf4j.Slf4j;
import nuc.edu.exercise.base.BaseRequest;
import nuc.edu.exercise.base.BaseResponse;
import nuc.edu.exercise.model.SeckillUser;
import nuc.edu.exercise.service.impl.PageImpl;
import nuc.edu.exercise.util.bean.PageReq;
import nuc.edu.exercise.util.bean.PageResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("page")
@Slf4j
public class PageController {

    @Autowired
    private PageImpl page;

    @RequestMapping("page1")
    public BaseResponse<PageResp<SeckillUser>> page(@Valid @RequestBody PageReq pageReq){
        return BaseResponse.OK(page.page(pageReq));
    }
}
