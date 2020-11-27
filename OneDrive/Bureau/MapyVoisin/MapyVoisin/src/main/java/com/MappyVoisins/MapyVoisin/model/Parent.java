package com.MappyVoisins.MapyVoisin.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Parent {

    private String nom;
    private String prenom;
    private int age;
}
