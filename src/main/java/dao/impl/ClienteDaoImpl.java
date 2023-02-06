package dao.impl;

import configuration.HibernateConfiguration;
import dao.ClienteDao;
import entity.ClienteEntity;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class ClienteDaoImpl implements ClienteDao {
    @Override
    public ClienteEntity findClient(String dni, String password, Session session) {
        Query<ClienteEntity> query = session.createQuery("FROM ClienteEntity WHERE dni = :dni and password = :password", ClienteEntity.class);
        query.setReadOnly(true);
        query.setParameter("dni", dni);
        query.setParameter("password", password);
        return query.uniqueResult();
    }
}
