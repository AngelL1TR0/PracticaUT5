package dao.impl;

import dao.PedidoDao;
import entity.ClienteEntity;
import entity.PedidoEntity;
import entity.ProductoEntity;
import org.hibernate.Session;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class PedidoDaoImpl implements PedidoDao {

    @Override
    public void listProductos(Session session, ClienteEntity cliente) {
        PedidoEntity pedido = new PedidoEntity();
        pedido.setCliente(cliente.getId());
        pedido.setEstado(1);
        pedido.setFecha(new Timestamp(System.currentTimeMillis()));
        pedido.setDireccion(1);
        session.persist(pedido);
        session.beginTransaction().commit();
    }
}
