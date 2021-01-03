package com.demo.dao;

import com.demo.entity.User;
import com.demo.utils.JdbcUtil;


import javax.sound.midi.Soundbank;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * @Description
 * @Author leslee
 * @Date 2020-12-10 下午9:24
 */
public class UserDao {


    /**
     * 修改密码
     * @param newPwd
     * @param id
     * @return 影响行数
     */
    public int updatePwdById(String newPwd, Integer id) {

        String sql = "update `user` SET `password` = ? WHERE id  = ?";
        Connection connection = JdbcUtil.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, newPwd);
            stmt.setInt(2, id);
            int i = stmt.executeUpdate();
            return i;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JdbcUtil.close(connection, stmt);
        }

        return 0;

    }


    /**
     * 删除
     * @param id
     * @return 影响行数
     */
    public int deleteById(Integer id) {
        String sql = "delete  from `user` WHERE id = ?";
        Connection connection = JdbcUtil.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            int i = stmt.executeUpdate();
            return i;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JdbcUtil.close(connection, stmt);
        }
        return 0;
    }


    public User queryByUsername(String username) {
        String sql = "SELECT * from `user` WHERE username = ?";
        Connection connection = JdbcUtil.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, username);
            rs = stmt.executeQuery();
            while (rs.next()) {
                User user = new User(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("createTime"),
                        rs.getInt("role")
                );

                return user;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JdbcUtil.close(connection, stmt, rs);
        }

        return null;
    }



    public int insert(User user) {
        String sql = "INSERT INTO `user`( `username`, `password`, `createTime`, `role`) VALUES (?, ?, ?, ?)";
        Connection connection = JdbcUtil.getConnection();
        PreparedStatement stmt = null;
        int isSuccess = 0;
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());
            stmt.setTimestamp(3,new java.sql.Timestamp( new Date().getTime()));
            stmt.setInt(4, user.getRole());
            isSuccess = stmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JdbcUtil.close(connection, stmt);
        }

        return isSuccess;
    }


    public List<User> queryAll() {
        String sql = "select * from `user`";
        Connection connection = JdbcUtil.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<User> list = new ArrayList<>();

        try {
            stmt = connection.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {

                User user = new User(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("createTime"),
                        rs.getInt("role")
                );
                list.add(user);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JdbcUtil.close(connection, stmt, rs);
        }

        return list;
    }



    public List<User> limitAll(Integer offset, Integer limit, String sql) {

        Connection connection = JdbcUtil.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<User> list = new ArrayList<>();
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, offset);
            stmt.setInt(2, limit);
            rs = stmt.executeQuery();
            while (rs.next()) {
                User user = new User(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("createTime"),
                        rs.getInt("role")
                );
                list.add(user);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JdbcUtil.close(connection, stmt, rs);
        }

        return list;
    }


    /**
     * 查询总数
     * @param sql
     * @return
     */
    public int counts(String sql) {
        Connection connection = JdbcUtil.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = connection.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) return rs.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtil.close(connection, stmt, rs);
        }
        return 0;
    }

    public static void main(String[] args) {
        UserDao userDao = new UserDao();
        System.out.println(userDao.deleteById(37));


    }

}
