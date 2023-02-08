package service;

import configuration.HibernateConfiguration;
import dao.ProductoDao;
import dao.impl.ProductoDaoImpl;
import entity.ProductoEntity;
import org.hibernate.Session;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class ProductoService {

    ProductoDao productoDao = new ProductoDaoImpl();


    public List<ProductoEntity> listProducts() {
        int contador = 1;
        List<ProductoEntity> productos;
        try (Session session = HibernateConfiguration.getSessionFactory().openSession()) {
            session.beginTransaction();
            productos = productoDao.listProductos(session);
        }
        return productos;
    }

    public List<ProductoEntity> listTypeOfProduct() {
        int contador = 1;
        List<ProductoEntity> productos;
        try (Session session = HibernateConfiguration.getSessionFactory().openSession()) {
            session.beginTransaction();
            productos = productoDao.listTypeOfProductos(session);
        }
        return productos;
    }
}
