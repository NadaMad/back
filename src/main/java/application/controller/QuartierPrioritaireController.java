package application.controller;

import application.dao.QuartierPrioritaireDAO;
import application.model.QuartierPrioritaire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class QuartierPrioritaireController {

    @Autowired
    private QuartierPrioritaireDAO quartierPrioritaireDAO;

    @GetMapping("/api/quartiers")
    public List<QuartierPrioritaire> getQuartiers() {
        return this.quartierPrioritaireDAO.findAll();
    }

    @GetMapping("/api/quartiers/{id}")
    public QuartierPrioritaire getQuartierById(@PathVariable int id) {
        return this.quartierPrioritaireDAO.findById(id);
    }

    @PostMapping("/api/quartiers")
    public void postQuartier(@RequestBody QuartierPrioritaire quartierPrioritaire) {
        this.quartierPrioritaireDAO.save(quartierPrioritaire);
    }

    @PutMapping("/api/quartiers")
    public QuartierPrioritaire updateQuartier(@RequestBody QuartierPrioritaire quartierPrioritaire) {
        return this.quartierPrioritaireDAO.save(quartierPrioritaire);
    }

    @DeleteMapping("/api/quartiers/{id}")
    public void deleteQuartier(@PathVariable int id) {
        this.quartierPrioritaireDAO.deleteById(id);
    }
}