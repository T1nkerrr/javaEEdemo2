package com.example.javaeedemo2.manager;

import com.example.javaeedemo2.DBUtil;

import java.sql.Connection; // 导入Connection接口，用于管理数据库连接
import java.sql.PreparedStatement; // 导入PreparedStatement接口，用于执行预编译的SQL语句
import java.sql.ResultSet; // 导入ResultSet接口，用于处理结果集
import java.util.ArrayList; // 导入ArrayList类，用于创建动态数组
import java.util.List; // 导入List接口，用于定义列表

public class ManagerDao {
    // 查询
    public List<Manager> getAllManagers() throws Exception{
        List<Manager> managers = new ArrayList<>();
        try (Connection connection = DBUtil.getConnection();//获取数据库连接
             PreparedStatement stmt = connection.prepareStatement("SELECT * FROM gzcrm_cminfo");//创建预编译的SQL语句
             ResultSet rs = stmt.executeQuery()) {//执行SQL语句并返回结果集

            while (rs.next()){
                Manager manager = new Manager();
                manager.setCmId(rs.getInt("cm_id"));
                manager.setCmName(rs.getString("cm_name"));
                manager.setCmSex(rs.getString("cm_sex"));
                manager.setCmSsn(rs.getString("cm_ssn"));
                manager.setCmBirthday(rs.getDate("cm_birthday"));
                manager.setCmAge(rs.getInt("cm_age"));
                manager.setCmNation(rs.getString("cm_nation"));
                manager.setCmPolitical(rs.getString("cm_political"));
                manager.setCmHometown(rs.getString("cm_hometown"));
                managers.add(manager);
            }
        }
        return managers;
    }
    // 添加
    public void addManager(Manager manager) throws Exception{
        try (Connection connection = DBUtil.getConnection();
             PreparedStatement stmt = connection.prepareStatement("INSERT INTO gzcrm_cminfo(cm_name, cm_sex, cm_ssn, cm_birthday, cm_age, cm_nation, cm_political, cm_hometown) VALUES (?, ?, ?, ?, ?, ?, ?, ?)")) {
            stmt.setString(1, manager.getCmName());
            stmt.setString(2, manager.getCmSex());
            stmt.setString(3, manager.getCmSsn());
            stmt.setDate(4, manager.getCmBirthday());
            stmt.setInt(5, manager.getCmAge());
            stmt.setString(6, manager.getCmNation());
            stmt.setString(7, manager.getCmPolitical());
            stmt.setString(8, manager.getCmHometown());
            stmt.executeUpdate();
             }
    }
    // 修改
    public void updateManager(Manager manager) throws Exception{
        try (Connection connection = DBUtil.getConnection();
             PreparedStatement stmt = connection.prepareStatement("UPDATE gzcrm_cminfo SET cm_name = ?, cm_sex = ?, cm_ssn = ?, cm_birthday = ?, cm_age = ?, cm_nation = ?, cm_political = ?, cm_hometown = ? WHERE cm_id = ?")) {
            stmt.setString(1, manager.getCmName());
            stmt.setString(2, manager.getCmSex());
            stmt.setString(3, manager.getCmSsn());
            stmt.setDate(4, manager.getCmBirthday());
            stmt.setInt(5, manager.getCmAge());
            stmt.setString(6, manager.getCmNation());
            stmt.setString(7, manager.getCmPolitical());
            stmt.setString(8, manager.getCmHometown());
            stmt.setInt(9, manager.getCmId());
            stmt.executeUpdate();
             }
    }
    // 删除
    public void deleteManager(Integer cmId) throws Exception{
        try (Connection connection = DBUtil.getConnection();
             PreparedStatement stmt = connection.prepareStatement("DELETE FROM gzcrm_cminfo WHERE cm_id = ?")) {
            stmt.setInt(1, cmId);
            stmt.executeUpdate();
        }
    }
}
