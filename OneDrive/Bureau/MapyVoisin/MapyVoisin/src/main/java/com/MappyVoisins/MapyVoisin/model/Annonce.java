package com.MappyVoisins.MapyVoisin.model;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection ="annonce")
public class Annonce {

    private String id;
    private String titre_annonce;
    private Date date_ajout;
    private String rue;
    private String ville;
    private String idUser;
}
