package com.MappyVoisins.MapyVoisin.controleur;

import com.MappyVoisins.MapyVoisin.Repository.AnnonceRepository;
import com.MappyVoisins.MapyVoisin.model.Annonce;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;
@Api( description="API pour les opérations CRUD sur les annonces.")
@RestController
@RequestMapping("api/annonce")
public class AnnonceController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AnnonceController.class);
    @Autowired
    AnnonceRepository annonceRepository;


    @GetMapping("/all")
    public ResponseEntity<List<Annonce>> getAnnonce(HttpServletRequest request) {
        return new ResponseEntity<>(annonceRepository.findAll(), HttpStatus.OK);

    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Annonce> getById(@PathVariable("id") String idAd) {
        return new ResponseEntity<>(annonceRepository.findById(idAd).get(), HttpStatus.OK);
    }

    @GetMapping("/idUser/{id}")
    public ResponseEntity<List<Annonce>> getByIdUser(@PathVariable("id") String idUser) {
        return new ResponseEntity<>(annonceRepository.findAnnonceByIdUser(idUser), HttpStatus.OK);
    }

    @GetMapping("/{ville}/{rue}")
    public ResponseEntity<List<Annonce>> getByIdAdresse(@PathVariable("ville") String ville, @PathVariable("rue") String rue) {
        return new ResponseEntity<>(annonceRepository.findAnnonceByVilleAndRue(ville, rue), HttpStatus.OK);
    }

    @PostMapping("/addAnnonce")
    public ResponseEntity<Annonce> addAnnonce(@RequestBody Annonce annonce) {
        try {
            annonceRepository.save(annonce);
            return new ResponseEntity<>(annonce, HttpStatus.CREATED);
        } catch (Exception e) {
            LOGGER.debug("la création de l'annonce est en échec");
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PutMapping("/updateAnnonce")
    public ResponseEntity<Annonce> updateAnnonce(@RequestBody Annonce annonce) {
        try {
            annonceRepository.save(annonce);
            return new ResponseEntity<>(annonce, HttpStatus.CREATED);
        } catch (Exception e) {
            LOGGER.debug("la création de l'annonce est en échec");
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @DeleteMapping("/deleteAnnonce/{idAnnonce}")
    public String deleteAnnonce(@PathVariable(value = "idAnnonce") String idAnnonce) {
        LOGGER.debug("Suppression Annonce par id : {}.", idAnnonce);
        try {
            Optional<Annonce> annonce = annonceRepository.findById(idAnnonce);
            annonceRepository.delete(annonce.get());
            LOGGER.debug("L'annonce  : ", annonce.get().getTitre_annonce() + " a été supprimée");
             return ("L'annonce   : "+ annonce.get().getTitre_annonce()  + "a été supprimée");
        } catch (Exception e) {
            return "Cette annonce n'existe pas pour etre supprimée";
        }

    }
}