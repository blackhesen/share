package com.hesen.share.facade.impl.information;

import com.hesen.share.common.page.PageDTO;
import com.hesen.share.common.res.JsonObjectResponse;
import com.hesen.share.common.utils.res.ResUtils;
import com.hesen.share.domain.request.InformationRequest;
import com.hesen.share.domain.result.InformationDTO;
import com.hesen.share.facade.information.InformationFacede;
import com.hesen.share.repo.dao.InformationDAO;
import com.hesen.share.repo.dataobject.InformationDO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: Hesen
 * @CreateDate: 2018/4/20 16:31
 */
@Service
public class InformationFacadeImpl implements InformationFacede{

    private static Logger logger = LoggerFactory.getLogger(InformationFacadeImpl.class);

    @Autowired
    InformationDAO informationDAO;

    @Override
    public JsonObjectResponse<PageDTO> queryInformationList(InformationRequest requestParam) {
        //查询列表

        return ResUtils.success(new PageDTO());
    }

    @Override
    public JsonObjectResponse<InformationDTO> queryInformationDetail(InformationRequest requestParam) {

        InformationDO informationDO = informationDAO.getByPrimary(requestParam.getId());

        InformationDTO informationDTO = new InformationDTO();
        //数据转换
        if (informationDO != null){
            informationDTO.setId(informationDO.getId())
                    .setDownTime(informationDO.getDownTime())
                    .setInfoTitle(informationDO.getInfoTitle())
                    .setInfoType(informationDO.getInfoType())
                    .setInfoUrl(informationDO.getInfoUrl())
                    .setOrders(informationDO.getOrders())
                    .setReportSts(informationDO.getReportSts())
                    .setReportTime(informationDO.getReportTime());
        }

        return ResUtils.success(informationDTO);
    }
}
