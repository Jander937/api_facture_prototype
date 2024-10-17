package com.example.api_facture.pojo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@SuppressWarnings("ALL")
@NamedQuery(name = "User.findByEmail", query = "select u from UserEntity u where u.email=:email")
@Getter
@Setter
@Entity
@DynamicUpdate
@DynamicInsert
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "numero_contacto")
    private String numeroContacto;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "status")
    private String status;

    @Column(name = "role")//tipos de usuarios
    private String role;
}
