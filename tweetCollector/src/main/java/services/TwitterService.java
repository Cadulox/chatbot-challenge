package services;

import java.util.List;

import repositories.TweetRepository;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

public class TwitterService {

	public static void getTweets(String tag) {
		TwitterFactory tf = new TwitterFactory();
		Twitter twitter = tf.getInstance();
		try {
			Query query = new Query(tag);
			query.setCount(100);
			query.setLang("pt");

			QueryResult searchResult;

			searchResult = twitter.search(query);
			List<Status> tweets = searchResult.getTweets();

			TweetRepository.addTweet(tweets, tag);
		} catch (TwitterException e) {
			e.printStackTrace();
			System.out.println("Failed to search tweets: " + e.getMessage());
		}
	}
}
