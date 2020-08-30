package br.com.zup.youtube.dto;

import br.com.zup.youtube.model.UserEntity;
import br.com.zup.youtube.model.VideoEntity;

public class ComentarioDTO {

	private Long id;

	private String comentario;

	private VideoEntity video;

	private UserEntity user;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public VideoEntity getVideo() {
		return video;
	}

	public void setVideo(VideoEntity video) {
		this.video = video;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

}
