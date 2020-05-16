package services;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

public class ItaChallengeBotService extends TelegramLongPollingBot {

	public void onUpdateReceived(Update update) {

		String tag = update.getMessage().getText();
		TwitterService.getTweets(tag);
	}

	public String getBotUsername() {
		return "ItaChallengeBot";
	}

	@Override
	public String getBotToken() {
		return "token";
	}

}
