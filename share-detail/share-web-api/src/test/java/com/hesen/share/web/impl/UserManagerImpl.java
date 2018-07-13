package com.hesen.share.web.impl;

import com.hesen.share.web.manager.UserManager;

/**
 * @author hesen
 */
public class UserManagerImpl implements UserManager{

    @Override
    public void addUser() {
        System.out.println("UserManagerImpl-----添加用户");
    }

    @Override
    public void delUser() {
        System.out.println("UserManagerImpl-----删除用户");
    }
}
