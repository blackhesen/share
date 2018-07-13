package com.hesen.share.facade.information;

import com.hesen.share.common.page.PageDTO;
import com.hesen.share.common.res.JsonObjectResponse;
import com.hesen.share.domain.request.InformationRequest;
import com.hesen.share.domain.result.InformationDTO;

/**
 * @Author: Hesen
 * @CreateDate: 2018/4/20 16:18
 *
 * 资讯
 */
public interface InformationFacede {

    /**
     * 资讯列表
     * @param requestParam
     * @return
     */
    JsonObjectResponse<PageDTO> queryInformationList(InformationRequest requestParam);

    /**
     * 资讯详情
     * @param requestParam
     * @return
     */
    JsonObjectResponse<InformationDTO> queryInformationDetail(InformationRequest requestParam);
}
