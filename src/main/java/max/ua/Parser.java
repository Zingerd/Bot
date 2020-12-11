package max.ua;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.net.URL;


public class Parser {

    // private static Pattern pattern = Pattern.compile("\\D{8}\\s\\d\\D{4}\\s\\D\\d{2}\\W\\d{3}\\.\\d{2}\\s\\d\\.\\d{2}\\D");

    //    public static String getCut(String stringDate) throws  Exception {
//        Matcher matcher = pattern.matcher(stringDate);
//        if(matcher.find()) {
//            return  matcher.group();
//        }
//        throw new Exception("Can't extract date from string");
//    }
//
//    private static void printFourValues(Elements values, int index) {
//        for (int i = 0; i < 4; i++){
//            Element valueLine = values.get(index);
//        }
//    }
    public static String getPage() throws Exception {

        String url_BTC = "https://coinmarketcap.com/currencies/bitcoin/";
        Document page_BTC = Jsoup.parse(new URL(url_BTC), 3000);
        Elements names_BTC = page_BTC.select("span[class=cmc-details-panel-price__price]");

        String url_ETH = "https://coinmarketcap.com/currencies/ethereum/";
        Document page_ETH = Jsoup.parse(new URL(url_ETH), 3000);
        Elements names_ETH = page_ETH.select("span[class=cmc-details-panel-price__price]");

        String url_XRP = "https://coinmarketcap.com/currencies/xrp/";
        Document page_XRP = Jsoup.parse(new URL(url_XRP), 3000);
        Elements names_XRP = page_XRP.select("span[class=cmc-details-panel-price__price]");

        String url_TWT = "https://coinmarketcap.com/currencies/trust-wallet-token/";
        Document page_TWT = Jsoup.parse(new URL(url_TWT), 3000);
        Elements names_TWT = page_TWT.select("span[class=cmc-details-panel-price__price]");

        String url_BNB = "https://coinmarketcap.com/currencies/binance-coin/";
        Document page_BNB = Jsoup.parse(new URL(url_BNB), 3000);
        Elements names_BNB = page_BNB.select("span[class=cmc-details-panel-price__price]");

            String BitcoinList = "";
            String dateString_TWT = "";
            for (Element name_TWT : names_TWT) {
                dateString_TWT = name_TWT.select("span[class=cmc-details-panel-price__price]").text();
                String TWT = dateString_TWT;

                String dateString_BNB = "";
                for (Element name_BNB : names_BNB) {
                    dateString_BNB = name_BNB.select("span[class=cmc-details-panel-price__price]").text();
                    String BNB = dateString_BNB;

                    String dateString_BTC = "";
                    for (Element name_BTC : names_BTC) {
                        dateString_BTC = name_BTC.select("span[class=cmc-details-panel-price__price]").text();
                        String BTC = dateString_BTC;

                        String dateString_ETH = "";
                        for (Element name_ETH : names_ETH) {
                            dateString_ETH = name_ETH.select("span[class=cmc-details-panel-price__price]").text();
                            String ETH = dateString_ETH;

                            String dateString_XRP = "";
                            for (Element name_XRP : names_XRP) {
                                dateString_XRP = name_XRP.select("span[class=cmc-details-panel-price__price]").text();
                                String XRP = dateString_XRP;

                                BitcoinList = "1. " + "BTC " + BTC + "\n" +
                                        "2. " + "ETH " + ETH + "\n" +
                                        "3. " + "XRP " + XRP + "\n" +
                                        "4. " + "BNB " + BNB + "\n" +
                                        "5. " + "TWT " + TWT + "\n";

                            }
                        }
                    }
                }
            }
            return BitcoinList;
        }
    }
