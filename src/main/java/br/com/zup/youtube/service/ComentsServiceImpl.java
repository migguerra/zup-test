package br.com.zup.youtube.service;

import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.zup.youtube.dto.ComentsDTO;
import br.com.zup.youtube.model.ComentsEntity;
import br.com.zup.youtube.model.UserEntity;
import br.com.zup.youtube.model.VideoEntity;
import br.com.zup.youtube.repository.ComentsRepository;
import br.com.zup.youtube.repository.UserRepository;
import br.com.zup.youtube.repository.VideoRepository;

@Service
public class ComentsServiceImpl implements ComentsService {

	@Autowired
	private ComentsRepository repository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private VideoRepository videoRepository;

	private ModelMapper mapper = new ModelMapper();

	@Override
	public ComentsDTO saveComentario(Long idUser, Long idVideo, ComentsDTO comentsDto) {

		Optional<UserEntity> userEntity = userRepository.findById(idUser);
		Optional<VideoEntity> videoEntity = videoRepository.findById(idVideo);

		if (userEntity.isPresent() && videoEntity.isPresent()) {

			ComentsEntity comentsEntity = mapper.map(comentsDto, ComentsEntity.class);
			comentsEntity.setUser(userEntity.get());
			comentsEntity.setVideo(videoEntity.get());

			ComentsEntity comentsSaved = repository.save(comentsEntity);

			return mapper.map(comentsSaved, ComentsDTO.class);

		}

		return null;
	}

	@Override
	public ComentsDTO updateComentario(Long id, ComentsDTO comentsDto) {
		if (repository.existsById(id)) {
			ComentsEntity comentsEntity = mapper.map(comentsDto, ComentsEntity.class);
			comentsEntity.setId(id);
			repository.save(comentsEntity);
		}

		return null;
	}

	@Override
	public void deleteComent(Long id) {
		repository.deleteById(id);
	}

	@Override
	public List<ComentsDTO> findByVideo(Long idVideo) {
		List<ComentsEntity> listComents = repository.findByVideoId(idVideo);
		List<ComentsDTO> listComentsDto = listComents.stream().map(coments -> mapper.map(coments, ComentsDTO.class))
				.collect(toList());
		return listComentsDto;
	}

	@Override
	public List<ComentsDTO> findByUser(Long idUser) {
		List<ComentsEntity> listComents = repository.findByUserId(idUser);
		List<ComentsDTO> listComentsDto = listComents.stream().map(coments -> mapper.map(coments, ComentsDTO.class))
				.collect(toList());
		return listComentsDto;
	}

}
