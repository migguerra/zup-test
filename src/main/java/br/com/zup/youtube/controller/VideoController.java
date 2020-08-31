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

import br.com.zup.youtube.dto.VideoInputDTO;
import br.com.zup.youtube.dto.VideoOutPutDTO;
import br.com.zup.youtube.service.VideoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(value = "video", description = "Operations pertaining to video in API")
@RequestMapping("/api/v1")
public class VideoController {

	@Autowired
	private VideoService service;

	private final String ERROR_MESSAGE_USER_ID = "USER ID NOT FOUND";

	@ApiOperation(value = "Get a video by your id", response = VideoOutPutDTO.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved a Video"),
			@ApiResponse(code = 400, message = "The resource you were trying to reach is not found") })
	@GetMapping(value = "/video/{id}", produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> getVideo(@PathVariable("id") Long id) {
		VideoOutPutDTO getVideo = service.getVideo(id);

		if (getVideo == null) {
			return new ResponseEntity<>(ERROR_MESSAGE_USER_ID, HttpStatus.BAD_REQUEST);
		}

		return ResponseEntity.ok(getVideo);
	}

	@ApiOperation(value = "Get a list of video by user id")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved a list of Video"),
			@ApiResponse(code = 400, message = "The resource you were trying to reach is not found") })
	@GetMapping(value = "/video/user/{id-user}", produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<List<VideoOutPutDTO>> getListVideoByUser(@PathVariable("id-user") Long id) {
		List<VideoOutPutDTO> listVideo = service.getListVideoByUser(id);

		return ResponseEntity.ok(listVideo);
	}

	@ApiOperation(value = "Save video", response = VideoOutPutDTO.class)
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Successfully Video Saved"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@PostMapping(value = "/video/{id-usuario}", produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> saveVideo(@PathVariable("id-usuario") Long idUsuario,
			@RequestBody VideoInputDTO videoDto) {
		VideoOutPutDTO savedVideo = service.saveVideo(videoDto, idUsuario);

		if (savedVideo == null) {
			return new ResponseEntity<>(ERROR_MESSAGE_USER_ID, HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<>(savedVideo, HttpStatus.CREATED);
	}

	@ApiOperation(value = "Update a video", response = VideoOutPutDTO.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully Video Updated"),
			@ApiResponse(code = 400, message = "The resource you were trying to reach is not found") })
	@PutMapping(value = "/video/{id}", produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> updateVideo(@PathVariable("id") Long id, @RequestBody VideoInputDTO videoDto) {

		VideoOutPutDTO videoSaved = service.updateVideo(id, videoDto);

		if (videoSaved == null) {
			return new ResponseEntity<>(ERROR_MESSAGE_USER_ID, HttpStatus.BAD_REQUEST);
		}

		return ResponseEntity.ok(videoSaved);
	}

	@ApiOperation(value = "Delete a video", response = VideoOutPutDTO.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully Video Deleted") })
	@DeleteMapping(value = "/video/{id}")
	public ResponseEntity<Void> deleteVideoEntity(@PathVariable("id") Long id) {
		service.deleteVideo(id);
		return ResponseEntity.ok().build();
	}

	@ApiOperation(value = "Increase or descrease like number", response = VideoOutPutDTO.class)
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Operations was succed") })
	@PutMapping(value = "/video/{id}/{like-number}/{deslike-number}")
	public ResponseEntity<Void> likeVideo(@PathVariable("id") Long id, @PathVariable("like-number") Long likeNumber,
			@PathVariable("deslike-number") Long dislikeNumber) {
		service.likeVideo(id, likeNumber, dislikeNumber);
		return ResponseEntity.ok().build();
	}

}
