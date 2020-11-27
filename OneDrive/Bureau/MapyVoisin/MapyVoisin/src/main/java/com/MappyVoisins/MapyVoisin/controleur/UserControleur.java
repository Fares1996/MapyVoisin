package com.MappyVoisins.MapyVoisin.controleur;
import com.MappyVoisins.MapyVoisin.Repository.UserRepository;
import com.MappyVoisins.MapyVoisin.model.User;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Api( description="API pour les opérations CRUD sur les utilisateurs.")
@RestController
@RequestMapping("api/user")
public class UserControleur {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserControleur.class);
     @Autowired
     UserRepository userRepository;

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAll(HttpServletRequest request) {
        return new ResponseEntity<>(userRepository.findAll(), HttpStatus.OK);
    }
    @GetMapping("/id/{id}")
    public ResponseEntity<User> getByid(@PathVariable("id") String idUser) {
        return new ResponseEntity<>(userRepository.findById(idUser).get(), HttpStatus.OK);
    }

    @PostMapping("/addUser")
    public ResponseEntity<User> addUser(@RequestBody User user){
        try{
    userRepository.save(user);
            return new ResponseEntity<>(user, HttpStatus.CREATED);
    }catch (Exception e){
            LOGGER.debug("la création de l'utilisateur est en échec");
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PutMapping("/updateUser")
    public ResponseEntity<User> updateUser(@RequestBody User user){
        try{
            userRepository.save(user);
            return new ResponseEntity<>(user, HttpStatus.CREATED);
        }catch (Exception e){
            LOGGER.debug("la modification de l'utilisateur est en échec");
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable(value = "id") String idUser) {
        LOGGER.debug("Suppression de l'utilisateur ");
        try {
            User user = userRepository.findById(idUser).get();
            userRepository.delete(user);
            LOGGER.debug("L'utilisateur  : {}.", user.getNom()+ " " + user.getPrenom() + " a été supprimé");
            return ("L'utilisateur  : " + user.getNom() +" "+ user.getPrenom() + " a été supprimé");
        }catch (Exception e){
            return "L'utilisateur n'existe pas pour ètre supprimé";
        }
    }
}
