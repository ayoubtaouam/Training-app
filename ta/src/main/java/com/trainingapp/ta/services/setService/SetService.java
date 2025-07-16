package com.trainingapp.ta.services.setService;

import com.trainingapp.ta.dtos.SetDTO;
import com.trainingapp.ta.entities.Set;

import java.util.List;

public interface SetService {
    Set addSet(SetDTO set);
    SetDTO getSet(Long id);
    List<SetDTO> getAllSets();
    void deleteSet(Long id);
    Set updateSet(Long id, SetDTO set);
}
