package br.com.zup.youtube.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

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

import br.com.zup.youtube.dto.UserDTO;
import br.com.zup.youtube.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(value = "user", description = "Operations pertaining to User in API")
@RequestMapping("/api/v1")
public class UserController {

	@Autowired
	private UserService service;

	private final String ERROR_MESSAGE_USER_ID = "USER ID NOT FOUND";

	@ApiOperation(value = "Get a user by your id", response = UserDTO.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved a User"),
			@ApiResponse(code = 400, message = "The resource you were trying to reach is not found") })
	@GetMapping(value = "/user/{id}", produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> getUser(@PathVariable("id") Long id) {
		UserDTO user = service.getUser(id);

		if (user == null) {
			return new ResponseEntity<>(ERROR_MESSAGE_USER_ID, HttpStatus.BAD_REQUEST);
		}

		return ResponseEntity.ok(user);
	}

	@ApiOperation(value = "Save a User", response = UserDTO.class)
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Successfully saved a User"),
			@ApiResponse(code = 400, message = "The resource you were trying to reach is not found") })
	@PostMapping(value = "/user", produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> saveUser(@RequestBody UserDTO user) {
		UserDTO userSaved = service.saveUser(user);

		if (userSaved == null) {
			return new ResponseEntity<>(ERROR_MESSAGE_USER_ID, HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<>(userSaved, HttpStatus.CREATED);
	}

	@ApiOperation(value = "Updated a User", response = UserDTO.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully updated a User"),
			@ApiResponse(code = 400, message = "The resource you were trying to reach is not found") })
	@PutMapping(value = "/user/{id}", produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> updateUser(@PathVariable("id") Long id, @RequestBody UserDTO user) {
		UserDTO updateUser = service.updateUser(id, user);

		if (user == null) {
			return new ResponseEntity<>(ERROR_MESSAGE_USER_ID, HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<>(updateUser, HttpStatus.OK);
	}

	@ApiOperation(value = "Delete a user", response = UserDTO.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully User deleted"),
			@ApiResponse(code = 400, message = "The resource you were trying to reach is not found") })
	@DeleteMapping(value = "/user/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable("id") Long id) {
		service.deleteUser(id);

		return ResponseEntity.ok().build();
	}
}
