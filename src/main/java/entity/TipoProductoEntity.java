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
@Table(name = "tipo_producto")
public class TipoProductoEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;
    @Column(name="nombre")
    private String nombre;
    @Column(name="usu_cre")
    private String usuCre;
    @Column(name="fec_cre")
    private Timestamp fecCre;
    @Column(name="usu_mod")
    private String usuMod;
    @Column(name="fec_mod")
    private Timestamp fecMod;
}
