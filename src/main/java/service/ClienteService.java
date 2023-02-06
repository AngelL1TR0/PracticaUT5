package service;

import configuration.HibernateConfiguration;
import dao.ClienteDao;
import dao.impl.ClienteDaoImpl;
import entity.ClienteEntity;
import org.hibernate.Session;

public class ClienteService {
    ClienteDao clienteDao = new ClienteDaoImpl();

    public ClienteEntity findClientByDni(String dni, String pass) {
        try (Session session = HibernateConfiguration.getSessionFactory().openSession()) {
            session.beginTransaction();
            ClienteEntity cliente = clienteDao.findClient(dni, pass, session);
            return cliente;
        }
    }
}
