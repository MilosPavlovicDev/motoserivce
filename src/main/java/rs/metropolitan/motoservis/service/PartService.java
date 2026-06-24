package rs.metropolitan.motoservis.service;

import org.springframework.stereotype.Service;
import rs.metropolitan.motoservis.model.Part;
import rs.metropolitan.motoservis.repository.PartRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PartService {

    private final PartRepository partRepository;

    public PartService(PartRepository partRepository) {
        this.partRepository = partRepository;
    }

    public List<Part> findAll() {
        return partRepository.findAll();
    }

    public Optional<Part> findById(Long id) {
        return partRepository.findById(id);
    }

    public List<Part> findByServiceRecordId(Long serviceRecordId) {
        return partRepository.findByServiceRecordId(serviceRecordId);
    }

    public Part save(Part part) {
        return partRepository.save(part);
    }

    public void deleteById(Long id) {
        partRepository.deleteById(id);
    }
}