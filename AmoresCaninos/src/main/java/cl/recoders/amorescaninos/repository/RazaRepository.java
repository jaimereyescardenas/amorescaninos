package cl.recoders.amorescaninos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.recoders.amorescaninos.entity.Raza;

@Repository
public interface RazaRepository extends JpaRepository<Raza, Long> {

}
