package max.ua;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.net.URL;


public class Parser {

    public static String getPage() throws Exception {

        String url_BTC = "https://coinmarketcap.com/currencies/bitcoin/";
        Document page_BTC = Jsoup.parse(new URL(url_BTC), 3000);
        Elements names_BTC = page_BTC.select("div[class=priceValue___11gHJ]");

        String url_ETH = "https://coinmarketcap.com/currencies/ethereum/";
        Document page_ETH = Jsoup.parse(new URL(url_ETH), 3000);
        Elements names_ETH = page_ETH.select("div[class=priceValue___11gHJ]");

        String url_XRP = "https://coinmarketcap.com/currencies/xrp/";
        Document page_XRP = Jsoup.parse(new URL(url_XRP), 3000);
        Elements names_XRP = page_XRP.select("div[class=priceValue___11gHJ]");

        String url_TWT = "https://coinmarketcap.com/currencies/trust-wallet-token/";
        Document page_TWT = Jsoup.parse(new URL(url_TWT), 3000);
        Elements names_TWT = page_TWT.select("div[class=priceValue___11gHJ]");

        String url_BNB = "https://coinmarketcap.com/currencies/binance-coin/";
        Document page_BNB = Jsoup.parse(new URL(url_BNB), 3000);
        Elements names_BNB = page_BNB.select("div[class=priceValue___11gHJ]");

        String TWT = "";
        String dateString_TWT = "";
            for (Element name_TWT : names_TWT) {
                dateString_TWT = name_TWT.select("div[class=priceValue___11gHJ]").text();
                TWT = dateString_TWT;
            }

        String BNB = "";
        String dateString_BNB = "";
                for (Element name_BNB : names_BNB) {
                    dateString_BNB = name_BNB.select("div[class=priceValue___11gHJ]").text();
                    BNB = dateString_BNB;
                }

        String BTC = "";
        String dateString_BTC = "";
                for (Element name_BTC : names_BTC) {
                    dateString_BTC = name_BTC.select("div[class=priceValue___11gHJ]").text();
                    BTC = dateString_BTC;
                }

        String ETH = "";
        String dateString_ETH = "";
                for (Element name_ETH : names_ETH) {
                    dateString_ETH = name_ETH.select("div[class=priceValue___11gHJ]").text();
                    ETH = dateString_ETH;
                }

        String dateString_XRP = "";
        String XRP = "";
                for (Element name_XRP : names_XRP) {
                    dateString_XRP = name_XRP.select("div[class=priceValue___11gHJ]").text();
                    XRP = dateString_XRP;
                }

        String BitcoinList = "";
        BitcoinList = "1. " + "BTC " + BTC + "\n" +
                      "2. " + "ETH " + ETH + "\n" +
                      "3. " + "XRP " + XRP + "\n" +
                      "4. " + "BNB " + BNB + "\n" +
                      "5. " + "TWT " + TWT + "\n";
                      return BitcoinList;
        }
    }






