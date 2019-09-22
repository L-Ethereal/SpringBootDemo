package spring.boot.demo.web.crawler.crawler4j.demo;

import java.io.IOException;
import java.net.URL;
import java.util.Set;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Value;

import edu.uci.ics.crawler4j.crawler.Page;
import edu.uci.ics.crawler4j.crawler.WebCrawler;
import edu.uci.ics.crawler4j.parser.HtmlParseData;
import edu.uci.ics.crawler4j.url.WebURL;

public class Crawler4jDemo extends WebCrawler {

    @Value("${defaulturl}")
    private String defaultUrl;
    /**
     * 正则表达式匹配指定的后缀文件
     * 忽视有CSS，JS，git等的URL
     */
    private final static Pattern FILTERS = Pattern.compile(".*(\\.(css|js|gif|jpg" + "|png|mp3|mp3|zip|gz))$");
//    private final static Pattern START = Pattern.compile("(https://tieba.baidu.com/p/).*");


    private final Pattern keyWords_ONE = Pattern.compile("^(.)*(六红)+(.)*$");//关健词形成的正则表达式
    private final Pattern keyWords_TWO = Pattern.compile("^(.)*(黑金)+(.)*$");//关健词形成的正则表达式
    private final Pattern keyWords_THREE = Pattern.compile("^(.)*(一代黑)+(.)*$");//关健词形成的正则表达式


    /**
     * 是否抓取页面
     *
     * 根据url进行网页的解析，对返回为TRUE的网页进行抓取
     *
     * 这个方法主要是决定哪些url我们需要抓取，返回true表示是我们需要的，返回false表示不是我们需要的Url
     * 第一个参数referringPage封装了当前爬取的页面信息 第二个参数url封装了当前爬取的页面url信息
     * 在这个例子中，我们指定爬虫忽略具有css，js，git，...扩展名的url，只接受以“http://www.ics.uci.edu/”开头的url。
     * 在这种情况下，我们不需要referringPage参数来做出决定。
     */
    @Override
    public boolean shouldVisit(Page referringPage, WebURL webURL) {

        String url = webURL.getURL();
        String href = webURL.getURL().toLowerCase();//得到小写的url
        String anchor = webURL.getAnchor();//标题


        logger.info("url: {}", url);
        logger.info("href: {}", href);
        logger.info("anchor: {}", anchor);
        logger.info("WebURL" + webURL);

        //采集关健词不为空，而标题为空，则不采集
        if(null == anchor) {
            return false;
        }

        String title = ((HtmlParseData) referringPage.getParseData()).getTitle();

        boolean result = false;

        if (!FILTERS.matcher(href).matches()
//                && href.startsWith("https://tieba.baidu.com/p/")
                && keyWords_ONE.matcher(title).matches()
//                && keyWords_TWO.matcher(title).matches()
//                && keyWords_THREE.matcher(title).matches()
        ) {
            result = true;
        }

        return result;
//        return !FILTERS.matcher(href).matches()
//               // 正则匹配，过滤掉我们不需要的后缀文件
//               && isMatches
//               &&
//               START.matcher(href).matches()
//               &&
//               keyWordPattern.matcher(((HtmlParseData) referringPage.getParseData()).getTitle()).matches();
//               &&
//               (href.startsWith(
//                       "https://tieba.baidu.com/p/625698842")
//               || href.startsWith("https://tieba.baidu.com/p/6257059521")
//               ); // 只接受以“http://www.ics.uci.edu/”开头的url
    }

    /**
     * 解析网页内容，page类包含了丰富的方法，可以利用这些方法得到网页的内容和属性
     *
     * 当一个页面被提取并准备好被你的程序处理时，这个函数被调用。
     * 该功能在URL内容下载成功后调用。
     * 您可以轻松获取下载页面的网址，文本，链接，html和唯一ID。
     *
     * jsoup 是一款Java 的HTML解析器，可直接解析某个URL地址、HTML文本内容。它提供了一套非常省力的API，
     * 可通过DOM，CSS以及类似于jQuery的操作方法来取出和操作数据。
     */
    @Override
    public void visit(Page page) {
        String url = page.getWebURL().getURL();// 获取url
        String href = url.toLowerCase();
        System.out.println("URL: " + url);
        System.out.println("href : " + href);
        System.out.println("href : [ " + href + " ] startWith https://tieba.baidu.com/p/625698842 href startWith " + href.startsWith("https://tieba.baidu.com/p/625698842"));
        System.out.println("href : [ " + href + " ] startWith https://tieba.baidu.com/p/6257059521 href startWith " + href.startsWith("https://tieba.baidu.com/p/6257059521"));

        if (page.getParseData() instanceof HtmlParseData) {// 判断是否是html数据

            try {
                Document document = Jsoup.parse(new URL(url),60000);
                String html = document.toString();
            } catch (IOException e) {
                e.printStackTrace();
            }


            HtmlParseData htmlParseData = (HtmlParseData) page.getParseData();//// 强制类型转换，获取html数据对象
            String text = htmlParseData.getText();//获取页面纯文本（无html标签）
            String html = htmlParseData.getHtml();//获取页面Html
            Set<WebURL> links = htmlParseData.getOutgoingUrls();// 获取页面输出链接

            Document doc= Jsoup.parse(html);//将html解析成一个Document类
            Element body = doc.body();
            Elements allElements = body.select("body>*");
            Elements flagElements = body.getElementsByTag("a");
            Elements item = doc.select("div[class=threadlist_title pull_left j_th_tit]");
            Elements test = doc.select("div.threadlist_title pull_left j_th_tit");
            //使用选择器的时候需要了解网页中的html规则，自己去网页中F12一下，
            Elements content = doc.getElementsByClass("threadlist_title pull_left j_th_tit");
            Elements con = doc.select("div[AttrName=threadlist_title pull_left j_th_tit]");

            if (content.size()==0){
                return;
            }

            content.forEach(element -> {
                System.out.println("element.text : " + element.text());
                System.out.println("element.href : " + element.attr("href"));
            });

            System.out.println("Page : " + page);
            System.out.println("title : " + ((HtmlParseData) page.getParseData()).getTitle());
            System.out.println("纯文本长度: " + text.length());
            System.out.println("html长度: " + html.length());
            System.out.println("链接个数 " + links.size());
        }
    }

}
