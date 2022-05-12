package com.erole.moviErole.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erole.moviErole.model.Comment;
import com.erole.moviErole.repository.CommentRepository;

@Service
public class CommentService {
	@Autowired
	CommentRepository commentRep;
	
	public List<Comment> getCommentsFromContent(String id){
		List<Comment> comments = new LinkedList<Comment>();
		for(Comment c : commentRep.findAll()) {
			if(c.getContentId().equals(id)) comments.add(c);
		}
		return comments;
	}
}
