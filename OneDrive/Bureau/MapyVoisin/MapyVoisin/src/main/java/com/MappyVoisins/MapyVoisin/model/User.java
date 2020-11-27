package com.MappyVoisins.MapyVoisin.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection ="user")
public class User {
    private String id;
    private String nom;
    private String prenom;
    private int age;
    private String mail;
    private Parent parent;

}
