import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class WebCrawler
{

    public static void main(String[] args)
    {
        Scanner imp = new Scanner(System.in);
        Document document;
        try
        {
            System.out.println("Enter website: (https://)");

            document = Jsoup.connect(imp.next()).get();

            String title = document.title();
            System.out.println("Title: " + title);

            Elements links = document.select("a[href]");
            ArrayList<String> linkList = new ArrayList<>();

            for (Element link : links)
            {
                String url = link.attr("href");
                System.out.println("Link: " + url);
                linkList.add(url);
            }


            System.out.println("Retrieved URLs:");
            for (String link : linkList)
            {
                System.out.println(link);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
