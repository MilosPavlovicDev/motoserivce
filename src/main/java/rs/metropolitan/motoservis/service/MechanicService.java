package rs.metropolitan.motoservis.service;

import org.springframework.stereotype.Service;
import rs.metropolitan.motoservis.model.Mechanic;
import rs.metropolitan.motoservis.repository.MechanicRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MechanicService {

    private final MechanicRepository mechanicRepository;

    public MechanicService(MechanicRepository mechanicRepository) {
        this.mechanicRepository = mechanicRepository;
    }

    public List<Mechanic> findAll() {
        return mechanicRepository.findAll();
    }

    public Optional<Mechanic> findById(Long id) {
        return mechanicRepository.findById(id);
    }

    public Mechanic save(Mechanic mechanic) {
        return mechanicRepository.save(mechanic);
    }

    public void deleteById(Long id) {
        mechanicRepository.deleteById(id);
    }
}