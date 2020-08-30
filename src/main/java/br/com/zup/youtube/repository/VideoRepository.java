package br.com.zup.youtube.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zup.youtube.model.VideoEntity;

public interface VideoRepository extends JpaRepository<VideoEntity, Long> {

}
