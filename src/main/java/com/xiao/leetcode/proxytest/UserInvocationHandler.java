package com.xiao.leetcode.proxytest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Auther: xxb
 * @Date: 2020/6/29 22:12
 * @Description: 实现InvocationHandler
 */
public class UserInvocationHandler implements InvocationHandler {
    public UserInvocationHandler(Object target) {
        this.target = target;
    }
    private final Object target;


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before invocation");
        // 调用target对象的方法，得到执行结果
        Object result = method.invoke(target, args);
        System.out.println("after invocation");
        return result;
    }

    public static void main(String[] args) {
        // 创建UserService实现类
        UserServiceImpl userService = new UserServiceImpl();
        // 获取classloader
        ClassLoader classLoader = userService.getClass().getClassLoader();
        // 获取service声明的所有接口
        Class<?>[] interfaces = userService.getClass().getInterfaces();
        // 定义handler
        UserInvocationHandler handler = new UserInvocationHandler(userService);
        UserService service = (UserService) Proxy.newProxyInstance(classLoader, interfaces, handler);

        service.func1();
    }
}
