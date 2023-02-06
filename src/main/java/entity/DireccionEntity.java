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
@Table(name = "direccion")
public class DireccionEntity implements Serializable {
    @Column(name="id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="calle")
    private String calle;
    @Column(name="ciudad")
    private String ciudad;
    @Column(name="cp")
    private String cp;
    @Column(name="pais")
    private String pais;
    @Column(name="usu_cre")
    private String usuCre;
    @Column(name="fec_cre")
    private Timestamp fecCre;
    @Column(name="usu_mod")
    private String usuMod;
    @Column(name="fec_mod")
    private Timestamp fecMod;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cliente")
    private ClienteEntity cliente;

    @OneToMany(mappedBy = "direccion")
    private List<PedidoEntity> pedidos;

    @Override
    public String toString() {
        return "DireccionEntity{" +
                "calle='" + calle + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", cp='" + cp + '\'' +
                ", pais='" + pais + '\'' +
                '}';
    }
}
