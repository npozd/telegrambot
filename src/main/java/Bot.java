import org.telegram.telegrambots.api.methods.AnswerCallbackQuery;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;
import com.mongodb.*;
import java.util.ArrayList;
import java.util.List;

public class Bot extends TelegramLongPollingBot {

    /**
     * Метод для приема сообщений.
     * @param update Содержит сообщение от пользователя.
     */
    @Override
    public void onUpdateReceived(Update update) {
        if(update.hasMessage()) {
            ThreadClass thread = new ThreadClass(update.getMessage());
        } else  if(update.hasCallbackQuery()) {
            AnswerCallbackThread answerThread = new AnswerCallbackThread(update.getCallbackQuery());
        }




//        if (update.hasMessage() && update.getMessage().hasText()) {
//        String message = update.getMessage().getText();
//        String chatId = update.getMessage().getChatId().toString();
//
//  //      sendMsg(chatId, MongoDriver.findMatchesInDb(message));
//        sendMsg(update.getMessage().getChatId().toString(), message);
  //      sendMsg(update.getMessage().getChatId().toString(), message + "\n" + "Order to " + update.getMessage().getFrom().getFirstName() + " " + update.getMessage().getFrom().getLastName() + " In Progress");


        }
    }

    /**
     * Метод для настройки сообщения и его отправки.
     * @param chatId id чата
     * @param s Строка, которую необходимот отправить в качестве сообщения.
     */
    public synchronized void sendMsg(String chatId, String s) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(chatId);
        sendMessage.setText(s);
        setInline();
        setButtons(sendMessage);
        answerCallbackQuery("17",s);

        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод возвращает имя бота, указанное при регистрации.
     * @return имя бота
     */
    @Override
    public String getBotUsername() {
        return "CyprusHelpBot";
    }

    /**
     * Метод возвращает token бота для связи с сервером Telegram
     * @return token для бота
     */
    @Override
    public String getBotToken() {
        return "662010143:AAEJ9lVySa8dKXJ83sksAQ1mDex54Tw_vH8";
    }

    public synchronized void setButtons(SendMessage sendMessage) {
        // Создаем клавиуатуру
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);

        // Создаем список строк клавиатуры
        List<KeyboardRow> keyboard = new ArrayList<>();

        // Первая строчка клавиатуры
        KeyboardRow keyboardFirstRow = new KeyboardRow();
        // Добавляем кнопки в первую строчку клавиатуры
        keyboardFirstRow.add(new KeyboardButton("Building, construction"));

        // Вторая строчка клавиатуры
        KeyboardRow keyboardSecondRow = new KeyboardRow();
        // Добавляем кнопки во вторую строчку клавиатуры
        keyboardSecondRow.add(new KeyboardButton("Childcare"));

        // Вторая строчка клавиатуры
        KeyboardRow keyboard3Row = new KeyboardRow();
        // Добавляем кнопки во вторую строчку клавиатуры
        keyboard3Row.add(new KeyboardButton("Clothing"));

        KeyboardRow keyboard4Row = new KeyboardRow();
        // Добавляем кнопки во вторую строчку клавиатуры
        keyboard4Row.add(new KeyboardButton("Design, photo, copy, scan, print"));

        KeyboardRow keyboard5Row = new KeyboardRow();
        // Добавляем кнопки во вторую строчку клавиатуры
        keyboard5Row.add(new KeyboardButton("Entertainment"));

        KeyboardRow keyboard6Row = new KeyboardRow();
        // Добавляем кнопки во вторую строчку клавиатуры
        keyboard6Row.add(new KeyboardButton("Finance, legal"));

        KeyboardRow keyboard7Row = new KeyboardRow();
        // Добавляем кнопки во вторую строчку клавиатуры
        keyboard7Row.add(new KeyboardButton("Food, drink"));

        KeyboardRow keyboard8Row = new KeyboardRow();
        // Добавляем кнопки во вторую строчку клавиатуры
        keyboard8Row.add(new KeyboardButton("IT, computers, telecoms"));

        KeyboardRow keyboard9Row = new KeyboardRow();
        // Добавляем кнопки во вторую строчку клавиатуры
        keyboard9Row.add(new KeyboardButton("Pets"));

        KeyboardRow keyboard10Row = new KeyboardRow();
        // Добавляем кнопки во вторую строчку клавиатуры
        keyboard10Row.add(new KeyboardButton("Property, maintenance"));

        KeyboardRow keyboard11Row = new KeyboardRow();
        // Добавляем кнопки во вторую строчку клавиатуры
        keyboard11Row.add(new KeyboardButton("Transport, moving, repairing"));

        KeyboardRow keyboard12Row = new KeyboardRow();
        // Добавляем кнопки во вторую строчку клавиатуры
        keyboard12Row.add(new KeyboardButton("Travel, tourism"));

        KeyboardRow keyboard13Row = new KeyboardRow();
        // Добавляем кнопки во вторую строчку клавиатуры
        keyboard13Row.add(new KeyboardButton("Tuition, classes"));

        KeyboardRow keyboard14Row = new KeyboardRow();
        // Добавляем кнопки во вторую строчку клавиатуры
        keyboard14Row.add(new KeyboardButton("Weddings"));

        KeyboardRow keyboard15Row = new KeyboardRow();
        // Добавляем кнопки во вторую строчку клавиатуры
        keyboard15Row.add(new KeyboardButton("Other"));

        // Добавляем все строчки клавиатуры в список
        keyboard.add(keyboardFirstRow);
        keyboard.add(keyboardSecondRow);
        keyboard.add(keyboard4Row);
        keyboard.add(keyboard5Row);
        keyboard.add(keyboard6Row);
        keyboard.add(keyboard7Row);
        keyboard.add(keyboard8Row);
        keyboard.add(keyboard9Row);
        keyboard.add(keyboard10Row);
        keyboard.add(keyboard11Row);
        keyboard.add(keyboard12Row);
        keyboard.add(keyboard13Row);
        keyboard.add(keyboard14Row);
        keyboard.add(keyboard15Row);

        // и устанваливаем этот список нашей клавиатуре
        replyKeyboardMarkup.setKeyboard(keyboard);
    }

    private void setInline() {
        List<List<InlineKeyboardButton>> buttons = new ArrayList<>();
        List<InlineKeyboardButton> buttons1 = new ArrayList<>();
        buttons1.add(new InlineKeyboardButton().setText("Кнопка").setCallbackData("17"));
        buttons.add(buttons1);

        InlineKeyboardMarkup markupKeyboard = new InlineKeyboardMarkup();
        markupKeyboard.setKeyboard(buttons);
    }

    public synchronized void answerCallbackQuery(String callbackId, String message) {
        AnswerCallbackQuery answer = new AnswerCallbackQuery();
        answer.setCallbackQueryId(callbackId);
        answer.setText(message);
        answer.setShowAlert(true);
        try {
            answerCallbackQuery(answer);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }


}
