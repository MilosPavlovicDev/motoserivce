package rs.metropolitan.motoservis.repository;

import org.springframework.stereotype.Repository;
import rs.metropolitan.motoservis.model.Owner;

import java.util.*;

@Repository
public class OwnerRepository {

    private final Map<Long, Owner> storage = new HashMap<>();
    private Long nextId = 1L;

    public List<Owner> findAll(){
        return new ArrayList<>(storage.values());
    }

    public Optional<Owner> findById(Long id) {
        return Optional.ofNullable(storage.get(id));
    }

    public Owner save(Owner owner) {
        if (owner.getId() == null) {
            owner.setId(nextId++);
        }
        storage.put(owner.getId(), owner);
        return owner;
    }

    public void deleteById(Long id) {
        storage.remove(id);
    }
}
