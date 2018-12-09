package application.dao;

import application.model.Presence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PresenceDAO extends JpaRepository<Presence, Integer> {
    public List<Presence> findAll();
    public Presence findById(int id);
    public Presence save(Presence formateur);
    public void deleteById(int id);
}
