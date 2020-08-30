package br.com.zup.youtube.service;

import br.com.zup.youtube.dto.VideoInputDTO;
import br.com.zup.youtube.dto.VideoOutPutDTO;

public interface VideoService {

	public VideoOutPutDTO saveVideo(VideoInputDTO videoDTO, Long idUsaurio);

	public VideoOutPutDTO getVideo(Long id);

	public VideoOutPutDTO updateVideo(Long id, VideoInputDTO videoDTO);

	public void deleteVideo(Long id);

	public void likeVideo(Long id, Long numberLike);

	public void deslikeVideo(Long id, Long numberLike);
}
