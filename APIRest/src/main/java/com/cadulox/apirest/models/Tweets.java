package com.cadulox.apirest.models;

import java.util.UUID;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table
public class Tweets {

	@PrimaryKey
	private UUID tweet_id;
	private Integer followers;
	private String requested_at;
	private String tweet_date;
	private String message;
	private String tag;
	private String user;
	
	public Tweets() {
	}

	public Tweets(UUID tweet_id, Integer followers, String requested_at, String tweet_date, String message, String tag,
			String user) {
		this.tweet_id = tweet_id;
		this.followers = followers;
		this.requested_at = requested_at;
		this.tweet_date = tweet_date;
		this.message = message;
		this.tag = tag;
		this.user = user;
	}

	public UUID getTweet_id() {
		return tweet_id;
	}

	public void setTweet_id(UUID tweet_id) {
		this.tweet_id = tweet_id;
	}

	public Integer getFollowers() {
		return followers;
	}

	public void setFollowers(Integer followers) {
		this.followers = followers;
	}

	public String getRequested_at() {
		return requested_at;
	}

	public void setRequested_at(String requested_at) {
		this.requested_at = requested_at;
	}

	public String getTweet_date() {
		return tweet_date;
	}

	public void setTweet_date(String tweet_date) {
		this.tweet_date = tweet_date;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((tweet_id == null) ? 0 : tweet_id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tweets other = (Tweets) obj;
		if (tweet_id == null) {
			if (other.tweet_id != null)
				return false;
		} else if (!tweet_id.equals(other.tweet_id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Tweets [tweet_id=" + tweet_id + ", followers=" + followers + ", requested_at=" + requested_at
				+ ", tweet_date=" + tweet_date + ", message=" + message + ", tag=" + tag + ", user=" + user + "]";
	}		
}
