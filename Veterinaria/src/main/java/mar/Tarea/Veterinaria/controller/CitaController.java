package mar.Tarea.Veterinaria.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mar.Tarea.Veterinaria.model.entity.Cita;
import mar.Tarea.Veterinaria.service.ICita;
import mar.Tarea.Veterinaria.service.impl.EmailService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api")
public class CitaController {

	@Autowired
	private ICita citaService;
	
	@Autowired
	private EmailService emailservi;
	private static final Logger logger = LoggerFactory.getLogger(CitaController.class);
	
	
	
	@PostMapping("cita")
	public Cita create(@RequestBody Cita cita) {		
		logger.info("Ciata a agregar: " + cita);
		Cita saveProducto = citaService.save(cita);
		emailservi.enviarCorreoCitaGuardado(saveProducto.getEmail());
		return citaService.save(cita);
	}
	
	@PutMapping("cita")
	public Cita update(@PathVariable Integer id, @RequestBody Cita cita) {		
		Cita existingProduct = citaService.findById(id);
        if (existingProduct == null) {
        	logger.warn("Ciata no encontrada con el ID: " + id);
        }
        cita.setId_cita(id); 
        Cita updateCita = citaService.save(cita);
        emailservi.enviarCorreoCitaModificado(updateCita.getEmail());
        return updateCita;
	}
	
	
	@DeleteMapping("cita/{id}")
	public void delete(@PathVariable Integer id) {
		Cita citaDelete = citaService.findById(id);
	    if (citaDelete != null) {
	        citaService.delete(citaDelete);
	    } else {
	        logger.warn("Intento de eliminar una Cita con ID no válido: " + id);
	    }
	}
	
	
	@GetMapping("cita/{id}")
	public Cita showById(@PathVariable Integer id) {
		return citaService.findById(id);
	}
	
	
	@GetMapping("cita")
	public Iterable<Cita> show() {
		return citaService.findAll();
	}
}
