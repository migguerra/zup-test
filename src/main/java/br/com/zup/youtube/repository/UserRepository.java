package br.com.zup.youtube.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zup.youtube.model.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

}
