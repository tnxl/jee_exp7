package DAO;

import Hibernate.UserEnity;

public interface IUserDAO {
    public UserEnity vaildateUser(String username, String password);
    public boolean registerUser(String username,String password);
}
