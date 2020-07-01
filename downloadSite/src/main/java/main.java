
import CountUniqueWords.CounterUniqueWords;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import DownloadHTMLPage.DownlaodPage;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import org.apache.log4j.Logger;

/**
 * Остаётся доделать нормальное логгирование: логировать в файлы, настроить логи
 * GitHub: Залить проект на гитхаб, пока не понятно  для чего, ведь задание скидывается по почте в архиве
 * Тесты: написать нормальные юнит-тесты
 * Документирование/ комментирование: закомментировать важные функции, классы, чтобы было понятно,
 * что делает каждый метод/класс. Написать о программе, как пользоваться. Чтобы было понтно, что происходит,
 * куда передавать ссылку, куда скачивается страница, где файлы с логами, какие тесты используются и т.д.
 * */

public class main {
    private static final Logger LOGGER = Logger.getLogger(main.class.getName());

    public static void main(String[] args) throws IOException {

        LOGGER.info("\nНачало работы программы");

        /** Ввод ссылки пользователя */
        Scanner scanner = new Scanner(System.in);
//        String link = scanner.nextLine();
        String link = "https://www.simbirsoft.com/";
        String msg = String.format("Введена ссылка %s", link);
        LOGGER.info(msg);

        /** Скачивание веб-страницы */
        String path = "downloaded web-pages\\givenLink.html";
        File out = new File(path);
        new Thread(new DownlaodPage(link, out)).start();
        LOGGER.info( "Веб-страница скачалась");


        /** Выделение текста из веб-страницы */
        Document doc = Jsoup.connect(link).get();
        LOGGER.info("Сформирован Jsoup document с DOC деревом");
        String tt = doc.text();
        LOGGER.info("Взят и выделен html-код");
        String text = Jsoup.parse(tt).text();
        LOGGER.info("Выполнен парсинг текста на веб-странице");


        //Files.write(Paths.get("g1venLink.html"), doc.toString().getBytes(), StandardOpenOption.CREATE_NEW);

        /** Подсчитывание уникальных слов в тексте веб-страницы */
        CounterUniqueWords cuw = new CounterUniqueWords(text);
        LOGGER.info("Запуск метода подсчёта слов");
        new Thread(cuw).start();
        LOGGER.info("Подсчёт слов окончен");

        LOGGER.info("Конец работы программы");
    }
}
