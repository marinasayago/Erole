package com.erole.moviErole.service;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erole.moviErole.model.Comment;
import com.erole.moviErole.model.User;
import com.erole.moviErole.repository.CommentRepository;

@Service
public class CommentService {
	@Autowired
	CommentRepository commentRep;
	@Autowired
	UserServiceImp userServ;
	
	public List<Comment> getCommentsFromContent(String id){
		List<Comment> comments = new LinkedList<Comment>();
		for(Comment c : commentRep.findAll()) {
			if(c.getContentId().equals(id)) comments.add(c);
		}
		return comments;
	}
	
	public void saveComment(Comment comment) {
		comment.setDate(new Date());
		commentRep.saveAndFlush(comment);
	}
	
	public void deleteAllComments(User user) {
		List<Comment> comments = commentRep.findAll();
		for(int i = 0; i < comments.size(); i++) {
			Comment c = comments.get(i);
			if (c.getUser().equals(user)) {
				commentRep.delete(c);
			}
		}
	}
	
	public void deleteComment(Integer id) {
		commentRep.deleteById(id);
	}
}
