package cl.recoders.amorescaninos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.recoders.amorescaninos.entity.Caracteristica;
import cl.recoders.amorescaninos.repository.CaracteristicaRepository;

@Service
public class CaracteristicaServiceImpl implements CaracteristicaService {

	@Autowired
	CaracteristicaRepository caractRepo;
	
	@Override
	public Caracteristica create(Caracteristica caracteristica) {
		return caractRepo.save(caracteristica);
	}

	@Override
	public Caracteristica edit(Caracteristica caracteristica) {
		return caractRepo.save(caracteristica);
	}

	@Override
	public Caracteristica findById(long id) {
		return caractRepo.findById(id).orElse(null);
	}

	@Override
	public List<Caracteristica> findAll() {
		return caractRepo.findAll();
	}

	@Override
	public List<Caracteristica> findAllById(List<Long> caractList) {
		return caractRepo.findAllByIdIn(caractList);
	}

}
