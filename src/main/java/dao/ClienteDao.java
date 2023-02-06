package dao;

import entity.ClienteEntity;
import org.hibernate.Session;

public interface ClienteDao {

    public ClienteEntity findClient(String dni, String password, Session session);

}
