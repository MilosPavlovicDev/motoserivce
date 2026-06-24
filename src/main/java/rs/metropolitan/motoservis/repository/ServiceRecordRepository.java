package rs.metropolitan.motoservis.repository;

import org.springframework.stereotype.Repository;
import rs.metropolitan.motoservis.model.ServiceRecord;

import java.util.*;

@Repository
public class ServiceRecordRepository {

    private final Map<Long, ServiceRecord> storage = new HashMap<>();
    private Long nextId = 1L;

    public List<ServiceRecord> findAll() {
        return new ArrayList<>(storage.values());
    }

    public Optional<ServiceRecord> findById(Long id) {
        return Optional.ofNullable(storage.get(id));
    }

    public List<ServiceRecord> findByMotorcycleId(Long motorcycleId) {
        List<ServiceRecord> result = new ArrayList<>();
        for (ServiceRecord sr : storage.values()) {
            if (sr.getMotorcycle() != null && sr.getMotorcycle().getId().equals(motorcycleId)) {
                result.add(sr);
            }
        }
        return result;
    }

    public ServiceRecord save(ServiceRecord serviceRecord) {
        if (serviceRecord.getId() == null) {
            serviceRecord.setId(nextId++);
        }
        storage.put(serviceRecord.getId(), serviceRecord);
        return serviceRecord;
    }

    public void deleteById(Long id) {
        storage.remove(id);
    }
}
