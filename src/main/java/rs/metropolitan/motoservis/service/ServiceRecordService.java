package rs.metropolitan.motoservis.service;

import org.springframework.stereotype.Service;
import rs.metropolitan.motoservis.model.ServiceRecord;
import rs.metropolitan.motoservis.repository.ServiceRecordRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceRecordService {

    private final ServiceRecordRepository serviceRecordRepository;

    public ServiceRecordService(ServiceRecordRepository serviceRecordRepository) {
        this.serviceRecordRepository = serviceRecordRepository;
    }

    public List<ServiceRecord> findAll() {
        return serviceRecordRepository.findAll();
    }

    public Optional<ServiceRecord> findById(Long id) {
        return serviceRecordRepository.findById(id);
    }

    public List<ServiceRecord> findByMotorcycleId(Long motorcycleId) {
        return serviceRecordRepository.findByMotorcycleId(motorcycleId);
    }

    public ServiceRecord save(ServiceRecord serviceRecord) {
        return serviceRecordRepository.save(serviceRecord);
    }

    public void deleteById(Long id) {
        serviceRecordRepository.deleteById(id);
    }
}
