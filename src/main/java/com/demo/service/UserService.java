package com.demo.service;

import com.demo.entity.Page;
import com.demo.entity.PageData;
import com.demo.entity.User;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Description
 * @Author leslee
 * @Date 2020-12-11 下午3:22
 */
public interface UserService {


    /**
     * 注册用户
     */
    int register(User user);

    /**
     * 用户登录
     */
    int login(User user, HttpServletRequest request);

    /**
     * 查询所有用户
     */
    List<User> selectAll();

    /**
     * 条件查询用户并分页
     */
    PageData<User> selectByLimit(String search, Page page);

    /**
     * 删除用户
     */
    int deleteUser(Integer id);

    /**
     * 修改用户密码
     */
    int updatePwdById(String newPwd, Integer id);



}
