package dao.impl;

import dao.ProductoDao;
import entity.ProductoEntity;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Queue;

public class ProductoDaoImpl implements ProductoDao {
    @Override
    public List<ProductoEntity> listProductos(Session session) {
        String hql = "Distinct nombre , precio FROM ProductoEntity";
        Query<ProductoEntity> query = session.createNativeQuery(hql, ProductoEntity.class);
        query.setReadOnly(true);
        //query.setParameter("estado1", 1);
        //query.setParameter("estado2", 3);
        return query.list();
    }
}
