package rs.metropolitan.motoservis.repository;

import org.springframework.stereotype.Repository;
import rs.metropolitan.motoservis.model.Mechanic;

import java.util.*;

@Repository
public class MechanicRepository {

    private final Map<Long, Mechanic> storage = new HashMap<>();
    private Long nextId = 1L;

    public List<Mechanic> findAll(){
        return new ArrayList<>(storage.values());
    }

    public Optional<Mechanic> findById(Long id) {
        return Optional.ofNullable(storage.get(id));
    }

    public Mechanic save(Mechanic mechanic) {
        if (mechanic.getId() == null) {
            mechanic.setId(nextId++);
        }
        storage.put(mechanic.getId(), mechanic);
        return mechanic;
    }

    public void deleteById(Long id) {
        storage.remove(id);
    }

}