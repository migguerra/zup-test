package br.com.zup.youtube.service;

import java.util.List;

import br.com.zup.youtube.dto.VideoInputDTO;
import br.com.zup.youtube.dto.VideoOutPutDTO;

public interface VideoService {

	public VideoOutPutDTO saveVideo(VideoInputDTO videoDTO, Long idUsaurio);

	public VideoOutPutDTO getVideo(Long id);

	public VideoOutPutDTO updateVideo(Long id, VideoInputDTO videoDTO);

	public void deleteVideo(Long id);

	public void likeVideo(Long id, Long numberLike, Long numberDeslike);

	public List<VideoOutPutDTO> getListVideoByUser(Long idUser);
}
