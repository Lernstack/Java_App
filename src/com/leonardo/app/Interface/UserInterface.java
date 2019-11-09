package com.leonardo.app.Interface;

import com.leonardo.app.Models.UserModel;

import java.util.List;

public interface UserInterface {

    public boolean userStore(UserModel user);

    public List<UserModel> userShow();

    public boolean userUpdate(UserModel user);

    public boolean userDestroy(UserModel user);
}
