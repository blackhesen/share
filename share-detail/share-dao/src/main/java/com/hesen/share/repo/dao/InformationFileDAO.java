package com.hesen.share.repo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.hesen.share.repo.dataobject.InformationFileDO;
import com.hesen.share.repo.mapper.InformationFileDOMapper;

/**
* The Table H_INFORMATION_FILE.
* H_INFORMATION_FILE
*/
@Repository
public class InformationFileDAO{

    @Autowired
    private InformationFileDOMapper informationFileDOMapper;

    /**
     * desc:插入表:H_INFORMATION_FILE.<br/>
     * descSql =  SELECT LAST_INSERT_ID() INSERT INTO H_INFORMATION_FILE( ID ,INFO_ID ,ORDERS ,PIC_URL ,VERSION ,FILE_TYPE ,CREATE_TIME ,CREATE_USER ,DELETE_FLAG ,UPDATE_TIME ,UPDATE_USER )VALUES( #{id,jdbcType=VARCHAR} , #{infoId,jdbcType=VARCHAR} , #{orders,jdbcType=INTEGER} , #{picUrl,jdbcType=VARCHAR} , #{version,jdbcType=INTEGER} , #{fileType,jdbcType=VARCHAR} , #{createTime,jdbcType=BIGINT} , #{createUser,jdbcType=VARCHAR} , #{deleteFlag,jdbcType=CHAR} , #{updateTime,jdbcType=BIGINT} , #{updateUser,jdbcType=VARCHAR} )
     * @param entity entity
     * @return Long
     */
    public Long insert(InformationFileDO entity){
        return informationFileDOMapper.insert(entity);
    }
    /**
     * desc:更新表:H_INFORMATION_FILE.<br/>
     * descSql =  UPDATE H_INFORMATION_FILE SET INFO_ID = #{infoId,jdbcType=VARCHAR} ,ORDERS = #{orders,jdbcType=INTEGER} ,PIC_URL = #{picUrl,jdbcType=VARCHAR} ,VERSION = #{version,jdbcType=INTEGER} ,FILE_TYPE = #{fileType,jdbcType=VARCHAR} ,CREATE_TIME = #{createTime,jdbcType=BIGINT} ,CREATE_USER = #{createUser,jdbcType=VARCHAR} ,DELETE_FLAG = #{deleteFlag,jdbcType=CHAR} ,UPDATE_TIME = #{updateTime,jdbcType=BIGINT} ,UPDATE_USER = #{updateUser,jdbcType=VARCHAR} WHERE ID = #{id,jdbcType=VARCHAR}
     * @param entity entity
     * @return Long
     */
    public Long update(InformationFileDO entity){
        return informationFileDOMapper.update(entity);
    }
    /**
     * desc:根据主键删除数据:H_INFORMATION_FILE.<br/>
     * descSql =  DELETE FROM H_INFORMATION_FILE WHERE ID = #{id,jdbcType=VARCHAR}
     * @param id id
     * @return Long
     */
    public Long deleteByPrimary(String id){
        return informationFileDOMapper.deleteByPrimary(id);
    }
    /**
     * desc:根据主键获取数据:H_INFORMATION_FILE.<br/>
     * descSql =  SELECT * FROM H_INFORMATION_FILE WHERE ID = #{id,jdbcType=VARCHAR}
     * @param id id
     * @return InformationFileDO
     */
    public InformationFileDO getByPrimary(String id){
        return informationFileDOMapper.getByPrimary(id);
    }
}
