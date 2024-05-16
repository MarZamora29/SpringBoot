package mar.Tarea.Veterinaria.model.dao;

import org.springframework.data.repository.CrudRepository;

import mar.Tarea.Veterinaria.model.entity.Cita;

public interface CitasDao extends CrudRepository<Cita, Integer> {

}
