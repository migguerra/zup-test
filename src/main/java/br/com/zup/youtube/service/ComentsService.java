package br.com.zup.youtube.service;

import java.util.List;

import br.com.zup.youtube.dto.ComentsDTO;

public interface ComentsService {

	public ComentsDTO saveComentario(Long idUser, Long idVideo, ComentsDTO userDTO);

	public ComentsDTO updateComentario(Long id, ComentsDTO userDTO);

	public void deleteComent(Long id);

	public List<ComentsDTO> findByVideo(Long idVideo);

	public List<ComentsDTO> findByUser(Long idUser);

}
