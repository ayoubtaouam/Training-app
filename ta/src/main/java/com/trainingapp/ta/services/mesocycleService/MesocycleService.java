package com.trainingapp.ta.services.mesocycleService;

import com.trainingapp.ta.dtos.MesocycleDTO;
import com.trainingapp.ta.entities.Mesocycle;

import java.util.List;

public interface MesocycleService {
    Mesocycle createProgram(MesocycleDTO mesocycleDTO);
    MesocycleDTO getProgram(Long id);
    List<MesocycleDTO> getAllPrograms();
    void deleteProgram(Long id);
}
