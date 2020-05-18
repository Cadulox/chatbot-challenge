package com.cadulox.apirest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cadulox.apirest.models.Tweets;
import com.cadulox.apirest.repositories.TweetsRepository;

@Service
public class TweetsService {
	
	@Autowired
	private TweetsRepository repository;

	public List<Tweets> getAllTweets(){
		return repository.findAll();
	}
}
