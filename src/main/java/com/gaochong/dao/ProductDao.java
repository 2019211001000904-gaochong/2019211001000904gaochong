package com.gaochong.dao;

import com.gaochong.model.Product;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDao implements  IProductDao{
    @Override
    public int save(Product product, Connection con) throws SQLException {
        int n = 0;
        String sql = "insert into product(ProductName,ProductDescription,Picture,Price,CategoryId) values(?,?,?,?,?)";
        PreparedStatement pt = con.prepareStatement(sql);
        pt.setString(1, product.getProductName());
        pt.setString(2, product.getProductDescription());
        if(product.getPicture()!=null) {
            //for sql server
            pt.setBinaryStream(3, product.getPicture());
            //for mysql
            //   pt.setBlob(3, product.getPicture());
        }
        pt.setDouble(4, product.getPrice());
        pt.setInt(5, product.getCategoryId());
        n = pt.executeUpdate();
        if (n > 0) {
            return n;
        }
        return 0;
    }//end save

    @Override
    public int delete(Integer productId, Connection con) {
        return 0;
    }

    @Override
    public int update(Product instance, Connection con) {
        return 0;
    }

    @Override
    public Product findById(Integer productId, Connection con) throws SQLException {
        String sql = "SELECT * from product where ProductId=?";
        PreparedStatement stat = con.prepareStatement(sql);
        stat.setInt(1,productId);
        ResultSet rs = stat.executeQuery();
        Product product = null ;
        if (rs.next()){
            product = new Product();
            product.setProductId(rs.getInt("ProductId"));
            product.setProductName(rs.getString("ProductName"));
            product.setProductDescription(rs.getString("ProductDescription"));
//            product.setPicture(rs.getString("Picture"));
            product.setPrice(rs.getDouble("Price"));
            product.setCategoryId(rs.getInt("CategoryId"));
        }
        return product;
    }

    @Override
    public List<Product> findByCategoryId(int categoryId, Connection con) throws SQLException {
        List<Product> products = new ArrayList<Product>();
        String sql = "SELECT * from product where categoryId=?";
        PreparedStatement stat = con.prepareStatement(sql);
        stat.setInt(1,categoryId);
        ResultSet rs = stat.executeQuery();
        while(rs.next()){
            Product product = new Product();
            product.setProductId(rs.getInt("ProductId"));
            product.setProductName(rs.getString("ProductName"));
            product.setProductDescription(rs.getString("ProductDescription"));
//            product.setPicture(rs.getString("Picture"));
            product.setPrice(rs.getDouble("Price"));
            product.setCategoryId(rs.getInt("CategoryId"));
            products.add(product);
        }
        System.out.println("successful");
        return products;
    }

    @Override
    public List<Product> findByPrice(double minPrice, double maxPrice, Connection con) throws SQLException {
        return null;
    }

    @Override
    public List<Product> findAll(Connection con) throws SQLException {
        List<Product> products = new ArrayList<Product>();
        String sql = "SELECT * from product";
        PreparedStatement stat = con.prepareStatement(sql);
        ResultSet rs = stat.executeQuery();
        while(rs.next()){
           Product product = new Product();
            product.setProductId(rs.getInt("ProductId"));
            product.setProductName(rs.getString("ProductName"));
            product.setProductDescription(rs.getString("ProductDescription"));
//            product.setPicture(rs.getString("Picture"));
            product.setPrice(rs.getDouble("Price"));
            product.setCategoryId(rs.getInt("CategoryId"));
            products.add(product);
        }
        System.out.println("successful");
        return products;
        }

    @Override
    public List<Product> findByProductName(String productName, Connection con) throws SQLException {
        return null;
    }

    @Override
    public List<Product> getPicture(Integer productId, Connection con) throws SQLException {
        return null;
    }

    public byte[] getPictureById (Integer productId, Connection con) throws SQLException {
        byte[] imgBytes = null;
        String sql = "select Picture from Product where ProductId = ?";
        PreparedStatement pt  = con.prepareStatement(sql);
        pt.setInt(1,productId);
        ResultSet rs = pt.executeQuery();
        while (rs.next()){
            Blob blob = rs.getBlob("Picture");
            imgBytes =blob.getBytes(1, (int) blob.length());
        }
        return imgBytes;
    }
}
