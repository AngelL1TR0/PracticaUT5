package service;

import configuration.HibernateConfiguration;
import dao.ProductoDao;
import dao.impl.ProductoDaoImpl;
import entity.ProductoEntity;
import org.hibernate.Session;

import java.util.List;

public class ProductoService {

    ProductoDao productoDao = new ProductoDaoImpl();


    public List<ProductoEntity> listProducts() {
        try (Session session = HibernateConfiguration.getSessionFactory().openSession()){
            session.beginTransaction();
            List<ProductoEntity> productos = productoDao.listProductos(session);
            for (ProductoEntity productoEntity: productos) {


            }

        }
    }
}
