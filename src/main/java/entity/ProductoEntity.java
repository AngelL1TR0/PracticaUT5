package entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "producto")
public class ProductoEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column (name = "codigo_barra")
    private String codigo_barra;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "coleccion")
    private String coleccion;
    @Column(name = "tipo")
    private String tipo;
    @Column(name = "talla")
    private String talla;
    @Column(name = "color")
    private String color;
    @Column(name = "precio")
    private Integer precio;
    @Column(name = "descuento")
    private Integer descuento;
    @Column(name = "estado")
    private String estado;
    @Column(name = "usu_cre")
    private String usu_cre;
    @Column(name = "fec_cre")
    private Timestamp fec_cre;
    @Column(name = "usu_mod")
    private String usu_mod;
    @Column(name = "fec_mod")
    private Timestamp fec_mod;

}
