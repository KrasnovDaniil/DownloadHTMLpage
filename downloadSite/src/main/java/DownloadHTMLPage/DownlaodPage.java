package DownloadHTMLPage;
import java.io.*;
import java.lang.annotation.Documented;
import java.net.HttpURLConnection;
import java.net.URL;


public class DownlaodPage implements Runnable {
    String link;
    File out;

    public DownlaodPage(String link, File out){
        this.link = link;
        this.out = out;
    }

    static{

    }
    public void run() {
        try{
            runTest();
            if(true) return;
            URL url = new URL(link);
            HttpURLConnection http = (HttpURLConnection)url.openConnection();
            double fileSize = (double)http.getContentLength();
            BufferedInputStream in = new BufferedInputStream(http.getInputStream());
            FileOutputStream fos = new FileOutputStream(this.out);
            BufferedOutputStream bos = new BufferedOutputStream(fos, 1024);
            byte[] buffer = new byte[1024];
            double downloaded = 0.00;
            int read = 0;
            double percentDwnld = 0.00;
            while((read = in.read(buffer,0,1024))>=0){
                bos.write(buffer,0,read);
                downloaded+=read;
                percentDwnld = (downloaded*100)/fileSize;
                //String perc = String.format("%.4f", percentDwnld);
                //System.out.println("downloaded " + perc +"% of file");
            }
            bos.close();
            in.close();
            System.out.println("download complete!");

        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    public void runTest() throws IOException{
        Tester tester = new Tester(link);
    }
}



class Tester {
    public Tester(String url) throws IOException{
        download(url);
    }

    public void download(String urlString) throws IOException {
        URL url = new URL(urlString);
        try(
                BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
                BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\Daniil\\Desktop\\JavaTutorial"+2+".html"));
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
            }
            System.out.println("Page downloaded.");
        }
    }
}