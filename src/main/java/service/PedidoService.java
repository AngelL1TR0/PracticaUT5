package service;

import configuration.HibernateConfiguration;
import dao.PedidoDao;
import dao.impl.PedidoDaoImpl;
import entity.ClienteEntity;
import entity.PedidoEntity;
import entity.ProductoEntity;
import org.hibernate.Session;

import java.util.List;

public class PedidoService {
    PedidoDao pedidoDao = new PedidoDaoImpl();
    public void guardaPedido(ClienteEntity cliente) {
        try (Session session = HibernateConfiguration.getSessionFactory().openSession()) {
            pedidoDao.listProductos(session, cliente);
        }
    }
}
