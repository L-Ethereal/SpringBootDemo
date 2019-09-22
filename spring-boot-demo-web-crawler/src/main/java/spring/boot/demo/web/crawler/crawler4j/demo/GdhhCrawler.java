package spring.boot.demo.web.crawler.crawler4j.demo;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;
import org.testng.annotations.Test;
import org.testng.collections.Lists;

public class GdhhCrawler {

    private final Pattern keyWordPattern = Pattern.compile("^(.)*(我们)+(.)*$");
//    private final Pattern keyWordPattern = Pattern.compile("^*(我们)*$");
    @Test
    public void testPattern () {

//        String title = "你们他们——我们test_百度贴吧";
        String title = "我你们他——test_百度贴吧";

        boolean match = keyWordPattern.matcher(title).matches();

        System.out.println("title : " + title);
        System.out.println("match : " + match);
    }

    @Test
    public void testJsoup () throws IOException {
        String url = "https://tieba.baidu.com/f?kw=%E5%89%91%E7%BD%91%E4%B8%89%E4%BA%A4%E6%98%93&fr=index";
        Document document = Jsoup.parse(new URL(url), 60000);

        List<Node> nodeList = Lists.newArrayList();
        document.childNodes().forEach(node -> {
            if ("#comment".equals(node.nodeName())) {
                nodeList.add(node);
            }
        });

        System.out.println(nodeList);
    }

    @Test
    public void testPatternReplace () throws IOException {
        String regstr = "\\<!--(.+)--\\>";
        Pattern pattern = Pattern.compile(regstr,Pattern.CASE_INSENSITIVE);

        String url = "https://tieba.baidu.com/f?kw=%E5%89%91%E7%BD%91%E4%B8%89%E4%BA%A4%E6%98%93&fr=index";
        String html = Jsoup.parse(new URL(url), 60000).html();
        StringBuffer operatorStr = new StringBuffer(html);
        Matcher matcher = pattern.matcher(html);

//        while(matcher.find()) {
//            //使用分组进行替换
//            operatorStr.replace(matcher.start(2),matcher.end(2),"/");
//            m = p.matcher(operatorStr);
//        }
//        return operatorStr.toString();

        String result = html.replaceAll("<!--"," ");
        result = result.replaceAll("-->"," ");
//        private final Pattern keyWordPattern = Pattern.compile("^(.)*(<!--)+(.)*(-->)(.)*$");

        System.out.println(result);

        Document doc= Jsoup.parse(result);//将html解析成一个Document类
        Element body = doc.body();
        Elements allElements = body.select("body>*");
        Elements flagElements = body.getElementsByTag("a");
        Elements item = doc.select("div[class=threadlist_author pull_right]");
        Elements test = doc.select("div.threadlist_title pull_left j_th_tit");
        //使用选择器的时候需要了解网页中的html规则，自己去网页中F12一下，
        Elements content = doc.getElementsByClass("threadlist_title pull_left j_th_tit");
        Elements con = doc.select("div[AttrName=threadlist_title pull_left j_th_tit]");

    }
}
