package Logic;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Arrays;

public class ParseService {

    public static Animal parseData(String type, String inputData){
        // строка вида "том, 23.02.20224, бег,прыг"
        String[] data = inputData.trim().split(",",3);
        System.out.println(Arrays.toString(data));
        return new Animal(data[0].trim(),type,parseDate(data[1].trim()),data[2].trim().toLowerCase());
    }

    /** Преобразование даты из строки в формат LocalDate
     *
     * @param inputDate дата в формате String
     * @return преобразованная дата в формате LocalDate
     */
    public static LocalDate parseDate(String inputDate) throws DateTimeException{
        if (checkDate(inputDate)){
            String[] date = inputDate.trim().split("\\.",3);
            try {
                return LocalDate.of(Integer.parseInt(date[2]),Integer.parseInt(date[1]),Integer.parseInt(date[0]));
            }catch (DateTimeException e){
                throw new DateTimeException("Неправильная дата " + inputDate);
            }
        } else throw new DateTimeException("Неправильный формат даты " + inputDate);
    }

    /**
     * Проверка формата даты
     * @param inputDate строка с датой в формате дд.мм.гггг
     * @return результат проверки
     */
    private static boolean checkDate(String inputDate){
        //return inputDate.contains(".") && inputDate.length() == 10;
        return inputDate.matches("^[0-9]{2}\\.[0-9]{2}\\.[0-9]{4}$");
    }

    private static boolean checkNormalDate(String inputDate){
        return inputDate.matches("^[0-9]{4}-[0-9]{2}-[0-9]{4}$");
    }

}
