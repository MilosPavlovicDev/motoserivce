package rs.metropolitan.motoservis.service;

import org.springframework.stereotype.Service;
import rs.metropolitan.motoservis.model.Motorcycle;
import rs.metropolitan.motoservis.repository.MotorcycleRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MotorcycleService {

    private final MotorcycleRepository motorcycleRepository;

    public MotorcycleService(MotorcycleRepository motorcycleRepository) {
        this.motorcycleRepository = motorcycleRepository;
    }

    public List<Motorcycle> findAll() {
        return motorcycleRepository.findAll();
    }

    public Optional<Motorcycle> findById(Long id) {
        return motorcycleRepository.findById(id);
    }

    public List<Motorcycle> findByOwnerId(Long ownerId) {
        return motorcycleRepository.findByOwnerId(ownerId);
    }

    public Motorcycle save(Motorcycle motorcycle) {
        return motorcycleRepository.save(motorcycle);
    }

    public void deleteById(Long id) {
        motorcycleRepository.deleteById(id);
    }
}