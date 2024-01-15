package cat.itacademy.barcelonactiva.aliciagomez.S05T01N01AliciaGomez.model.services;

import cat.itacademy.barcelonactiva.aliciagomez.S05T01N01AliciaGomez.model.domain.Sucursal;
import cat.itacademy.barcelonactiva.aliciagomez.S05T01N01AliciaGomez.model.dto.SucursalDTO;

import java.util.List;
import java.util.Optional;

public interface SucursalService {

    public SucursalDTO save(SucursalDTO sucursalDTO);

    public void deleteById(int id);

    public Optional<SucursalDTO> findById(int id);

    public List<SucursalDTO> findAll();

}
