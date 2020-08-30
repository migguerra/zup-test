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

import br.com.zup.youtube.dto.VideoInputDTO;
import br.com.zup.youtube.dto.VideoOutPutDTO;
import br.com.zup.youtube.service.VideoService;

@RestController
@RequestMapping("/api/v1")
public class VideoController {

	@Autowired
	private VideoService service;

	@GetMapping(value = "/video/{id}")
	public ResponseEntity<VideoOutPutDTO> getVideo(@PathVariable("id") Long id) {
		VideoOutPutDTO getVideo = service.getVideo(id);

		return ResponseEntity.ok(getVideo);
	}

	@GetMapping(value = "/video/user/{id-user}")
	public ResponseEntity<List<VideoOutPutDTO>> getListVideoByUser(@PathVariable("id-user") Long id) {
		List<VideoOutPutDTO> listVideo = service.getListVideoByUser(id);

		return ResponseEntity.ok(listVideo);
	}

	@PostMapping(value = "/video/{id-usuario}")
	public ResponseEntity<Object> saveVideo(@PathVariable("id-usuario") Long idUsuario,
			@RequestBody VideoInputDTO videoDto) {
		VideoOutPutDTO savedVideo = service.saveVideo(videoDto, idUsuario);

		if (savedVideo == null) {
			return new ResponseEntity<Object>("user id not found", HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<Object>(savedVideo, HttpStatus.CREATED);
	}

	@PutMapping(value = "/video/{id}")
	public ResponseEntity<VideoOutPutDTO> updateVideo(@PathVariable("id") Long id,
			@RequestBody VideoInputDTO videoDto) {

		VideoOutPutDTO videoSaved = service.updateVideo(id, videoDto);

		return ResponseEntity.ok(videoSaved);
	}

	@DeleteMapping(value = "/video/{id}")
	public ResponseEntity<Void> deleteVideoEntity(@PathVariable("id") Long id) {
		service.deleteVideo(id);
		return ResponseEntity.ok().build();
	}

	@PutMapping(value = "/video/{id}/{like-number}/{deslike-number}")
	public ResponseEntity<Void> likeVideo(@PathVariable("id") Long id, @PathVariable("like-number") Long likeNumber,
			@PathVariable("deslike-number") Long dislikeNumber) {
		service.likeVideo(id, likeNumber, dislikeNumber);
		return ResponseEntity.ok().build();
	}

}
