package service;

import configuration.HibernateConfiguration;
import dao.PedidoDao;
import dao.impl.PedidoDaoImpl;
import entity.PedidoEntity;
import entity.ProductoEntity;
import org.hibernate.Session;

import java.util.List;

public class PedidoService {
    PedidoDao pedidoDao = new PedidoDaoImpl();
    public List<PedidoEntity> guardaPedido(ProductoEntity productos) {
        int contador = 1;
        List<PedidoEntity> pedidoEntityList;
        try (Session session = HibernateConfiguration.getSessionFactory().openSession()) {
            session.beginTransaction();
            pedidoEntityList = pedidoDao.listProductos(session, productos);
        }
        return pedidoEntityList;
    }
}
