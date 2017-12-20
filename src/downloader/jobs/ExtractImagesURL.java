package downloader.jobs;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class ExtractImagesURL {

    public static ArrayList<String> getURLs(String pageURL) throws IOException
    {
        Document doc = Jsoup.parse(new URL(pageURL), 10000);
        Elements images = doc.getElementsByTag("img");

        ArrayList<String> urls = new ArrayList<>();

        for (Element e : images)
        {
            if (e.attr("src").substring(0,4).equals("http"))
                urls.add(e.attr("src"));
        }

        return urls;


    }

    public static void main(String[] args) {
        try {
            System.out.println(getURLs("https://vnexpress.net/"));
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }


}
