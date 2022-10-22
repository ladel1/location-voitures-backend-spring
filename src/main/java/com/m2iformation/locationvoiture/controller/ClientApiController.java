package com.m2iformation.locationvoiture.controller;

import com.m2iformation.locationvoiture.model.Client;
import com.m2iformation.locationvoiture.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ClientApiController {

    @Autowired
    private ClientRepository clientRepository;

    @GetMapping(path="/api/clients")
    public Iterable<Client> clientList(){
        return clientRepository.findAll();
    }

    @GetMapping(path="/api/clients/{id}")
    public Client getClient( @PathVariable Long id ){
        return clientRepository.findById(id).get();
    }

    @DeleteMapping(path="/api/clients/{id}")
    public @ResponseBody int deleteClient(@PathVariable Long id){
        Optional<Client> v = clientRepository.findById(id);
        clientRepository.delete(v.get());
        return 204;
    }

    @PostMapping(path="/api/clients")
    public ResponseEntity<Client> addClient(
            @RequestBody Client x
    ){
        Client createdCar = clientRepository.save(x);
        System.out.println(createdCar);
        if(createdCar==null){
            return ResponseEntity.ok(createdCar);// not found ===
        }else{
            return  ResponseEntity.ok(createdCar);
        }
    }

    
    @PutMapping(path="/api/clients/{id}")
    public ResponseEntity<Client> updateClient(
            @PathVariable Long id,
            @RequestBody Client x
    ){
        x.setId(id);
        Client createdCar = clientRepository.save(x);
        if(createdCar==null){
            return ResponseEntity.ok(createdCar);
        }else{
            return  ResponseEntity.ok(createdCar);
        }
    }




}
