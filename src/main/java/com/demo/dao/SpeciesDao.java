package com.demo.dao;

import com.demo.entity.Species;
import com.demo.entity.User;
import com.demo.utils.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author leslee
 * @Date 2020-12-16 下午6:27
 */
public class SpeciesDao {



    public List<Species> findAll() {
        String sql = "SELECT * FROM species";
        Connection connection = JdbcUtil.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Species> list = new ArrayList<>();

        try {
            stmt = connection.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Species species = new Species(
                        rs.getInt("id"),
                        rs.getString("name")
                );
                list.add(species);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JdbcUtil.close(connection, stmt, rs);
        }
        return list;
    }


    public int insert(Species species) {
        String sql = "INSERT INTO `species`(`name`) VALUES (?);";
        Connection connection = JdbcUtil.getConnection();
        PreparedStatement stmt = null;
        int isSuccess = 0;
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, species.getName());
            isSuccess = stmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JdbcUtil.close(connection, stmt);
        }

        return isSuccess;
    }

    public int update(Species species) {
        String sql = "UPDATE species SET `name` = ? WHERE id = ?";
        Connection connection = JdbcUtil.getConnection();
        PreparedStatement stmt = null;
        int isSuccess = 0;
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, species.getName());
            stmt.setInt(2, species.getId());
            isSuccess = stmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JdbcUtil.close(connection, stmt);
        }
        return isSuccess;
    }

    public int delete(Integer id) {
        String sql = "DELETE FROM species WHERE id = ?";
        Connection connection = JdbcUtil.getConnection();
        PreparedStatement stmt = null;
        int isSuccess = 0;
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            isSuccess = stmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JdbcUtil.close(connection, stmt);
        }
        return isSuccess;
    }
}
