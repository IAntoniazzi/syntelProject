/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.UserController;

/**
 *
 * @author syntel
 */
public class ManageUserView {

    UserController userController = new UserController();

    public void enableUser(String userEmail) {
        userController.updateModelEnableUser(userEmail);
    }

    public void disableUser(String userEmail) {
         userController.updateModelDisableUser(userEmail);
    }

    public void deleteUser(String userEmail) {
         userController.updateModelDeleteUser(userEmail);
    }

    public void changeUserPassword(String userEmail, String newPassword) {
          userController.updateModelChangePassword(userEmail, newPassword);
    }

}
