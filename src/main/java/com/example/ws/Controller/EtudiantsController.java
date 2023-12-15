package com.example.ws.Controller;

import com.example.ws.Model.Bag;
import com.example.ws.Model.Etudiant;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
public class EtudiantsController {
    
    @GetMapping("etudiants")
    public Bag getAll() throws Exception {
        try {
            Bag bag = new Bag(null, new Etudiant().findAll(null));
            return bag;
        } catch (Exception e) {
            throw e;
        }
    }

    @PostMapping("save-etudiants")
    public Bag save(@RequestBody String nom) throws Exception {
        try {
            Etudiant etudiant = new Etudiant();
            etudiant.setNom(nom);
            etudiant.save(null);
            return new Bag("", null);
        } catch (Exception e) {
            throw e;
        }
    }

}
