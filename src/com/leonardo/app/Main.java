package com.leonardo.app;

import com.leonardo.app.Controllers.UserController;
import com.leonardo.app.Models.UserModel;

public class Main {
    public static void main(String[] args) {

        UserController user = new UserController();
        UserModel userM = new UserModel();
/*
        for (int i = 0; i < 1500; i++) {
            int min = 1;
            int max = 5000;
            int range = max - min + 1;

            int rand = (int) (Math.random() * range) + min;

            userM.setIdentification(rand);
            userM.setFirstName("Leo" + rand);
            userM.setLastName("Osp" + rand);

            user.storeUser(userM);
        }
*/


        user.showUser();
/*
        userM.setId(1);

        user.destroyUser(userM);
 */
    }
}
