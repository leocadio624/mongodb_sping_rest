package com.example.mongo_db.documents;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "Usuarios")
@ToString
public class Usuario {

    public Usuario(){}


    public Usuario(String nombre, String email) {
        this.nombre = nombre;
        this.email = email;

    }

    public Usuario(String nombre, String email, Date created_date) {
        this.nombre = nombre;
        this.email = email;
        this.created_date = created_date;

    }
    public Usuario(String id, String nombre, String email, Date created_date) {

        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.created_date = created_date;

    }


    @Id
    @Setter @Getter
    private String id;



    @Setter @Getter
    private String nombre;

    @Setter @Getter
    private String email;

    @Setter @Getter
    private Date created_date;


}
