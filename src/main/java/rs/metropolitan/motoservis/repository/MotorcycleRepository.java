package rs.metropolitan.motoservis.repository;

import org.springframework.stereotype.Repository;
import rs.metropolitan.motoservis.model.Motorcycle;

import java.util.*;

@Repository
public class MotorcycleRepository {

    private final Map<Long, Motorcycle> storage = new HashMap<>();
    private Long nextId = 1L;

    public List<Motorcycle> findAll() {
        return new ArrayList<>(storage.values());
    }

    public Optional<Motorcycle> findById(Long id) {
        return Optional.ofNullable(storage.get(id));
    }

    public List<Motorcycle> findByOwnerId(Long ownerId) {
        List<Motorcycle> result = new ArrayList<>();
        for (Motorcycle m : storage.values()) {
            if (m.getOwner() != null && m.getOwner().getId().equals(ownerId)) {
                result.add(m);
            }
        }
        return result;
    }

    public Motorcycle save(Motorcycle motorcycle) {
        if (motorcycle.getId() == null) {
            motorcycle.setId(nextId++);
        }
        storage.put(motorcycle.getId(), motorcycle);
        return motorcycle;
    }

    public void deleteById(Long id) {
        storage.remove(id);
    }

}
