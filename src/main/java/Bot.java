import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Bot {
    private static final Logger LOG = Logger.getLogger(Bot.class.getName());

    public static void main(String[] args) throws TelegramApiException {
        System.getProperties().put("proxySet", "true");
        System.getProperties().put("socksProxyHost", "127.0.0.1");
        System.getProperties().put("socksProxyPort", "9150");
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(new TelegramLongPollingBot() {
            @Override
            public String getBotToken() {
                return "1700687970:AAGu7_bBRavoJQ94hcWlDr04-fF8fpyHYx0";
            }

            @Override
            public void onUpdateReceived(Update update) {
                Message message = update.getMessage();
                Long chatId = message.getChatId();
                String input = message.getText();

                if ("/start_working".equals(input)) {
                    SendMessage request = new SendMessage();
                    request.setChatId(chatId.toString());
                    request.setText("Start working!");
                }

            }

            @Override
            public String getBotUsername() {
                return "Sbertester";
            }
        });
    }
}
