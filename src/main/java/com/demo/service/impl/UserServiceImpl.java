package com.demo.service.impl;

import com.demo.common.UserConstants;
import com.demo.dao.UserDao;
import com.demo.entity.Page;
import com.demo.entity.PageData;
import com.demo.entity.User;
import com.demo.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Description
 * @Author leslee
 * @Date 2020-12-11 下午3:22
 */
public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDao();


    @Override
    public int register(User user) {
        // 判断用户名是否重复
        User selectOne = userDao.queryByUsername(user.getUsername());
        if(selectOne == null) {
            return userDao.insert(user);
        }
        return UserConstants.USER_RE;
    }

    @Override
    public int login(User user, HttpServletRequest request) {

        User selectOne = userDao.queryByUsername(user.getUsername());

        // 判断账号是否存在
        if(selectOne == null) {
            return UserConstants.USER_NAME_NO;
        }

        // 判断密码是否正确
        if(!user.getPassword().equals(selectOne.getPassword())) {
            return UserConstants.USER_PWD_ERR;
        }

        // 将User对象放入session中
        HttpSession session = request.getSession();
        session.setAttribute("user", selectOne);
        return UserConstants.USER_LOGIN_SUCCESS;
    }

    @Override
    public List<User> selectAll() {

        return userDao.queryAll();
    }

    @Override
    public PageData<User> selectByLimit(String search, Page page) {

        String whereSql = " where 1 = 1 ";

        // 动态拼接SQL
        if(search != null && !"".equals(search)) {

            whereSql += "and id like '%"+ search +"%' OR username like '%"+ search +"%'";
        }


        String limitSql = "select * from `user` "+ whereSql +" limit ?, ?";

        String countSql = "select count(*) from user" + whereSql ;   //查询满足条件的记录数


        // 分页查询
        List<User> users = userDao.limitAll(page.getOffset(), page.getLimit(), limitSql);

        // 查询记录数
        int counts = userDao.counts(countSql);



        return  new PageData<>(users, counts);
    }

    @Override
    public int deleteUser(Integer id) {

        return userDao.deleteById(id);
    }

    @Override
    public int updatePwdById(String newPwd, Integer id) {

        return userDao.updatePwdById(newPwd, id);
    }
}
