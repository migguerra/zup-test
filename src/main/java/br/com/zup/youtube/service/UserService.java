package br.com.zup.youtube.service;

import br.com.zup.youtube.dto.UserDTO;

public interface UserService {

	public UserDTO saveUser(UserDTO userDto);

	public UserDTO getUser(Long id);

	public UserDTO updateUser(Long id, UserDTO userDto);

	public void deleteUser(Long id);

}
