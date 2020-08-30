package br.com.zup.youtube.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.youtube.dto.ComentsDTO;
import br.com.zup.youtube.service.ComentsService;

@RestController
@RequestMapping("/api/v1")
public class ComentsController {

	@Autowired
	private ComentsService service;

	@PostMapping(value = "/coments/{id-user}/{id-video}")
	public ResponseEntity<ComentsDTO> saveComents(@RequestBody ComentsDTO comentsDto,
			@PathVariable("id-user") Long idUser, @PathVariable("id-video") Long idVideo) {
		ComentsDTO comentsSave = service.saveComentario(idUser, idVideo, comentsDto);

		return new ResponseEntity<ComentsDTO>(comentsSave, HttpStatus.CREATED);
	}

	@PutMapping(value = "/coments/{id}")
	public ResponseEntity<ComentsDTO> updateComents(@PathVariable("id") Long id, @RequestBody ComentsDTO Coments) {
		ComentsDTO updateComents = service.updateComentario(id, Coments);

		return new ResponseEntity<ComentsDTO>(updateComents, HttpStatus.OK);
	}

	@DeleteMapping(value = "/coments/{id}")
	public ResponseEntity<Void> deleteComents(@PathVariable("id") Long id) {
		service.deleteComent(id);
		return ResponseEntity.ok().build();
	}

	@GetMapping(value = "/coments/video/{id-user}")
	public ResponseEntity<List<ComentsDTO>> findComentsByUser(@PathVariable("id-user") Long idUser) {
		List<ComentsDTO> listComents = service.findByUser(idUser);

		return ResponseEntity.ok(listComents);
	}

	@GetMapping(value = "/coments/user/{id-video}")
	public ResponseEntity<List<ComentsDTO>> findComentsByVideo(@PathVariable("id-video") Long idVideo) {
		List<ComentsDTO> listComents = service.findByVideo(idVideo);

		return ResponseEntity.ok(listComents);
	}

}
