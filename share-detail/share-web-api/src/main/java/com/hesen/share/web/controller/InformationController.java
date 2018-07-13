package com.hesen.share.web.controller;

import com.hesen.share.common.page.PageDTO;
import com.hesen.share.common.res.JsonObjectResponse;
import com.hesen.share.domain.request.InformationRequest;
import com.hesen.share.domain.result.InformationDTO;
import com.hesen.share.integration.information.InformationIntergration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Hesen
 * @CreateDate: 2018/4/20 15:52
 *
 * 资讯
 */
@RestController
@RequestMapping(value = "/api/web/information/")
public class InformationController {

    @Autowired
    InformationIntergration informationIntergration;

    private static Logger logger = LoggerFactory.getLogger(InformationController.class);

    /**
     * 资讯列表
     * @param requestParam
     * @return
     */
    @RequestMapping(value = "list", method = RequestMethod.POST)
    public JsonObjectResponse<PageDTO> list(InformationRequest requestParam){

        return informationIntergration.queryInformationList(requestParam);
    }

    /**
     * 资讯详情
     * @param requestParam
     * @return
     */
    @RequestMapping(value = "detail", method = RequestMethod.POST)
    public JsonObjectResponse<InformationDTO> detail(InformationRequest requestParam){

        return informationIntergration.queryInformationDetail(requestParam);
    }

}
