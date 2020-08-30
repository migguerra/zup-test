package br.com.zup.youtube.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.zup.youtube.dto.UserDTO;
import br.com.zup.youtube.model.UserEntity;
import br.com.zup.youtube.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository repository;

	private ModelMapper mapper = new ModelMapper();

	@Override
	public UserDTO getUser(Long id) {
		if (this.isExist(id)) {
			UserEntity userEntity = repository.findById(id).get();
			return mapper.map(userEntity, UserDTO.class);
		}

		return null;
	}

	@Override
	public UserDTO saveUser(UserDTO userDto) {
		UserEntity userEntity = mapper.map(userDto, UserEntity.class);
		UserEntity userSaved = repository.save(userEntity);
		return mapper.map(userSaved, UserDTO.class);
	}

	@Override
	public UserDTO updateUser(Long id, UserDTO userDto) {
		if (this.isExist(id)) {
			UserEntity updaEntity = mapper.map(userDto, UserEntity.class);
			updaEntity.setId(id);
			return mapper.map(repository.save(updaEntity), UserDTO.class);

		}
		return null;
	}

	@Override
	public void deleteUser(Long id) {
		if (this.isExist(id)) {
			repository.deleteById(id);
		}
	}

	private boolean isExist(Long id) {
		Optional<UserEntity> userEntity = repository.findById(id);
		return userEntity.isPresent();
	}

}
