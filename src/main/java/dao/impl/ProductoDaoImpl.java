package dao.impl;

import dao.ProductoDao;
import entity.ProductoEntity;
import org.hibernate.Session;

import java.util.List;

public class ProductoDaoImpl implements ProductoDao {
    @Override
    public List<ProductoEntity> listProductos(Session session) {
        String hql = "FROM ProductoEntity producto WHERE estado = :estado";
        return null;
    }
}
