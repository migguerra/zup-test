package br.com.zup.youtube.service;

import static net.bytebuddy.utility.RandomString.make;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.zup.youtube.dto.VideoInputDTO;
import br.com.zup.youtube.dto.VideoOutPutDTO;
import br.com.zup.youtube.model.UserEntity;
import br.com.zup.youtube.model.VideoEntity;
import br.com.zup.youtube.repository.UserRepository;
import br.com.zup.youtube.repository.VideoRepository;

@Service
public class VideoServiceImpl implements VideoService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private VideoRepository videoRepository;

	private ModelMapper mapper = new ModelMapper();

	@Override
	public VideoOutPutDTO saveVideo(VideoInputDTO videoDTO, Long idUsaurio) {
		Optional<UserEntity> user = userRepository.findById(idUsaurio);

		if (user.isPresent()) {

			UserEntity userEntity = mapper.map(user, UserEntity.class);
			VideoEntity videoEntity = mapper.map(videoDTO, VideoEntity.class);

			videoEntity.setUser(userEntity);
			videoEntity.setUrl("http://youtube.com/" + make(10));

			VideoEntity videoSaved = videoRepository.save(videoEntity);

			return mapper.map(videoSaved, VideoOutPutDTO.class);

		}

		return null;
	}

	@Override
	public VideoOutPutDTO getVideo(Long id) {
		Optional<VideoEntity> videoEntity = videoRepository.findById(id);

		if (videoEntity.isPresent()) {
			VideoOutPutDTO videoDto = mapper.map(videoEntity, VideoOutPutDTO.class);
			return videoDto;
		}

		return null;
	}

	@Override
	public VideoOutPutDTO updateVideo(Long id, VideoInputDTO videoDTO) {
		return null;
	}

	@Override
	public void deleteVideo(Long id) {

	}

	@Override
	public void likeVideo(Long id, Long numberLike) {

	}

	@Override
	public void deslikeVideo(Long id, Long numberLike) {

	}

}
