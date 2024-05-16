package mar.Tarea.Veterinaria.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import mar.Tarea.Veterinaria.model.dao.CitasDao;
import mar.Tarea.Veterinaria.model.entity.Cita;
import mar.Tarea.Veterinaria.service.ICita;


@Service
public class CitaImpl implements ICita {
	
	@Autowired
	private CitasDao citasDao;

	@Override
	public Iterable<Cita> findAll(){
		return citasDao.findAll();
	}
	
	
	@Transactional
	@Override
	public Cita save(Cita cita) {
		return citasDao.save(cita);
	}

	@Transactional
	@Override
	public Cita findById(Integer id) {
		return citasDao.findById(id).orElse(null);
	}

	@Transactional
	@Override
	public void delete(Cita id) {
		citasDao.delete(id);
		
	}
	
	
	
}
