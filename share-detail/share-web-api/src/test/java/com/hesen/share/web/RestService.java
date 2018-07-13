package com.hesen.share.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 * 发送http请求
 *
 * @author Hesen
 */
public class RestService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RestService.class);

    /**
     * 尝试请求次数
     */
    public static final int RETRY_COUNT = 5;

    /**
     * http请求
     *
     * @param body        请求参数
     * @param url         请求地址
     * @param httpMethod  请求方法类型
     * @param returnType  返回参数类型
     * @param <K>
     * @param <V>
     * @return
     */
    public static <K, V> V request(K body, String url, HttpMethod httpMethod, Class<V> returnType) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        headers.add("ticket", "bfi_322czf");
        HttpEntity<K> httpEntity = new HttpEntity<>(body, headers);
        int retryCount = 1;
        while (true) {
            try {
                ResponseEntity<V> result = restTemplate.exchange(url, httpMethod, httpEntity, returnType);
                if (result != null && result.getBody() != null && 200 == result.getStatusCodeValue()) {
                    return result.getBody();
                }
                return null;
            } catch (Exception e) {
                LOGGER.error("请求失败", e);
                if (retryCount == RETRY_COUNT) {
                    return null;
                }
                retryCount++;
            }

        }
    }
}
