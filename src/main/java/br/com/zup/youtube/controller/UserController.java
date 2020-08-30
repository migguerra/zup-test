package br.com.zup.youtube.controller;

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

@RestController
@RequestMapping("/api/v1")
public class UserController {

	@Autowired
	private UserService service;

	@GetMapping(value = "/user/{id}")
	public ResponseEntity<UserDTO> getUser(@PathVariable("id") Long id) {
		UserDTO user = service.getUser(id);
		return ResponseEntity.ok(user);
	}

	@PostMapping(value = "/user")
	public ResponseEntity<UserDTO> saveUser(@RequestBody UserDTO user) {
		UserDTO userSaved = service.saveUser(user);

		return new ResponseEntity<UserDTO>(userSaved, HttpStatus.CREATED);
	}

	@PutMapping(value = "/user/{id}")
	public ResponseEntity<UserDTO> updateUser(@PathVariable("id") Long id, @RequestBody UserDTO user) {
		UserDTO updateUser = service.updateUser(id, user);
		return new ResponseEntity<UserDTO>(updateUser, HttpStatus.OK);
	}

	@DeleteMapping(value = "/user/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable("id") Long id) {
		service.deleteUser(id);

		return ResponseEntity.ok().build();
	}
}
