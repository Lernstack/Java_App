package com.leonardo.app.DAO;

import com.leonardo.app.Connection.DBConnection;
import com.leonardo.app.Interface.UserInterface;
import com.leonardo.app.Models.UserModel;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements UserInterface {

    private Connection con = null;
    private Statement stm = null;
    private ResultSet rs = null;

    @Override
    public boolean userStore(UserModel user) {

        boolean store = false;

        String sql = "INSERT INTO users (firstName, lastName, identification) VALUES('" + user.getFirstName().toUpperCase() + "','" +
                user.getLastName().toUpperCase() + "'," + user.getIdentification() + ");";
        try {
            con = DBConnection.connect();
            stm = con.createStatement();
            stm.execute(sql);
            store = true;
            stm.close();
            con.close();

        } catch (SQLException ex) {
            System.out.println("Error to store user in db");
            ex.printStackTrace();
        }

        return store;
    }

    @Override
    public List<UserModel> userShow() {

        String sql = "SELECT * FROM users ORDER BY id";

        List<UserModel> listUsers = new ArrayList<>();

        try {
            con = DBConnection.connect();
            stm = con.createStatement();
            rs = stm.executeQuery(sql);

            while (rs.next()) {
                UserModel user = new UserModel();
                user.setId(rs.getInt(1));
                user.setIdentification(rs.getLong(2));
                user.setFirstName(rs.getString(3));
                user.setLastName(rs.getString(4));

                listUsers.add(user);
            }
            stm.close();
            rs.close();
            con.close();

        } catch (SQLException ex) {
            System.out.println("Error to list users");
            ex.printStackTrace();
        }

        return listUsers;
    }

    @Override
    public boolean userUpdate(UserModel user) {

        boolean update = false;

        String sql = "UPDATE users SET identification='" + user.getIdentification() + "',firstName='" +
                user.getFirstName() + "',lastName='" + user.getLastName() + "' WHERE id=" + user.getId();

        try {
            con = DBConnection.connect();
            stm = con.createStatement();
            stm.execute(sql);
            update = true;
            stm.close();
            con.close();

        } catch (SQLException ex) {
            System.out.println("Update to user failed");
            ex.printStackTrace();
        }

        return update;
    }

    @Override
    public boolean userDestroy(UserModel user) {

        boolean destroy = false;
        String sql = "DELETE FROM users WHERE id=" + user.getId() + "";

        try {
            con = DBConnection.connect();
            stm = con.createStatement();
            stm.execute(sql);

            stm.close();
            con.close();

        } catch (SQLException ex) {
            System.out.println("Destroy to user dailed");
            ex.printStackTrace();
        }

        return destroy;
    }

}
