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

    public List<ProductoEntity> listTypeOfProduct(String nombre) {
        int contador = 2;
        List<ProductoEntity> productos;
        try (Session session = HibernateConfiguration.getSessionFactory().openSession()) {
            session.beginTransaction();
            productos = productoDao.listTypeOfProductos(session, nombre);
            System.out.println(
                    nombre +
                            "\n 1- Volver");
            for (ProductoEntity productEntity : productos){
                System.out.println(" " + contador + "- Talla " + productEntity.getTalla() + " " + productEntity.getColor());
                contador++;
            }
        }
        return productos;
    }
}
