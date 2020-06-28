
import CountUniqueWords.CounterUniqueWords;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import DownloadHTMLPage.DownlaodPage;

import java.io.File;
import java.io.IOException;
import java.lang.annotation.Documented;

public class main {
    static int c = 1;

    public static void main(String[] args) throws IOException {


        String link = "https://www.simbirsoft.com/";
        File out = new File("C:\\Users\\Daniil\\Desktop\\JavaTutorial"+2+".html");
        new Thread(new DownlaodPage(link, out)).start();
        c++;

        Document doc = Jsoup.connect(link).get();
        String text = doc.text();
//        Document doc = Jsoup.connect(link).get();
//        Elements imges = doc.getElementsByTag("img");
//
        CounterUniqueWords cuw = new CounterUniqueWords(text);
        cuw.perform();
        cuw.getResult();
    }
}
