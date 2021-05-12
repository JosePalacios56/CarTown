package com.proyecto.cartown.service.impl;

import com.proyecto.cartown.modelo.Coche;
import com.proyecto.cartown.modelo.dto.CocheDTO;
import com.proyecto.cartown.repository.CocheRepository;
import com.proyecto.cartown.service.CocheServices;
import com.proyecto.cartown.service.converter.ConvertCocheDTOtoCoche;
import com.proyecto.cartown.service.converter.ConvertCocheToCocheDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CocheServicesImpl implements CocheServices {

    @Autowired
    CocheRepository cocheRepository;

    @Autowired
    ConvertCocheDTOtoCoche cocheDTOtoCoche;

    @Autowired
    ConvertCocheToCocheDTO cocheToCocheDTO;

    @Override
    public List<CocheDTO> getAll() {
        return cocheRepository.findAll()
                .stream()
                .map( cocheToCocheDTO::convert )
                .collect( Collectors.toList());
    }

    @Override
    public CocheDTO create(CocheDTO cochedto) {
        Coche coche = cocheDTOtoCoche.convert(cochedto);
        return cocheToCocheDTO.convert(cocheRepository.insert(coche));
    }

    @Override
    public CocheDTO update(CocheDTO tutorial) {
        return null;
    }

    @Override
    public Boolean delete(String id) {
        try{
            cocheRepository.deleteById(id);
            return Boolean.TRUE;
        } catch (Exception e){
            return Boolean.FALSE;
        }
    }

    @Override
    public Boolean deleteAllCoches() {
        try{
            cocheRepository.deleteAll();
            return Boolean.TRUE;
        } catch (Exception e){
            return Boolean.FALSE;
        }
    }
}
