package br.com.zup.youtube.controller;

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

import br.com.zup.youtube.model.VideoEntity;

@RestController
@RequestMapping("/api/v1")
public class VideoController {

	@GetMapping(value = "/video/{id}")
	public ResponseEntity<VideoEntity> getVideo(@PathVariable("id") Long id) {
		return null;
	}

	@PostMapping(value = "/video")
	public ResponseEntity<VideoEntity> saveVideo(@RequestBody VideoEntity user) {
		return null;
	}

	@PutMapping(value = "/video/{id}")
	public ResponseEntity<VideoEntity> updateVideo(@PathVariable("id") Long id, @RequestBody VideoEntity user) {
		return null;
	}

	@DeleteMapping(value = "/video/{id}")
	public ResponseEntity<Void> deleteVideoEntity(@PathVariable("id") Long id) {
		return null;
	}

	@PatchMapping(value = "/video/{id}")
	public ResponseEntity<VideoEntity> likeVideo(@PathVariable("id") Long id) {
		return null;
	}

	@PatchMapping(value = "/video/{id}")
	public ResponseEntity<VideoEntity> unLikeVideo(@PathVariable("id") Long id) {
		return null;
	}
}
