package com.trainingapp.ta.services.microcycleService;

import com.trainingapp.ta.dtos.MicrocycleDTO;
import com.trainingapp.ta.entities.Microcycle;

import java.util.List;

public interface MicrocycleService {
    Microcycle addMicrocycle(MicrocycleDTO microcycle);
    List<MicrocycleDTO> getAllMicrocycles();
    MicrocycleDTO getMicrocycle(Long id);
    void deleteMicrocycle(Long id);
    Microcycle updateMicrocycleInfo(Long id, MicrocycleDTO microcycleToUpdate);
}
