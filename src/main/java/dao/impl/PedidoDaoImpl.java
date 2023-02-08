package dao.impl;

import dao.PedidoDao;
import entity.PedidoEntity;
import entity.ProductoEntity;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class PedidoDaoImpl implements PedidoDao {

    @Override
    public List<PedidoEntity> listProductos(Session session, ProductoEntity productos) {
        List<PedidoEntity> pedidoEntities = new ArrayList<>();
        //TODO investigar el comando hql inner join para introducir los datos en la tabla pedidos
        String hql = "";
        return pedidoEntities;
    }
}
