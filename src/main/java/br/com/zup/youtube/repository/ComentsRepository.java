package br.com.zup.youtube.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zup.youtube.model.ComentsEntity;

public interface ComentsRepository extends JpaRepository<ComentsEntity, Long> {

	public List<ComentsEntity> findByVideoId(Long id);

	public List<ComentsEntity> findByUserId(Long id);

}
