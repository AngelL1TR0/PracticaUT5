package entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "pedido")
public class PedidoEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cliente")
    private ClienteEntity cliente;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "estado")
    private EstadoPedidoEntity estado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "direccion")
    private DireccionEntity direccion;

    @Column(name = "fecha")
    private Timestamp fecha;
}
