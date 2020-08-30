package br.com.zup.youtube.dto;

import java.io.Serializable;

public class VideoInputDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;

	private String name;

	private String duration;

	private Long view;

	private Long likeVideo;

	private Long deslikeVideo;

	private String url;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public Long getView() {
		return view;
	}

	public void setView(Long view) {
		this.view = view;
	}

	public Long getLikeVideo() {
		return likeVideo;
	}

	public void setLikeVideo(Long likeVideo) {
		this.likeVideo = likeVideo;
	}

	public Long getDeslikeVideo() {
		return deslikeVideo;
	}

	public void setDeslikeVideo(Long deslikeVideo) {
		this.deslikeVideo = deslikeVideo;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
