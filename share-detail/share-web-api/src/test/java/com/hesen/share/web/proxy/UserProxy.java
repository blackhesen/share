package com.hesen.share.web.proxy;

import com.hesen.share.web.manager.UserManager;

/**
 * 静态代理类-----代理用户管理类
 * 缺点：
 * 1.代理类和委托类实现了相同的接口，代理类通过委托类实现了相同的方法。这样就出现了大量的代码重复。如果接口增加一个方法，
 * 除了所有实现类需要实现这个方法外，所有代理类也需要实现此方法。增加了代码维护的复杂度。
 * 2.代理对象只服务于一种类型的对象，如果要服务多类型的对象。势必要为每一种对象都进行代理，静态代理在程序规模稍大时就无法胜任了。
 * 如上的代码是只为UserManager类的访问提供了代理，但是如果还要为其他类如Department类提供代理的话，就需要我们再次添加代理Department
 * 的代理类。
 * @author hesen
 */
public class UserProxy implements UserManager{

    private UserManager userManager;

    public UserProxy(UserManager userManager) {
        this.userManager = userManager;
    }

    @Override
    public void addUser() {
        System.out.println("静态代理");
        userManager.addUser();
    }

    @Override
    public void delUser() {
        System.out.println("静态代理");
        userManager.delUser();
    }
}
