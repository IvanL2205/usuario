package co.samtel.usuario.entity;

import io.quarkus.runtime.annotations.RegisterForReflection;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Data
@Entity
@RegisterForReflection
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tbl_user")
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idtbl_user")
    public Long id;
    @Column(name = "tbl_name")
    public String name;
    @Column(name = "tbl_lastname")
    public String lastname;
    @Column(name = "tbl_createat")
    public LocalDate createat;

}
