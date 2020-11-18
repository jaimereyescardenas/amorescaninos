package cl.recoders.amorescaninos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import cl.recoders.amorescaninos.entity.Caracteristica;

@Repository
public interface CaracteristicaRepository extends JpaRepository<Caracteristica, Long>{

	List<Caracteristica> findAllByIdIn(@Nullable List<Long> list);
	
}
