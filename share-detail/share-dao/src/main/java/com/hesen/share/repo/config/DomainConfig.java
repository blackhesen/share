/**
 * jcgroup.com.cn Inc.
 * Copyright (c) 2008-2017 All Rights Reserved.
 */
package com.hesen.share.repo.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;


@Configuration()
@MapperScan("com.hesen.share.repo.mapper")
public class DomainConfig {

}
