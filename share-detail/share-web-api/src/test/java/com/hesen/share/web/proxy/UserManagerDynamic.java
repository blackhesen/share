package com.hesen.share.web.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理类----需要java.lang.reflect.InvocationHandler接口和 java.lang.reflect.Proxy 类的支持
 * 优点：动态代理与静态代理相比较，最大的好处是接口中声明的所有方法都被转移到调用处理器一个集中的方法中处理（InvocationHandler.invoke）。
 *      这样，在接口方法数量比较多的时候，我们可以进行灵活处理，而不需要像静态代理那样每一个方法进行中转。而且动态代理的应用使我们的类职责更
 *      加单一，复用性更强
 * @author hesen
 */
public class UserManagerDynamic implements InvocationHandler{

    /**
     * 目标对象
     */
    private Object targetObject;

    public Object newProxyInstance(Object targetObject){
        this.targetObject=targetObject;
        //该方法用于为指定类装载器、一组接口及调用处理器生成动态代理类实例
        //第一个参数指定产生代理对象的类加载器，需要将其指定为和目标对象同一个类加载器
        //第二个参数要实现和目标对象一样的接口，所以只需要拿到目标对象的实现接口
        //第三个参数表明这些被拦截的方法在被拦截时需要执行哪个InvocationHandler的invoke方法
        //根据传入的目标返回一个代理对象
        return Proxy.newProxyInstance(targetObject.getClass().getClassLoader(),
                targetObject.getClass().getInterfaces(),this);
    }

    /**
     *
     * @param proxy   被代理的对象
     * @param method  要调用的方法
     * @param args    方法调用时需要的参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("start-->>");
        if (args != null && args.length > 0) {
            for (int i = 0; i < args.length; i++) {
                System.out.println(args[i]);
            }
        }
        Object ret=null;
        try{
            /*原对象方法调用前处理日志信息*/
            System.out.println("before-----调用方法之前");

            //调用目标方法
            ret=method.invoke(targetObject, args);
            /*原对象方法调用后处理日志信息*/
            System.out.println("after-----调用方法之后");
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("error-----调用异常");
            throw e;
        }
        return ret;
    }
}
