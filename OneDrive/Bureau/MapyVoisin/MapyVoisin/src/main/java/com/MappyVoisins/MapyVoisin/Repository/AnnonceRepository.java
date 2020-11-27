package com.MappyVoisins.MapyVoisin.Repository;

import com.MappyVoisins.MapyVoisin.model.Annonce;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface AnnonceRepository extends MongoRepository<Annonce, String> {
    List<Annonce> findAll();

    List<Annonce> findAnnonceByIdUser(String idUser);

    List<Annonce> findAnnonceByVilleAndRue(String ville, String rue);

}
