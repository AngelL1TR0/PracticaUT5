package dao;

import entity.ProductoEntity;
import org.hibernate.Session;

import java.util.List;

public interface ProductoDao {
    List<ProductoEntity> listProductos(Session session);
}
