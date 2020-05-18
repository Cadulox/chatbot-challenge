package repositories;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.uuid.Uuids;

import twitter4j.Status;

public class TweetRepository {

	static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
	static TweetRepository client = new TweetRepository();

	public static void addTweet(List<Status> tweets, String tag) {
		try {
			client.connectSession();
			for (Status status : tweets) {
				StringBuilder sb = new StringBuilder("INSERT INTO chatbot.tweets ")
						.append("(user, followers, message, requested_at, tag, tweet_date, tweet_id)")
						.append("VALUES (")
						.append("'@").append(status.getUser().getScreenName()).append("', ")
						.append(status.getUser().getFollowersCount()).append(", '")
						.append(status.getText()).append("', '")
						.append(LocalDateTime.now().format(formatter)).append("', '")
						.append(tag).append("', '")
						.append(status.getCreatedAt()).append("', ")
						.append(Uuids.timeBased()).append(");");
				
				String query = sb.toString();						
				session.execute(query);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			client.closeSession();
		}
	}

	private static CqlSession session;

	private void connectSession() {
		session = CqlSession.builder().build();
	}

	private void closeSession() {
		if (session != null) {
			session.close();
		}
	}
}
