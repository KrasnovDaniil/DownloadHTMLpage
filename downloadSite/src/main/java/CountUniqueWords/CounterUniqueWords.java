package CountUniqueWords;

import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
* Класс подсчёта уникальных слов в тексте
* */
public class CounterUniqueWords {

    private String[] text;
    private Map<String, Integer> uWords;
    private List<String> order;
    private String RegExp = "\\s|,|\\.|!|\\?|\"|;|:|[|]|\\(|\\)|\\n|\\r|\\t";
    public CounterUniqueWords(String text){
        this.text = text.split(RegExp);
        uWords = new HashMap<String, Integer>();
        order = new LinkedList<>();
    }

    /** Метод подсчёта уникальных слов */
    public void perform(){
        String regexpForWords = "([а-яё]*|[a-z]*)";
        Pattern pattern = Pattern.compile(regexpForWords);
        int newAmount;
        for(String word : text){
            word = word.toLowerCase();
            Matcher matcher = pattern.matcher(word);
            if(matcher.matches()) {
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

    /** Метод вывода на экран статистики распространения уникальных слов */
    public Map getResult(){
        ArrayList<String> result = new ArrayList<>();
        String a;
        Integer b;
        for(String item: order){
            System.out.println(item + " - " + uWords.get(item));
        }
        return uWords;
    }

    @Deprecated
    public void printData(){
        Iterator<Map.Entry<String, Integer>> itr = uWords.entrySet().iterator();
        while (itr.hasNext())
            System.out.println(itr.next());

    }
}
