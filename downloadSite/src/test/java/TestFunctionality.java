import CountUniqueWords.CounterUniqueWords;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Тут осталось дописать нормальные тесты и стереть, что не нужно
public class TestFunctionality {
    private String pageText = "привет что чт прив чт прив яблоко";
    private CounterUniqueWords cuw;

    @Before
    public void setUp() {

        cuw = new CounterUniqueWords(pageText);
        cuw.perform();

    }

    @Test
    public void testDislpayData() throws IOException {
        main.main(new String[]{"https://codeforces.com/"});
//        cuw.getResult();
    }

    @Test
    public void justTest() {
        String text = "asd";
        String reg = "\\<.*?>";
        //Pattern pattern = Pattern.compile(reg);
        String newtext = text.replaceAll(reg,"");
        System.out.println(newtext);
    }

    @Test
    public void testRegExp() {
        String s = "приветИгорь, я Ива2н! Ubah";
        String s1 = "hel111o или, чт1о НаДо! теБе hi";
        String petya = "петя";
        Pattern pattern = Pattern.compile("([а-яёА-ЯЁ]*|[a-zA-Z]*)");
        Matcher matcher = pattern.matcher("helloфвыd");
        if (matcher.matches())
            System.out.print(matcher.group() + "__");
    }

    @Test
    public void splitTest() {
    }

}
