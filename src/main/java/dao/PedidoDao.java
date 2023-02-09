package dao;

import entity.ClienteEntity;
import entity.PedidoEntity;
import entity.ProductoEntity;
import org.hibernate.Session;

import java.util.List;

public interface PedidoDao {
   void listProductos(Session session, ClienteEntity cliente);
}
