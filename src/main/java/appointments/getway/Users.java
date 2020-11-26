/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appointments.getway;

/**
 *
 * @author Md Ashiqur Rahman
 */
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import appointments.models.UserModel;

class Users implements IQueryable<UserModel> {

    private static List<UserModel> userList;

    public Users() {
        userList = new ArrayList<>();
    }

    @Override
    public List<UserModel> get() {
        return this.userList;
    }
    @Override
    public UserModel get(int id) {
        for (UserModel user : this.userList) {
            if (user.id == id) {
                return user;
            }
        }
        return null;
    }
    @Override
    public UserModel save(UserModel user) {
        if (user.id > 0) {
            if (this.update(user)) {
                return user;
            } else {
                return null;
            }

        } else {
            if (this.insert(user)) {
                return user;
            } else {
                return null;
            }
        }
    }
    @Override
    public boolean delete(int id) {
        UserModel user = this.get(id);
        return this.userList.remove(user);
    }
    public List<UserModel> search(String searchText){
        return null;
    }
    
    @Override
    public int size() {
        return this.userList.size(); //To change body of generated methods, choose Tools | Templates.
    }
    private boolean insert(UserModel user) {
        user.id = this.getNewId();
        if (this.userList.add(user)) {
            return true;
        } else {
            return false;
        }
    }
    private boolean update(UserModel user) {
        UserModel existUser = this.get(user.id);
        int index = this.userList.indexOf(existUser);
        return this.userList.set(index, user) != null;
    }
    private int getNewId() {
        int id = 0;
        if (this.userList.size() > 0) {
            id = this.userList.get(this.userList.size() - 1).id;
            return id + 1;
        } else {
            return id + 1;
        }
    }

}
