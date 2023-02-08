package dao;

import entity.PedidoEntity;
import entity.ProductoEntity;
import org.hibernate.Session;

import java.util.List;

public interface PedidoDao {
    List<PedidoEntity> listProductos(Session session, ProductoEntity productos);
}
