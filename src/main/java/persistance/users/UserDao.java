package persistance.users;

import models.acounts.User;

public interface UserDao {
    User addUser(User user);

    User loadUser(User user);
}
