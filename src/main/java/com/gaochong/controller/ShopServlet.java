package com.gaochong.controller;

import com.gaochong.dao.ProductDao;
import com.gaochong.model.Category;
import com.gaochong.model.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ShopServlet",value = "/shop")
public class ShopServlet extends HttpServlet {
    Connection con = null;
    @Override
    public void init() throws ServletException {
        con = (Connection) getServletContext().getAttribute("con");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Category category = new Category();
        try {
            List<Category> categoryList = category.findAllCategory(con);
            System.out.println(con);
            request.setAttribute("categoryList",categoryList);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        ProductDao productDao = new ProductDao();
        List<Product> productList = null;

        try {
            if (request.getParameter("categoryId")==null){
                productList = productDao.findAll(con);
            }else {
                int categoryID = Integer.parseInt(request.getParameter("categoryId"));
                productList = productDao.findByCategoryId(categoryID,con);
                request.setAttribute("productList",productList);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("productList",productList);
        String path = "/WEB-INF/views/shop.jsp";
        request.getRequestDispatcher(path).forward(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}
