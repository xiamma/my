package com.demo.dao;

import com.demo.entity.Pet;
import com.demo.entity.User;
import com.demo.utils.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Description
 * @Author leslee
 * @Date 2020-12-15 下午7:15
 */
public class PetDao {

    /**
     * 分页查询
     * @param offset
     * @param limit
     * @param sql
     * @return
     */

    public List<Pet> limitAll(Integer offset, Integer limit, String sql) {

        Connection connection = JdbcUtil.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Pet> list = new ArrayList<>();
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, offset);
            stmt.setInt(2, limit);
            rs = stmt.executeQuery();
            while (rs.next()) {

                Pet pet = new Pet(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("img"),
                        rs.getInt("isJY"),
                        rs.getString("character"),
                        rs.getString("createTime"),
                        rs.getInt("fid"),
                        rs.getInt("oid"),
                        rs.getInt("sid"),
                        rs.getString("feeder"),
                        rs.getString("organization"),
                        rs.getString("species")
                );
                list.add(pet);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JdbcUtil.close(connection, stmt, rs);
        }

        return list;
    }




    /**
     * 查询记录数
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



    public Pet queryById(Integer id) {

        String sql = "SELECT p.*, u1.username feeder, u2.username organization, s.`name` species from pet  p\n" +
                "LEFT JOIN \n" +
                "`user` u1\n" +
                "ON p.fid =  u1.id\n" +
                "LEFT JOIN\n" +
                "`user` u2\n" +
                "ON p.oid = u2.id\n" +
                "LEFT JOIN\n" +
                "species s\n" +
                "ON p.sid = s.id  where p.id = ?";


        Connection connection = JdbcUtil.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);

            rs = stmt.executeQuery();
            while (rs.next()) {

                Pet pet = new Pet(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("img"),
                        rs.getInt("isJY"),
                        rs.getString("character"),
                        rs.getString("createTime"),
                        rs.getInt("fid"),
                        rs.getInt("oid"),
                        rs.getInt("sid"),
                        rs.getString("feeder"),
                        rs.getString("organization"),
                        rs.getString("species"),
                        rs.getString("detail")
                );
               return pet;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JdbcUtil.close(connection, stmt, rs);
        }

        return null;
    }

    /**
     * 添加宠物
     * @param pet
     * @return
     */
    public int insert(Pet pet) {
        String sql = "INSERT INTO `pet`( `name`, `img`, `isJY`, `character`, `createTime`, `oid`, `sid`) VALUES (?, ?, ?, ?, ?, ?, ?);";
        Connection connection = JdbcUtil.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, pet.getName());
            stmt.setString(2, pet.getImg());
            stmt.setInt(3, pet.getIsJY());
            stmt.setString(4, pet.getCharacter());
            stmt.setTimestamp(5,new java.sql.Timestamp(new Date().getTime()));
            stmt.setInt(6, pet.getOid());
            stmt.setInt(7, pet.getSid());
            int i = stmt.executeUpdate();
            return i;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JdbcUtil.close(connection, stmt);
        }

        return 0;
    }


    /**
     * 根据id修改宠物信息
     */

    public int updateById(Pet pet) {
        String sql = "UPDATE `pet` SET `name` = ?, `img` = ?, `isJY` = ?, `character` = ?, `sid` = ? WHERE `id` = ?;";
        Connection connection = JdbcUtil.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, pet.getName());
            stmt.setString(2, pet.getImg());
            stmt.setInt(3, pet.getIsJY());
            stmt.setString(4, pet.getCharacter());
            stmt.setInt(5, pet.getSid());
            stmt.setInt(6, pet.getId());
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
     * 根据id修改宠物的饲主信息
     * @param fid
     * @param id
     * @return
     */
    public int updateById(Integer fid, Integer id) {
        String sql = "UPDATE `pet` SET `fid` = ? WHERE `id` = ?;";
        Connection connection = JdbcUtil.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, fid);
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
     * 根据id修改宠物的报道
     * @param detail
     * @param id
     * @return
     */
    public int updateById(String detail, Integer id) {
        String sql = "UPDATE `pet` SET `detail` = ? WHERE `id` = ?;";
        Connection connection = JdbcUtil.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, detail);
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
     * 根据id删除宠物
     * @param id
     * @return
     */
    public int deleteById(Integer id) {
        String sql = "delete from pet WHERE `id` = ?;";
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




}
