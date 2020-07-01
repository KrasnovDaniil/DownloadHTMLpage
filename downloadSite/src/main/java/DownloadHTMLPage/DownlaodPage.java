package DownloadHTMLPage;


import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.log4j.Logger;


public class DownlaodPage implements Runnable {
    String link;
    File out;
    static private final Logger LOGGER = Logger.getLogger(DownlaodPage.class.getName());

    public DownlaodPage(String link, File out) {
        this.link = link;
        this.out = out;
    }

    public void run() {
        LOGGER.info("Метод run() класса запущен " + DownlaodPage.class.getName());
        BufferedOutputStream bos = null;
        BufferedInputStream in = null;
        FileOutputStream fos;
        HttpURLConnection http;

        try {
            URL url = new URL(link);
            LOGGER.info("Ссылка " + link + " получена ");
            http = (HttpURLConnection) url.openConnection();
            LOGGER.info("Соединение установлено");

            in = new BufferedInputStream(http.getInputStream());
            fos = new FileOutputStream(this.out);
            bos = new BufferedOutputStream(fos, 1024);

            byte[] buffer = new byte[1024];
            int read = 0;
            while ((read = in.read(buffer, 0, 1024)) >= 0) {
                bos.write(buffer, 0, read);
            }
            LOGGER.info("Выполнена загрузка страницы в файл");

        } catch (IOException e) {
            e.printStackTrace();
            LOGGER.error("Ошибка при загрузке страницы");
        }
        finally {
            try {
                bos.close();
                in.close();
                LOGGER.info("Потоки ввода и вывода закрыты");
            } catch (IOException e) {
                /** Лог не подробный, так как потока всего два, и будет не трудно проверить каждый при отладке*/
                LOGGER.error("какой-то из потоков не закрыт ");
                e.printStackTrace();
            }
        }
    }

}
