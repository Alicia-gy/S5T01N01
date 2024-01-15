package cat.itacademy.barcelonactiva.aliciagomez.S05T01N01AliciaGomez.model.services.impl;

import cat.itacademy.barcelonactiva.aliciagomez.S05T01N01AliciaGomez.model.dto.SucursalDTO;
import cat.itacademy.barcelonactiva.aliciagomez.S05T01N01AliciaGomez.model.services.SucursalService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cat.itacademy.barcelonactiva.aliciagomez.S05T01N01AliciaGomez.model.domain.Sucursal;
import cat.itacademy.barcelonactiva.aliciagomez.S05T01N01AliciaGomez.model.repository.SucursalRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class SucursalServiceImpl implements SucursalService {


    @Autowired
    private SucursalRepository sucursalRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public SucursalDTO save(SucursalDTO sucursalDTO) {
        Sucursal entity = modelMapper.map(sucursalDTO, Sucursal.class);
        sucursalRepository.save(entity);
        return modelMapper.map(entity, SucursalDTO.class);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        sucursalRepository.deleteById(id);

    }

    @Override
    @Transactional(readOnly = true)
    public Optional<SucursalDTO> findById(int id) {
        SucursalDTO dto = modelMapper.map(sucursalRepository.findById(id), SucursalDTO.class);
        return Optional.ofNullable(dto);
    }

    @Override
    @Transactional(readOnly = true)
    public List<SucursalDTO> findAll() {
        List<Sucursal> sucursals = sucursalRepository.findAll();
        return sucursals.stream().map(flor -> modelMapper.map(sucursals, SucursalDTO.class)).collect(Collectors.toList());
    }

}