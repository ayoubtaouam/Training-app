package com.trainingapp.ta.services.microcycleService;


import com.trainingapp.ta.dtos.MicrocycleDTO;
import com.trainingapp.ta.entities.Microcycle;
import com.trainingapp.ta.exceptions.costumExceptions.MicrocycleNotFoundException;
import com.trainingapp.ta.mappers.MicrocycleMapper;
import com.trainingapp.ta.repositories.MicrocycleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service @AllArgsConstructor
public class MicrocycleServiceImpl implements MicrocycleService {
    private MicrocycleRepository microcycleRepository;
    private MicrocycleMapper microcycleMapper;
    public Microcycle addMicrocycle(MicrocycleDTO microcycle) {
        return microcycleRepository.save(microcycleMapper.toMicrocycle(microcycle));
    }

    @Override
    public MicrocycleDTO getMicrocycle(Long id) {
        Microcycle microcycle = microcycleRepository.findById(id).orElseThrow(() -> new MicrocycleNotFoundException(id));
        return microcycleMapper.toDTO(microcycle);
    }

    @Override
    public List<MicrocycleDTO> getAllMicrocycles() {
        return microcycleRepository.findAll().stream().map(m -> microcycleMapper.toDTO(m)).collect(Collectors.toList());
    }

    @Override
    public void deleteMicrocycle(Long id) {
        Microcycle microcycle = microcycleRepository.findById(id).orElseThrow(() -> new MicrocycleNotFoundException(id));
        microcycleRepository.delete(microcycle);
    }

    @Override
    public Microcycle updateMicrocycleInfo(Long id, MicrocycleDTO microcycleToUpdate) {
        Microcycle microcycle = microcycleRepository.findById(id).orElseThrow(() -> new MicrocycleNotFoundException(id));
        microcycle.setName(microcycleMapper.toMicrocycle(microcycleToUpdate).getName());
        microcycle.setType(microcycleMapper.toMicrocycle(microcycleToUpdate).getType());
        return microcycleRepository.save(microcycle);
    }
}
