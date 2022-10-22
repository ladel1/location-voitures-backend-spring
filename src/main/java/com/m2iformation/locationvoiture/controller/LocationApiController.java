package com.m2iformation.locationvoiture.controller;


import com.m2iformation.locationvoiture.model.*;
import com.m2iformation.locationvoiture.repository.ClientRepository;
import com.m2iformation.locationvoiture.repository.LocationRepository;
import com.m2iformation.locationvoiture.repository.VoitureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class LocationApiController {


    @Autowired
    private LocationRepository locationRepository;
    @Autowired
    private VoitureRepository voitureRepository;
    @Autowired
    private ClientRepository clientRepository;

    @GetMapping(path="/api/locations")
    public Iterable<Location> lcoationList(){
        return locationRepository.findAll();
    }

    @DeleteMapping(path="/api/locations/{clientId}/{carId}")
    public @ResponseBody int deleteLocation(@PathVariable Long clientId,@PathVariable Long carId){
        Location v = locationRepository.findLocationByIds(clientId,carId);
        locationRepository.delete(v);
        return 204;
    }

    @GetMapping(path="/api/locations/{clientId}/{carId}")
    public Location detailLocation(@PathVariable Long clientId,@PathVariable Long carId){
        System.out.println("coucou");
        Location v = locationRepository.findLocationByIds(clientId,carId);
        return v;
    }

    @PostMapping(path="/api/locations")
    public ResponseEntity<Location> addLocation(
            @RequestBody Loc x
    ){
        Locationkey lk = new Locationkey();
        Location location = new Location();
        Optional<Voiture> v = voitureRepository.findById(Long.parseLong(x.getVoiture()));
        Optional<Client> c = clientRepository.findById(Long.parseLong(x.getClient()));
        lk.setClientId(Long.parseLong(x.getVoiture()));
        lk.setVoitureId(Long.parseLong(x.getClient()));
        location.setClient(c.get());
        location.setVoiture(v.get());
        location.setDuree(x.getDuree());
        location.setPrix(x.getPrix());
        location.setId(lk);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime dateTime = LocalDateTime.parse(x.getDate()+" 00:00", formatter);
        location.setDate(dateTime);
        Location createdLocation = locationRepository.save(location);
        return ResponseEntity.ok(createdLocation);
    }






}
