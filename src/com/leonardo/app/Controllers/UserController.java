package com.leonardo.app.Controllers;


import com.leonardo.app.DAO.UserDAO;
import com.leonardo.app.Models.UserModel;

import java.util.List;

public class UserController {

    public void storeUser(UserModel user) {
        UserDAO dao = new UserDAO();
        dao.userStore(user);
    }

    public void showUser() {

        List<UserModel> users;

        UserDAO dao = new UserDAO();
        users = dao.userShow();

        for (UserModel user : users) {
            System.out.println("Users \n" + "Id: " + user.getId() + "\n" + "FirstName: " +
                    user.getFirstName() + "\n" + "LastName: " + user.getLastName() + "\n" +
                    "Identification: " + user.getIdentification() + "\n");
        }

    }

    public void updateUser(UserModel user) {
        UserDAO dao = new UserDAO();
        dao.userUpdate(user);
    }

    public void destroyUser(UserModel user) {
        UserDAO dao = new UserDAO();
        dao.userDestroy(user);
    }

}
