package impl.DAO;

import DAO.BaseDAO;
import DAO.IUserDAO;
import Hibernate.UserEnity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class UserDAO extends BaseDAO implements IUserDAO {

    @Override
    public UserEnity vaildateUser(String username, String password) {
        String hql = "from UserEnity u where u.username = :name and u.password = :pass";
        Session session = getSession();
        Query query = session.createQuery(hql);
        query.setParameter("name",username);
        query.setParameter("pass",password);
        List list = query.list();
        if (list.size()!=0){
            UserEnity user = (UserEnity)list.get(0);
            return user;
        }
        session.close();
        return null;
    }

    public boolean registerUser(String username,String password){
        String hql = "from UserEnity u where u.username = :name";
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery(hql);
        query.setParameter("name",username);
        List list = query.list();
        if (list.size()==0){
            UserEnity user = new UserEnity();
            user.setUsername(username);
            user.setPassword(password);
            session.save(user);
            transaction.commit();
            session.close();
            return true;
        }
        return false;
    }

}
