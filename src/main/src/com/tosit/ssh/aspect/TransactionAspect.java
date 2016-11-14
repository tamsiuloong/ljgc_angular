package com.tosit.ssh.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Pointcut;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 自定义事务管理器
 * 佛祖保佑       永无BUG
 * Created by DELL on 2016/11/3.
 */
//@Component
//@Aspect
public class TransactionAspect {
    @Autowired
    private SessionFactory sessionFactory ;

    @Pointcut("execution(* com.tosit.ssh.dao..*.*(..))")
    private void pointcut(){};

    @Around("pointcut()")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("开启事务");
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        joinPoint.proceed();
        session.getTransaction().commit();
        System.out.println("提交事务");
    }
}
