package mar.Tarea.Veterinaria.model.entity;


import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;




@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Table(name="cita")

public class Cita {
	
	@Id
	@Column(name = "id_cita")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_cita;
	
	@Column(name = "nombre_mascota")
	private String nombre_mascota;
	
	@Column(name = "nombre_propietario")
	private String nombre_propietario;
	
	@Column(name = "telefono")
	private String telefono;
	
	@Column(name = "fecha")
	private Date fecha;
	
	@Column(name = "sintomas")
	private String sintomas;
	
	@Column(name = "email")
	String email;

	public Integer getId_cita() {
		return id_cita;
	}

	public void setId_cita(Integer id_cita) {
		this.id_cita = id_cita;
	}

	public String getNombre_mascota() {
		return nombre_mascota;
	}

	public void setNombre_mascota(String nombre_mascota) {
		this.nombre_mascota = nombre_mascota;
	}

	public String getNombre_propietario() {
		return nombre_propietario;
	}

	public void setNombre_propietario(String nombre_propietario) {
		this.nombre_propietario = nombre_propietario;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getSintomas() {
		return sintomas;
	}

	public void setSintomas(String sintomas) {
		this.sintomas = sintomas;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	
	
	
	

	
	
	

}
