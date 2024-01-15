package cat.itacademy.barcelonactiva.aliciagomez.S05T01N01AliciaGomez.model.repository;

import cat.itacademy.barcelonactiva.aliciagomez.S05T01N01AliciaGomez.model.domain.Sucursal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SucursalRepository extends JpaRepository<Sucursal, Integer> {
}
