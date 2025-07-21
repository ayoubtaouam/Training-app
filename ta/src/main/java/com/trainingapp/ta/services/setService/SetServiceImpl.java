package com.trainingapp.ta.services.setService;

import com.trainingapp.ta.dtos.SetDTO;
import com.trainingapp.ta.entities.Set;
import com.trainingapp.ta.exceptions.costumExceptions.SetNotFoundException;
import com.trainingapp.ta.mappers.SetMapper;
import com.trainingapp.ta.repositories.SetRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service @AllArgsConstructor
public class SetServiceImpl implements SetService {
    private SetRepository setRepository;
    private SetMapper setMapper;
    @Override
    public Set addSet(SetDTO set) {
        return setRepository.save(setMapper.toSet(set));
    }

    @Override
    public SetDTO getSet(Long id) {
        Set set = setRepository.findById(id).orElseThrow(() -> new SetNotFoundException(id));
        return setMapper.toDTO(set);
    }

    @Override
    public List<SetDTO> getAllSets() {
        List<Set> sets = setRepository.findAll();
        return sets.stream().map(s -> setMapper.toDTO(s)).collect(Collectors.toList());
    }

    @Override
    public void deleteSet(Long id) {
        if (!setRepository.existsById(id)) {
            throw new SetNotFoundException(id);
        }
        setRepository.deleteById(id);
    }

    @Override
    public Set updateSet(Long id, SetDTO setToUpdate) {
        Set set = setRepository.findById(id).orElseThrow(() -> new SetNotFoundException(id));
        set.setReps(setMapper.toSet(setToUpdate).getReps());
        set.setWeight(setMapper.toSet(setToUpdate).getWeight());
        set.setUnit(setMapper.toSet(setToUpdate).getUnit());
        set.setBodyWeight(setMapper.toSet(setToUpdate).isBodyWeight());
        return setRepository.save(set);
    }
}
