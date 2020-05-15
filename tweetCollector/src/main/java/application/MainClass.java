package application;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

public class MainClass {

	public static void main(String[] args) {

		Twitter twitter = TwitterFactory.getSingleton();

		Query query = new Query("#desenvolvedor");
		query.setCount(100);
		QueryResult searchResult;

		try {
			searchResult = twitter.search(query);

			for (Status status : searchResult.getTweets()) {
				System.out.println("@" + status.getUser().getScreenName() + ":" + status.getText());
				System.out.println();
			}
		} catch (TwitterException e) {
			e.printStackTrace();
			System.out.println("Failed to search tweets: " + e.getMessage());
		}
	}

}
