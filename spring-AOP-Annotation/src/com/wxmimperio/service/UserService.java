package com.wxmimperio.service;

import com.wxmimperio.dao.UserDAO;
import com.wxmimperio.dao.impl.UserDAOImpl;
import com.wxmimperio.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

/**
 * Created by wxmimperio on 2016/6/19.
 * 业务逻辑层
 */
public class UserService {
    //保存一个UserDAO的引用，用来操作数据
    //面向接口编程
    /*
    public UserService(UserDAO userDAO) {
        super();
        this.userDAO = userDAO;
    }*/

    /**
     * 面向接口编程的灵活性
     * 可以根据不同的Impl实现来采用不同的dao层实现方式
     */

    private UserDAO userDAO;

    public UserDAO getUserDAO() {
        return userDAO;
    }

    //Autowired自动找对应类型的bean
    //Qualifier指定注入的具体bean（多个相同bean的情况下）
    //@Autowired
    //Resource默认是ByName注入
    @Resource(name = "userDAO")
    public void setUserDAO(/*@Qualifier("userDAO1")*/ UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    //添加用户
    public void add (User user) {
        this.userDAO.save(user);
    }

    //注解初始化方法
    @PostConstruct
    public void init() {
        System.out.println("This is init");
    }
    //注解销毁方法
    @PreDestroy
    public void destroy() {
        System.out.println("This is destroy");
    }
}
