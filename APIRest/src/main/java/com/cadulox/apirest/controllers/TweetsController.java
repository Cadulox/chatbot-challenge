package com.cadulox.apirest.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cadulox.apirest.models.Tweets;
import com.cadulox.apirest.services.TweetsService;

@RestController
@RequestMapping(value = "/tweets")
public class TweetsController {

	@Autowired
	private TweetsService service;

	@GetMapping
	public ResponseEntity<List<Tweets>> getAllTweets() {
		try {
			List<Tweets> tweets = new ArrayList<Tweets>();

			service.getAllTweets().forEach(tweets::add);

			if (tweets.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(tweets, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
