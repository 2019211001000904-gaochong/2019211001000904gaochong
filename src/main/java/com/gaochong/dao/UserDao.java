package com.gaochong.dao;

import com.gaochong.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class UserDao implements IUserDao{

    @Override
    public boolean saveUser(Connection con, User user) throws SQLException {
        //insert .... into usertable - register -- dao yourself
        String sql = "insert into usertable values(?,?,?,?,?)";
        PreparedStatement st=con.prepareStatement(sql);

        st.setString(1, user.getUsername());
        st.setString(2, user.getPassword());
        st.setString(3, user.getEmail());
        st.setString(4, user.getGender());
        st.setDate(5, (java.sql.Date) user.getBirthdate());
        if(st.executeUpdate()>=1){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public int deleteUser(Connection con, User user) throws SQLException {
        //delete ....... from usertable where id=?
        String sql = "delete from DB_user where username = ?";
        PreparedStatement st=con.prepareStatement(sql);
        st.setString(1, user.getUsername());

        return st.executeUpdate();

    }

    @Override
    public int updateUser(Connection con, User user) throws SQLException {
        //update .......... from user table
        String sql = "update usertable set username=?, password=?, email=?, gender=?, birthDate=? where id=?";

        PreparedStatement st=con.prepareStatement(sql);

        st.setString(1, user.getUsername());
        st.setString(2, user.getPassword());
        st.setString(3, user.getEmail());
        st.setString(4, user.getGender());
        st.setString(5, String.valueOf(user.getBirthdate()));
        return st.executeUpdate();
    }

    @Override
    public User findById(Connection con, Integer id) throws SQLException {
        //select ........ from user table where id=?
        String sql = "select * from usertable where id = ?";
        PreparedStatement st=con.prepareStatement(sql);
        st.setInt(1,id);
        ResultSet rs= st.executeQuery();
        User user=null;
        if (rs.next()) {
            user=new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthdate(rs.getDate("birthdate"));
        }
        return user;
    }

    @Override
    public User findByUsernamePassword(Connection con, String username, String password) throws SQLException {
        //select ..... where username=? and password =?----- user for login --
        String sql ="select id,username,password,email,gender,birthdate from usertable where username=? and password=?";
        PreparedStatement st=con.prepareStatement(sql);
        st.setString(1,username);
        st.setString(2,password);
        ResultSet rs=st.executeQuery();
        User user=null;
        if(rs.next()){
            user =new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthdate(rs.getDate("birthdate"));
            //done
        }
        return user;
    }

    @Override
    public List<User> findByUsername(Connection con, String username) throws SQLException {
        //select ..... where username =?----- write jdbc code yourself --
        String sql = "select * from usertable where username= ?";
        PreparedStatement st=con.prepareStatement(sql);
        st.setString(1,username);
        ResultSet rs= st.executeQuery();
        User user=null;
        if (rs.next()) {
            user=new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthdate(rs.getDate("birthdate"));
        }
        return Collections.singletonList(user);
    }

    @Override
    public List<User> findByPassword(Connection con, String password) throws SQLException {
        //select ..... where password =?----- write jdbc code yourself --
        String sql = "select * from usertable where password= ?";
        PreparedStatement st=con.prepareStatement(sql);
        st.setString(1,password);
        ResultSet rs= st.executeQuery();
        User user=null;
        if (rs.next()) {
            user=new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthdate(rs.getDate("birthdate"));
        }
        return Collections.singletonList(user);
    }

    @Override
    public List<User> findByEmail(Connection con, String email) throws SQLException {
        //select ..... where email =?----- write jdbc code yourself --
        String sql = "select * from usertable where email= ?";
        PreparedStatement st=con.prepareStatement(sql);
        st.setString(1,email);
        ResultSet rs= st.executeQuery();
        User user=null;
        if (rs.next()) {
            user=new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthdate(rs.getDate("birthdate"));
        }
        return Collections.singletonList(user);
    }

    @Override
    public List<User> findByGender(Connection con, String gender) throws SQLException {
        //select ..... where gender =?----- write jdbc code yourself --
        String sql = "select * from usertable where gender= ?";
        PreparedStatement st=con.prepareStatement(sql);
        st.setString(1,gender);
        ResultSet rs= st.executeQuery();
        User user=null;
        if (rs.next()) {
            user=new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthdate(rs.getDate("birthdate"));
        }
        return Collections.singletonList(user);
    }

    @Override
    public List<User> findByBirthdate(Connection con, Date birthDate) throws SQLException {
        //select ..... where birthdate =?----- write jdbc code yourself --
        String sql = "select * from usertable where birthDate= ?";
        PreparedStatement st=con.prepareStatement(sql);
        st.setString(1, String.valueOf(birthDate));
        ResultSet rs= st.executeQuery();
        User user=null;
        if (rs.next()) {
            user=new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthdate(rs.getDate("birthdate"));
        }
        return Collections.singletonList(user);
    }

    @Override
    public List<User> findAllUser(Connection con) throws SQLException {
        //select * from usertable----- write jdbc code yourself --
        String sql = "select * from usertable ";
        PreparedStatement st=con.prepareStatement(sql);
        ResultSet rs= st.executeQuery();
        User user=null;
        if (rs.next()) {
            user=new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthdate(rs.getDate("birthdate"));
        }
        return Collections.singletonList(user);
    }
}
