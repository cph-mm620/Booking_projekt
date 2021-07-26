package business.services;

import business.entities.User;
import business.persistence.Database;
import business.persistence.UserMapper;
import business.exceptions.UserException;

public class UserFacade
{
    UserMapper userMapper;

    public UserFacade(Database database)
    {
        userMapper = new UserMapper(database);
    }

    public User login(String email, String password) throws UserException
    {
        return userMapper.login(email, password);
    }

    public User createUser(String email, String password) throws UserException
    {
        User user = new User(email, password, "student");
        userMapper.createUser(user);
        return user;
    }

    public void subtractsPoints(int points, int users_Id)throws UserException
    {
        userMapper.subtractsPoints(points, users_Id);
    }
}
