package br.com.zup.youtube.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

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
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(value = "coments", description = "Operations pertaining to Coments in API")
@RequestMapping("/api/v1")
public class ComentsController {

	@Autowired
	private ComentsService service;

	private final String ERROR_MESSAGE_USER_ID = "USER ID NOT FOUND";

	@ApiOperation(value = "Save a Coment", response = ComentsDTO.class)
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Coment Saved"),
			@ApiResponse(code = 400, message = "The resource you were trying to reach is not found") })
	@PostMapping(value = "/coments/{id-user}/{id-video}", produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> saveComents(@RequestBody ComentsDTO comentsDto, @PathVariable("id-user") Long idUser,
			@PathVariable("id-video") Long idVideo) {

		ComentsDTO comentsSave = service.saveComentario(idUser, idVideo, comentsDto);

		if (comentsSave == null) {
			return new ResponseEntity<>(ERROR_MESSAGE_USER_ID, HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<>(comentsSave, HttpStatus.CREATED);
	}

	@ApiOperation(value = "Updated a Coment", response = ComentsDTO.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Coment Updated"),
			@ApiResponse(code = 400, message = "The resource you were trying to reach is not found") })
	@PutMapping(value = "/coments/{id}", produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> updateComents(@PathVariable("id") Long id, @RequestBody ComentsDTO coments) {

		ComentsDTO updateComents = service.updateComentario(id, coments);

		if (updateComents == null) {
			return new ResponseEntity<>(ERROR_MESSAGE_USER_ID, HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<>(updateComents, HttpStatus.OK);
	}

	@ApiOperation(value = "Deleted a Coment", response = ComentsDTO.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Coment Deleted") })
	@DeleteMapping(value = "/coments/{id}")
	public ResponseEntity<Void> deleteComents(@PathVariable("id") Long id) {
		service.deleteComent(id);
		return ResponseEntity.ok().build();
	}

	@ApiOperation(value = "Find Coments by a User Id", response = ComentsDTO.class)
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Retrived a List of Coments"),
			@ApiResponse(code = 400, message = "The resource you were trying to reach is not found") })
	@GetMapping(value = "/coments/video/{id-user}", produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ComentsDTO>> findComentsByUser(@PathVariable("id-user") Long idUser) {
		List<ComentsDTO> listComents = service.findByUser(idUser);

		return ResponseEntity.ok(listComents);
	}

	@ApiOperation(value = "Find Coments by a Video Id", response = ComentsDTO.class)
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Retrived a List of Coments"),
			@ApiResponse(code = 400, message = "The resource you were trying to reach is not found") })
	@GetMapping(value = "/coments/user/{id-video}", produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ComentsDTO>> findComentsByVideo(@PathVariable("id-video") Long idVideo) {
		List<ComentsDTO> listComents = service.findByVideo(idVideo);

		return ResponseEntity.ok(listComents);
	}

}
