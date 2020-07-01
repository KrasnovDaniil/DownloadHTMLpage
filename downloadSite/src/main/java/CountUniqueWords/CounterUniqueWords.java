package CountUniqueWords;

import java.util.*;
import java.util.List;
import org.apache.log4j.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Класс подсчёта уникальных слов в тексте
 */
public class CounterUniqueWords implements Runnable{
    /**
     * Суть такова: в качестве параметра text подаётся текст на сайте, затем он разбивается на массив строк (слов),
     * далее регулярными выражениями выбираются слова, которые и подсчитываются.
     */
    private String[] text;
    private Map<String, Integer> uWords;
    private List<String> order;
    private String RegExp = "\\s|,|\\.|!|\\?|\"|;|:|[|]|\\(|\\)|\\n|\\r|\\t";
    private Logger LOGGER = Logger.getLogger(CounterUniqueWords.class.getName());

    public CounterUniqueWords(String text) {
        this.text = text.split(RegExp); // разбиение полученного текста на массив строк с учётом указанных разделителей
        uWords = new HashMap<>();   // хеш-таблица уникальных слов с их количеством
        order = new LinkedList<>(); // вспомогательыне список для порядка уникальных слов
        LOGGER.info("Получены данные в конструктор класса {0}" + CounterUniqueWords.class.getName());
    }


    public void run() {
        perform();
        getResult();

    }

    /**
     * Метод подсчёта уникальных слов
     */
    public void perform() {
        LOGGER.info("Начало подсчёта уник. слов");
        String regexpForWords = "([а-яё]*|[a-z]*)";
        Pattern pattern = Pattern.compile(regexpForWords);
        int newAmount;
        for (String word : text) {
            word = word.toLowerCase(); // все слова переводятся в нижний регистр для регистро независимого подсчёта слов
            Matcher matcher = pattern.matcher(word);
            if (matcher.matches()) {
                if (!uWords.containsKey(word)) {
                    uWords.put(word, 1);
                    order.add(word);
                } else {
                    newAmount = uWords.get(word) + 1;
                    uWords.put(word, newAmount);
                }
            }
        }
    }

    /**
     * Метод вывода на экран статистики распространения уникальных слов
     */
    public Map getResult() {
        LOGGER.info("Вывод на экран статистики");
        ArrayList<String> result = new ArrayList<>();
        String a;
        Integer b;
        for (String item : order) {
            System.out.println(item + " - " + uWords.get(item));
        }
        return uWords;
    }

    @Deprecated
    public void printData() {
        Iterator<Map.Entry<String, Integer>> itr = uWords.entrySet().iterator();
        while (itr.hasNext())
            System.out.println(itr.next());

    }
}
