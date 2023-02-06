package entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "estado_pedido")
public class EstadoPedidoEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "usu_cre")
    private String usuarioCre;
    @Column(name = "fec_cre")
    private Timestamp fechaCre;
    @Column(name = "usu_mod")
    private String usuarioMod;
    @Column(name = "fec_mod")
    private Timestamp fechaMod;
    @OneToMany(mappedBy = "estado")
    private List<PedidoEntity> pedidos;
}
