package application.services;

import application.dao.SejourDAO;
import application.model.Sejour;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class SejourController {

    @Autowired
    private SejourDAO sejourDAO;

    @GetMapping("/sejours")
    public List<Sejour> getSejours() {
        return this.sejourDAO.findAll();
    }

    @GetMapping("/sejours/{id}")
    public Sejour getSejourById(@PathVariable int id) {
        return this.sejourDAO.findById(id);
    }

    @PostMapping("/sejours")
    public void postSejour(@RequestBody Sejour sejour) {
        this.sejourDAO.add(sejour);
    }

    @PutMapping("/sejours/{id}")
    public Sejour updateSejourById(@PathVariable int id, @RequestBody Sejour sejour) {
        return this.sejourDAO.updateById(id, sejour);
    }

    @DeleteMapping("/sejours/{id}")
    public void deleteSejour(@PathVariable int id) {
        this.sejourDAO.deleteById(id);
    }
}
