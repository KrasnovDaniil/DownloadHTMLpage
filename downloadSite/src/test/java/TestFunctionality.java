import CountUniqueWords.CounterUniqueWords;
import org.junit.Before;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestFunctionality {
    private String pageText = "привет что чт прив чт прив яблоко";
    private CounterUniqueWords cuw;

    @Before
    public void setUp(){
        cuw = new CounterUniqueWords(pageText);
        cuw.perform();

    }

    @Test
    public void testDislpayData(){
        cuw.getResult();
    }

    @Test
    public void justTest(){
        cuw.printData();
    }

    @Test
    public void testRegExp(){
        String s = "приветИгорь, я Ива2н! Ubah";
        String s1 = "hel111o или, чт1о НаДо! теБе hi";
        String petya = "петя";
        Pattern pattern = Pattern.compile("([а-яёА-ЯЁ]*|[a-zA-Z]*)");
        Matcher matcher = pattern.matcher("helloфвыd");
        if(matcher.matches())
            System.out.print(matcher.group()+"__");
    }

    // {' |,|.|!|?|\"|;|:|[|]|(|)|\\n|\\r|\\t'}
    @Test
    public void splitTest(){
        B a = new B();
    }

}

class A{
    {
        System.out.println("A IIB");
    }
    A(){
        System.out.println("A ctor");
    }
}

class B extends A{
    {
        System.out.println("B IIB");
    }
    B(){
        System.out.println("B ctor");
    }
}