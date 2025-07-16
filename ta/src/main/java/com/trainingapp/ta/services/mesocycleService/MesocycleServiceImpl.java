package com.trainingapp.ta.services.mesocycleService;

import com.trainingapp.ta.dtos.MesocycleDTO;
import com.trainingapp.ta.entities.Mesocycle;
import com.trainingapp.ta.exceptions.costumExceptions.MesocycleNotFoundException;
import com.trainingapp.ta.mappers.MesocycleMapper;
import com.trainingapp.ta.repositories.MesocycleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class MesocycleServiceImpl implements MesocycleService{
    private MesocycleRepository mesocycleRepository;
    private MesocycleMapper mesocycleMapper;
    @Override
    public Mesocycle createProgram(MesocycleDTO mesocycle) {
        return mesocycleRepository.save(mesocycleMapper.toMesocycle(mesocycle));
    }

    @Override
    public MesocycleDTO getProgram(Long id) {
        Mesocycle mesocycle = mesocycleRepository.findById(id).orElseThrow(() -> new MesocycleNotFoundException(id));
        return mesocycleMapper.toDTO(mesocycle);
    }

    @Override
    public List<MesocycleDTO> getAllPrograms() {
        return mesocycleRepository.findAll().stream().map(m -> mesocycleMapper.toDTO(m)).collect(Collectors.toList());
    }

    @Override
    public void deleteProgram(Long id) {
        Mesocycle mesocycle = mesocycleRepository.findById(id).orElseThrow(() -> new MesocycleNotFoundException(id));
        mesocycleRepository.delete(mesocycle);
    }

    @Override
    public Mesocycle updateMesocycleInfo(Long id, MesocycleDTO mesocycleToUpdate) {
        Mesocycle mesocycle = mesocycleRepository.findById(id).orElseThrow(() -> new MesocycleNotFoundException(id));
        mesocycle.setName(mesocycleMapper.toMesocycle(mesocycleToUpdate).getName());
        mesocycle.setDescription(mesocycleMapper.toMesocycle(mesocycleToUpdate).getDescription());
        return mesocycleRepository.save(mesocycle);
    }
}
