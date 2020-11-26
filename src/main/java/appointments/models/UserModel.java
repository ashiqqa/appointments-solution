/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appointments.models;

/**
 *
 * @author Md Ashiqur Rahman
 */
public class UserModel {
    public int id;
    public String userName;
    public String password;
    
    public UserModel(){}
    public UserModel(String userName, String password){
        this.userName = userName;
        this.password = password;
    }
}
