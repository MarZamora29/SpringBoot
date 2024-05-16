package mar.Tarea.Veterinaria.service;

import mar.Tarea.Veterinaria.model.entity.Cita;

public interface ICita {

	Cita save(Cita cita);
	
	Cita findById(Integer id);
	
	void delete(Cita cita);
	
	Iterable<Cita> findAll();
	
}
