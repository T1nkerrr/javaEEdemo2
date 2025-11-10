package com.example.javaeedemo2.product;

import javax.servlet.annotation.WebServlet;
import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException; // 导入IOException类，用于处理输入输出异常

@WebServlet("/product/products")
public class ProductServlet extends HttpServlet{
    private static final long serialVersionUID = 1L;
    private  ProductDao productDao = new ProductDao();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        try {
            request.setAttribute("products", productDao.getAllProducts());
            request.getRequestDispatcher("/product/product.jsp").forward(request, response);
        }catch (Exception e){
            throw new ServletException(e);
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        try {
            String action = request.getParameter("action");
            if("add".equals(action)){
                Product product = new Product();
                product.setName(request.getParameter("name"));
                product.setPrice(Double.parseDouble(request.getParameter("price")));
                product.setStock(Integer.parseInt(request.getParameter("stock")));
                productDao.addProduct(product);
            } else if("update".equals(action)){
                Product product = new Product();
                product.setId(Integer.parseInt(request.getParameter("id")));
                product.setName(request.getParameter("name"));
                product.setPrice(Double.parseDouble(request.getParameter("price")));
                product.setStock(Integer.parseInt(request.getParameter("stock")));
                productDao.updateProduct(product);
            } else if("delete".equals(action)){
                Integer id = Integer.parseInt(request.getParameter("id"));
                productDao.deleteProduct(id);
            }
            response.sendRedirect("products");
            // 重定向到/product：添加/更新/删除操作完成后，重定向回列表页面防止用户刷新页面时重复执行相同的POST操作
        }catch (Exception e){
            throw new ServletException(e);
        }
    }
}
