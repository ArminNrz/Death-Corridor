package main.directors;

import models.acounts.User;
import persistance.users.UserDao;
import persistance.users.UserMongo;

public class UserDirector {
    private User user;
    private UserDao userDao;

    public UserDirector(User user){
        this.user = user;
    }

    public void saveGame(){
        userDao = new UserMongo();
        userDao.addUser(this.user);
    }
}
