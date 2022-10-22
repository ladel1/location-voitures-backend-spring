package com.m2iformation.locationvoiture.controller;

import com.m2iformation.locationvoiture.model.Client;
import com.m2iformation.locationvoiture.model.Voiture;
import com.m2iformation.locationvoiture.repository.VoitureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class VoitureApiController {


    @Autowired
    private VoitureRepository voitureRepository;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(path="/api/voitures")
    public Iterable<Voiture> carList(){
        return voitureRepository.findAll();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(path="/api/voitures/{id}")
    public Voiture getCar(@PathVariable Long id ){
        return voitureRepository.findById(id).get();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping(path="/api/voitures/{id}")
    public @ResponseBody int deleteCar(@PathVariable Long id){
        Optional<Voiture> v = voitureRepository.findById(id);
        voitureRepository.delete(v.get());
        return 204;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(path="/api/voitures")
    public ResponseEntity<Voiture>  addCar(
            @RequestBody Voiture v
    ){
        v.setDisponible(true);
        Voiture createdCar = voitureRepository.save(v);
        System.out.println(createdCar);
        if(createdCar==null){
            return ResponseEntity.ok(createdCar);
        }else{
            return  ResponseEntity.ok(createdCar);
        }
    }


    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping(path="/api/voitures/{id}")
    public ResponseEntity<Voiture> updateCar(
            @PathVariable Long id,
            @RequestBody Voiture v
    ){
        v.setDisponible(true);
        v.setId(id);
        Voiture createdCar = voitureRepository.save(v);
        if(createdCar==null){
            return ResponseEntity.ok(createdCar);
        }else{
            return  ResponseEntity.ok(createdCar);
        }
    }

}
