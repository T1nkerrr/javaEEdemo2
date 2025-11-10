package com.example.javaeedemo2.manager;

import javax.servlet.annotation.WebServlet;
import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException; // 导入IOException类，用于处理输入输出异常
import java.sql.Date;

@WebServlet("/managers")
public class ManagerServlet extends HttpServlet{
    private static final long serialVersionUID = 1L;
    private  ManagerDao managerDao = new ManagerDao();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        // 设置请求和响应编码
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        try {
            request.setAttribute("managers", managerDao.getAllManagers());
            request.getRequestDispatcher("/index.jsp").forward(request, response);// 转发请求到index.jsp页面
        }catch (Exception e){
            throw new ServletException(e); // 抛出Servlet异常
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        // 设置请求和响应编码
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        try {
            String action = request.getParameter("action");
            if("add".equals(action)){
                Manager manager = new Manager();
                manager.setCmName(request.getParameter("cmName"));
                manager.setCmSex(request.getParameter("cmSex"));
                manager.setCmSsn(request.getParameter("cmSsn"));
                manager.setCmBirthday(Date.valueOf(request.getParameter("cmBirthday")));
                manager.setCmAge(Integer.parseInt(request.getParameter("cmAge")));
                manager.setCmNation(request.getParameter("cmNation"));
                manager.setCmPolitical(request.getParameter("cmPolitical"));
                manager.setCmHometown(request.getParameter("cmHometown"));
                managerDao.addManager(manager);
            } else if("update".equals(action)){
                Manager manager = new Manager();
                manager.setCmId(Integer.parseInt(request.getParameter("cmId")));
                manager.setCmName(request.getParameter("cmName"));
                manager.setCmSex(request.getParameter("cmSex"));
                manager.setCmSsn(request.getParameter("cmSsn"));
                manager.setCmBirthday(Date.valueOf(request.getParameter("cmBirthday")));
                manager.setCmAge(Integer.parseInt(request.getParameter("cmAge")));
                manager.setCmNation(request.getParameter("cmNation"));
                manager.setCmPolitical(request.getParameter("cmPolitical"));
                manager.setCmHometown(request.getParameter("cmHometown"));
                managerDao.updateManager(manager);
            } else if("delete".equals(action)){
                Integer cmId = Integer.parseInt(request.getParameter("cmId"));
                managerDao.deleteManager(cmId);
            }
            response.sendRedirect("managers");
            // 重定向到/manager：添加/更新/删除操作完成后，重定向回列表页面防止用户刷新页面时重复执行相同的POST操作
        }catch (Exception e){
            throw new ServletException(e);
        }
    }
}
