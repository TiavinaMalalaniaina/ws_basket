package com.example.ws.Controller;

import com.example.ws.Model.Bag;
import com.example.ws.Model.Etudiant;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
public class EtudiantsController {
    
    @GetMapping("etudiants")
    public Bag getAll() {
        Etudiant etudiant = new Etudiant();
        etudiant.setId(1);
        etudiant.setNom("Tiavina");
        Bag bag = new Bag(null, etudiant);
        return bag;
    }

    @GetMapping("etudiants/{id}")
    public Bag get(@PathVariable int id) {
        Etudiant etudiant = new Etudiant();
        etudiant.setId(1);
        etudiant.setNom("Tiavina");
        Bag bag = new Bag(null, etudiant);
        return bag;
    }

}
