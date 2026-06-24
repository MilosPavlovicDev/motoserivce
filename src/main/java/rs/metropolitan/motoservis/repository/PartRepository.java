package rs.metropolitan.motoservis.repository;

import rs.metropolitan.motoservis.model.Part;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class PartRepository {
    private final Map<Long, Part> storage = new HashMap<>();
    private Long nextId = 1L;

    public List<Part> findAll() {
        return new ArrayList<>(storage.values());
    }

    public Optional<Part> findById(Long id) {
        return Optional.ofNullable(storage.get(id));
    }

    public List<Part> findByServiceRecordId(Long serviceRecordId) {
        List<Part> result = new ArrayList<>();
        for (Part p : storage.values()) {
            if (p.getServiceRecord() != null && p.getServiceRecord().getId().equals(serviceRecordId)) {
                result.add(p);
            }
        }
        return result;
    }

    public Part save(Part part) {
        if (part.getId() == null) {
            part.setId(nextId++);
        }
        storage.put(part.getId(), part);
        return part;
    }

    public void deleteById(Long id) {
        storage.remove(id);
    }
}
