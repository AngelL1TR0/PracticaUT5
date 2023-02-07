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
        int contador = 1;
        List<ProductoEntity> productos;
        try (Session session = HibernateConfiguration.getSessionFactory().openSession()) {
            session.beginTransaction();
            productos = productoDao.listProductos(session);
            for (ProductoEntity productoEntity : productos) {
                System.out.println(contador + " " + productoEntity.getNombre() + " (" + productoEntity.getPrecio() + " €)");
                contador++;
            }

        }
        return productos;
    }
}
