package com.erole.moviErole.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.erole.moviErole.model.Comment;

public interface CommentRepository extends JpaRepository<Comment, Integer>{

}
