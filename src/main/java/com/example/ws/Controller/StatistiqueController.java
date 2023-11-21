package com.example.ws.Controller;

import com.example.ws.Model.Bag;
import com.example.ws.Model.Statistique;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;

@RestController
@RequestMapping
public class StatistiqueController {

    @GetMapping("/")
    public Bag Statistique() {
        Connection connection = null;
        String exception = null;
        Object data = null;
        try {
            Statistique statistique = new Statistique();
            data = statistique.getStatitstiques(connection);
        }
        catch (Exception e) {
            exception = e.getMessage();
        }
        return new Bag(exception, data);
    }
}
