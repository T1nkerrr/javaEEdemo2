package com.example.javaeedemo2.product;
import com.example.javaeedemo2.DBUtil;

import java.sql.Connection; // 导入Connection接口，用于管理数据库连接
import java.sql.PreparedStatement; // 导入PreparedStatement接口，用于执行预编译的SQL语句
import java.sql.ResultSet; // 导入ResultSet接口，用于处理结果集
import java.util.ArrayList; // 导入ArrayList类，用于创建动态数组
import java.util.List; // 导入List接口，用于定义列表

public class ProductDao {
    // 查询
    public List<Product> getAllProducts() throws Exception{
        List<Product> products = new ArrayList<>();
        try (Connection connection = DBUtil.getConnection();//获取数据库连接
             PreparedStatement stmt = connection.prepareStatement("SELECT * FROM gzcrm_product");//创建预编译的SQL语句
             ResultSet rs = stmt.executeQuery()) {//执行SQL语句并返回结果集

            while (rs.next()){
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setPrice(rs.getDouble("price"));
                product.setStock(rs.getInt("stock"));
                products.add(product);
            }
        }
        return products;
    }
    // 添加
    public void addProduct(Product product) throws Exception{
        try (Connection connection = DBUtil.getConnection();
             PreparedStatement stmt = connection.prepareStatement("INSERT INTO gzcrm_product(name, price, stock) VALUES (?, ?, ?)")) {
            stmt.setString(1, product.getName());
            stmt.setDouble(2, product.getPrice());
            stmt.setInt(3, product.getStock());
            stmt.executeUpdate();
             }
    }
    // 修改
    public void updateProduct(Product product) throws Exception{
        try (Connection connection = DBUtil.getConnection();
             PreparedStatement stmt = connection.prepareStatement("UPDATE gzcrm_product SET name = ?, price = ?, stock = ? WHERE id = ?")) {
            stmt.setString(1, product.getName());
            stmt.setDouble(2, product.getPrice());
            stmt.setInt(3, product.getStock());
            stmt.setInt(4, product.getId());
            stmt.executeUpdate();
             }
    }
    // 删除
    public void deleteProduct(Integer id) throws Exception{
        try (Connection connection = DBUtil.getConnection();
             PreparedStatement stmt = connection.prepareStatement("DELETE FROM gzcrm_product WHERE id = ?")) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
