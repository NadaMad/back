package application.controller;

import application.dao.FormateurDAO;
import application.model.Formateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FormateurController {

    @Autowired
    private FormateurDAO formateurDAO;

    @GetMapping("/api/formateurs")
    public List<Formateur> getFormateurs() {
        return this.formateurDAO.findAll();
    }

    @GetMapping("/api/formateurs/{id}")
    public Formateur getFormateurById(@PathVariable int id) {
        return this.formateurDAO.findById(id);
    }

    @GetMapping("/api/formateursSite/{id}")
    public  List<Formateur> getFormateurBySite(@PathVariable int id) {
        return this.formateurDAO.findByIdSite(id);
    }

    @PostMapping("/api/formateurs")
    public void postFormateur(@RequestBody Formateur formateur) {
        this.formateurDAO.save(formateur);
    }

    @PutMapping("/api/formateurs/{id}")
    public Formateur updateFormateur(@RequestBody Formateur formateur) {
        return this.formateurDAO.save(formateur);
    }

    @DeleteMapping("/api/formateurs/{id}")
    public void deleteFormateur(@PathVariable int id) {
        this.formateurDAO.deleteById(id);
    }
}