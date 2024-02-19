package View;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ViewData {
    private final SimpleDateFormat date;

    public ViewData() {
        String datePattern = "dd.MM.yyyy HH:mm:ss";
        date = new SimpleDateFormat(datePattern);
    }

    /** Вывод сообщения с указанием даты
     *
     * @param message сообщение
     */
    public void writeLog(String message) {
        String currentDate = date.format(new Date());
        System.out.println(currentDate+ " " + message);

    }
    /** Вывод сообщения
     *
     * @param message сообщение для вывода
     */
    public void writeMessage(String message) {
        System.out.println(message);
    }

}
