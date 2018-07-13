package com.hesen.share.web.test;

import com.hesen.share.web.impl.OtherUserImpl;
import com.hesen.share.web.impl.UserManagerImpl;
import com.hesen.share.web.manager.UserManager;
import com.hesen.share.web.proxy.UserManagerDynamic;
import com.hesen.share.web.proxy.UserProxy;
import org.junit.Test;

import java.lang.reflect.Proxy;

/**
 * @author hesen
 */
public class ProxyTest {

    /**
     * 静态代理测试
     */
    @Test
    public void staticProxyTest() {
        UserProxy proxy = new UserProxy(new UserManagerImpl());
        proxy.addUser();
        UserProxy proxy2 = new UserProxy(new OtherUserImpl());
        proxy2.addUser();
    }

    /**
     * 动态代理测试
     */
    @Test
    public void dynamicProxyTest() {
        UserManagerDynamic userManagerDynamic = new UserManagerDynamic();
        UserManager userManager = (UserManager)userManagerDynamic.newProxyInstance(new UserManagerImpl());
        userManager.addUser();
    }
}
