package com.hesen.share.common.utils.res;

import com.hesen.share.common.enums.ResEnum;
import com.hesen.share.common.res.JsonBaseResponse;
import com.hesen.share.common.res.JsonObjectResponse;
import org.apache.commons.lang3.StringUtils;

/**
 * @Author Hesen
 * @Date   2018/4/20 17:11
 */
public class ResUtils {
	
	/**
	 * 响应成功
	 * @return
	 */
	public static JsonBaseResponse success(){
		JsonBaseResponse response = new JsonBaseResponse();
		response.setCode(ResEnum.RES_CODE_SUCCESS.getCode());
		response.setErrmsg(ResEnum.RES_CODE_SUCCESS.getErrmsg());
		return response;
	}

	public static JsonBaseResponse success(String errmsg){
		JsonBaseResponse response = new JsonBaseResponse();
		response.setCode(ResEnum.RES_CODE_SUCCESS.getCode());
		if (StringUtils.isEmpty(errmsg)){
			response.setErrmsg(ResEnum.RES_CODE_SUCCESS.getErrmsg());
		}else {
			response.setErrmsg(errmsg);
		}
		return response;
	}
	
	public static JsonObjectResponse success(Object data){
		JsonObjectResponse response = new JsonObjectResponse();
		response.setCode(ResEnum.RES_CODE_SUCCESS.getCode());
		response.setErrmsg(ResEnum.RES_CODE_SUCCESS.getErrmsg());
		response.setData(data);
		return response;
	}
	
	/**
	 * 响应失败
	 * @return
	 */
	public static JsonBaseResponse fail(){
		JsonBaseResponse response = new JsonBaseResponse();
		response.setCode(ResEnum.RES_CODE_FAIL.getCode());
		response.setErrmsg(ResEnum.RES_CODE_FAIL.getErrmsg());
		return response;
	}

	public static JsonBaseResponse fail(String errmsg){
		JsonBaseResponse response = new JsonBaseResponse();
		response.setCode(ResEnum.RES_CODE_FAIL.getCode());
		if (StringUtils.isEmpty(errmsg)) {
			response.setErrmsg(ResEnum.RES_CODE_FAIL.getErrmsg());
		}else {
			response.setErrmsg(errmsg);
		}
		return response;
	}
	
	public static JsonObjectResponse fail(Object data){
		JsonObjectResponse response = new JsonObjectResponse();
		response.setCode(ResEnum.RES_CODE_FAIL.getCode());
		response.setErrmsg(ResEnum.RES_CODE_FAIL.getErrmsg());
		response.setData(data);
		return response;
	}
}
