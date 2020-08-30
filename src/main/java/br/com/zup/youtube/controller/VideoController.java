package br.com.zup.youtube.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.youtube.dto.VideoInputDTO;
import br.com.zup.youtube.dto.VideoOutPutDTO;
import br.com.zup.youtube.model.VideoEntity;
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
	public ResponseEntity<VideoEntity> updateVideo(@PathVariable("id") Long id, @RequestBody VideoEntity user) {
		return null;
	}

	@DeleteMapping(value = "/video/{id}")
	public ResponseEntity<Void> deleteVideoEntity(@PathVariable("id") Long id) {
		return null;
	}

	@PatchMapping(value = "/video/{id}/{like-number}")
	public ResponseEntity<VideoEntity> likeVideo(@PathVariable("id") Long id,
			@PathVariable("like-number") Long likeNumber) {
		return null;
	}

	@PatchMapping(value = "/video/{id}/{dislike-number}")
	public ResponseEntity<VideoEntity> unLikeVideo(@PathVariable("id") Long id,
			@PathVariable("dislike-number") Long dislikeNumber) {
		return null;
	}
}
