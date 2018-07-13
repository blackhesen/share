package com.hesen.share.repo.mapper;

import com.hesen.share.repo.dataobject.InformationDO;
import org.apache.ibatis.annotations.Param;

/**
 * 由于需要对分页支持,请直接使用对应的DAO类
 * The Table H_INFORMATION.
 * H_INFORMATION
 */
public interface InformationDOMapper{

    /**
     * desc:插入表:H_INFORMATION.<br/>
     * descSql =  SELECT LAST_INSERT_ID() INSERT INTO H_INFORMATION( ID ,ORDERS ,INFO_URL ,VERSION ,DOWN_TIME ,INFO_TYPE ,INFO_TITLE ,REPORT_STS ,CREATE_TIME ,CREATE_USER ,DELETE_FLAG ,REPORT_TIME ,UPDATE_TIME ,UPDATE_USER )VALUES( #{id,jdbcType=VARCHAR} , #{orders,jdbcType=INTEGER} , #{infoUrl,jdbcType=VARCHAR} , #{version,jdbcType=INTEGER} , #{downTime,jdbcType=TIMESTAMP} , #{infoType,jdbcType=INTEGER} , #{infoTitle,jdbcType=VARCHAR} , #{reportSts,jdbcType=INTEGER} , #{createTime,jdbcType=BIGINT} , #{createUser,jdbcType=VARCHAR} , #{deleteFlag,jdbcType=CHAR} , #{reportTime,jdbcType=TIMESTAMP} , #{updateTime,jdbcType=BIGINT} , #{updateUser,jdbcType=VARCHAR} )
     * @param entity entity
     * @return Long
     */
    Long insert(InformationDO entity);
    /**
     * desc:更新表:H_INFORMATION.<br/>
     * descSql =  UPDATE H_INFORMATION SET ORDERS = #{orders,jdbcType=INTEGER} ,INFO_URL = #{infoUrl,jdbcType=VARCHAR} ,VERSION = #{version,jdbcType=INTEGER} ,DOWN_TIME = #{downTime,jdbcType=TIMESTAMP} ,INFO_TYPE = #{infoType,jdbcType=INTEGER} ,INFO_TITLE = #{infoTitle,jdbcType=VARCHAR} ,REPORT_STS = #{reportSts,jdbcType=INTEGER} ,CREATE_TIME = #{createTime,jdbcType=BIGINT} ,CREATE_USER = #{createUser,jdbcType=VARCHAR} ,DELETE_FLAG = #{deleteFlag,jdbcType=CHAR} ,REPORT_TIME = #{reportTime,jdbcType=TIMESTAMP} ,UPDATE_TIME = #{updateTime,jdbcType=BIGINT} ,UPDATE_USER = #{updateUser,jdbcType=VARCHAR} WHERE ID = #{id,jdbcType=VARCHAR}
     * @param entity entity
     * @return Long
     */
    Long update(InformationDO entity);
    /**
     * desc:根据主键删除数据:H_INFORMATION.<br/>
     * descSql =  DELETE FROM H_INFORMATION WHERE ID = #{id,jdbcType=VARCHAR}
     * @param id id
     * @return Long
     */
    Long deleteByPrimary(String id);
    /**
     * desc:根据主键获取数据:H_INFORMATION.<br/>
     * descSql =  SELECT * FROM H_INFORMATION WHERE ID = #{id,jdbcType=VARCHAR}
     * @param id id
     * @return InformationDO
     */
    InformationDO getByPrimary(String id);
}
