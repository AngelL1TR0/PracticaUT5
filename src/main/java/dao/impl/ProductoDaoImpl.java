package dao.impl;

import dao.ProductoDao;
import entity.ProductoEntity;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ProductoDaoImpl implements ProductoDao {
    @Override
    public List<ProductoEntity> listProductos(Session session) {
        String hql = "select distinct nombre , precio from producto p";
        List<Object[]> query = session.createNativeQuery(hql).list();
        List<ProductoEntity> productoEntities = new ArrayList<>();
        for (Object[] productoEntity : query ) {
            ProductoEntity producto = new ProductoEntity();
            producto.setNombre((String) productoEntity[0]);
            producto.setPrecio((BigDecimal) productoEntity[1]);
            productoEntities.add(producto);
        }
        return productoEntities;
    }
}
