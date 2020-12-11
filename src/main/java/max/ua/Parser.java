package max.ua;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;

public class Parser {

    public static Element getPage() throws IOException {
        String url = "http://htmlbook.ru/html/a/href";
        Document page = Jsoup.parse(new URL(url), 3000);
        Element table = page.select("p").first();

        return table;
    }
}
