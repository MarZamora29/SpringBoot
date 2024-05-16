package mar.Tarea.Veterinaria.service.impl;

import java.nio.charset.StandardCharsets;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;


import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Value;


@Service
public class EmailService {
  @Autowired
  private JavaMailSender javaMailSender;
  @Value("${spring.mail.username}")
  private String remitente;
  

    
  // Método para enviar correo de confirmación al guardar una cita
  public void enviarCorreoCitaGuardado(String destinatario) {
    String asunto = "Cita Almacenda";
    String mensaje = "<html><body><h1>La cita se a Almacenado</h1><p>La cita se ha almacenado correctamente.</p></body></html>";
    enviarCorreo(destinatario, asunto, mensaje);
  }
  // Método para enviar correo de confirmación al modificar una cita
  public void enviarCorreoCitaModificado(String destinatario) {
    String asunto = "La cita se ha Modificado";
    String mensaje = "<html><body><h1>Cita Modificado</h1><p>La cita se ha modificado correctamente.</p></body></html>";
    enviarCorreo(destinatario, asunto, mensaje);
  }
  // Método para enviar correo de notificación al eliminar una cita
  public void enviarCorreoCitaEliminado(String destinatario, String
  productoEliminado) {
    String asunto = "Cita Eliminado";
    String mensaje = "<html><body><h1>Cita Eliminado</h1><p>La siguiente sita ha sido eliminado: <strong>" + productoEliminado + "</strong></p></body></html>";
    enviarCorreo(destinatario, asunto, mensaje);
  }
  // Método genérico para enviar correo electrónico
  // Método genérico para enviar correo electrónico
  private void enviarCorreo(String destinatario, String asunto, String  mensaje) {
    MimeMessage message = javaMailSender.createMimeMessage();
    MimeMessageHelper helper = new MimeMessageHelper(message,
    StandardCharsets.UTF_8.name());
    try {
      helper.setTo(destinatario);
      helper.setSubject(asunto);
      helper.setText(mensaje, true); // Indicar que el mensaje esHTML 
      helper.setFrom(remitente);
      javaMailSender.send(message);
    } catch (MessagingException e) {
      e.printStackTrace();
      // Manejar la excepción adecuadamente
    }
  }
}
