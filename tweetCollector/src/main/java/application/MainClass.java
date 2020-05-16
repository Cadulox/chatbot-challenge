package application;

import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import services.ItaChallengeBotService;

public class MainClass {

	public static void main(String[] args) {

		ApiContextInitializer.init();
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        try {
            telegramBotsApi.registerBot(new ItaChallengeBotService());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
	}

}
