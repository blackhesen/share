package com.hesen.share.integration.information;

import com.hesen.share.common.page.PageDTO;
import com.hesen.share.common.res.JsonObjectResponse;
import com.hesen.share.domain.request.InformationRequest;
import com.hesen.share.domain.result.InformationDTO;
import com.hesen.share.facade.information.InformationFacede;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author: Hesen
 * @CreateDate: 2018/4/20 16:15
 *
 * 资讯集成服务
 */
@Component
public class InformationIntergration {

    @Autowired
    InformationFacede informationFacede;

    /**
     * 资讯列表
     * @param requestParam
     * @return
     */
    public JsonObjectResponse<PageDTO> queryInformationList(InformationRequest requestParam) {
        return informationFacede.queryInformationList(requestParam);
    }

    /**
     * 资讯详情
     * @param requestParam
     * @return
     */
    public JsonObjectResponse<InformationDTO> queryInformationDetail(InformationRequest requestParam) {
        return informationFacede.queryInformationDetail(requestParam);
    }
}
