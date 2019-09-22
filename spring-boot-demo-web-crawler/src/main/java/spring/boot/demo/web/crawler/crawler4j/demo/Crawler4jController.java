package spring.boot.demo.web.crawler.crawler4j.demo;

import java.util.HashSet;

import org.apache.http.message.BasicHeader;

import edu.uci.ics.crawler4j.crawler.CrawlConfig;
import edu.uci.ics.crawler4j.crawler.CrawlController;
import edu.uci.ics.crawler4j.fetcher.PageFetcher;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtConfig;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtServer;

public class Crawler4jController {
    public static void main(String[] args) throws Exception {
        String crawlStorageFolder = "crawler";// 定义爬虫数据存储位置
        int numberOfCrawlers = 7;// 定义了7个爬虫，也就是7个线程
        int pageNum = 1;   // 设置爬取页数

//        CrawlConfig config = new CrawlConfig();// 定义爬虫配置
//        config.setCrawlStorageFolder(crawlStorageFolder);// 设置爬虫文件存储位置
//
//        /*
//         * 实例化爬虫控制器。
//         */
//        PageFetcher pageFetcher = new PageFetcher(config);// 实例化页面获取器
//        RobotstxtConfig robotstxtConfig = new RobotstxtConfig();// 实例化爬虫机器人配置
//        // 实例化爬虫机器人对目标服务器的配置，每个网站都有一个robots.txt文件
//        // 规定了该网站哪些页面可以爬，哪些页面禁止爬，该类是对robots.txt规范的实现
//        RobotstxtServer robotstxtServer = new RobotstxtServer(robotstxtConfig, pageFetcher);
//        // 实例化爬虫控制器
//        CrawlController controller = new CrawlController(config, pageFetcher, robotstxtServer);
//
//        /*
//         * 对于每次抓取，您需要添加一些种子网址。 这些是抓取的第一个URL，然后抓取工具开始跟随这些页面中的链接
//         */
////        controller.addSeed("http://www.ics.uci.edu/~lopes/");
//        controller.addSeed("http://tieba.baidu.com/f/search/");
//        controller.addSeed("http://tieba.baidu.com/");
//
//        /**
//         * 启动爬虫，爬虫从此刻开始执行爬虫任务，根据以上配置
//         */
//        controller.start(Crawler4jDemo.class, numberOfCrawlers);


        CrawlConfig config = new CrawlConfig();

        config.setFollowRedirects(false);
        config.setCrawlStorageFolder(crawlStorageFolder);
        config.setUserAgentString("https://github.com/yasserg/crawler4j/");
        /*
         * 深度，即从入口URL开始算，URL是第几层。如入口A是1，从A中找到了B，B中又有C，则B是2，C是3
         */
        config.setMaxDepthOfCrawling(0);
        /*
         * 最多爬取多少个页面
         */
//        config.setMaxPagesToFetch(100000000);
        // 默认crawler4j每次请求前等待200毫秒
        config.setPolitenessDelay(200);

        HashSet<BasicHeader> collections = new HashSet<BasicHeader>();
        // User-agent字符串用于向web服务器表明你的爬虫。User-agent详解。 默认情况下crawler4j使用如下字符串： “crawler4j (https://github.com/yasserg/crawler4j/)”
        collections.add(new BasicHeader("User-Agent","Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/62.0.3192.0 Safari/537.36"));
        collections.add(new BasicHeader("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8"));
        collections.add(new BasicHeader("Accept-Encoding", "gzip,deflate,sdch"));
        collections.add(new BasicHeader("Accept-Language", "zh-CN,zh;q=0.8,en;q=0.6"));
        collections.add(new BasicHeader("Content-Type","application/x-www-form-urlencoded;charset=UTF-8"));
        collections.add(new BasicHeader("Connection", "keep-alive"));
        collections.add(new BasicHeader("Cookie", "bid=fp-BlwmyeTY; __yadk_uid=dLpMqMsIGD1N38NzhbcG3E6QA33NQ9bE; ps=y; _pk_ref.100001.8cb4=%5B%22%22%2C%22%22%2C1506515077%2C%22https%3A%2F%2Faccounts.douban.com%2Flogin%3Falias%3D793890838%2540qq.com%26redir%3Dhttps%253A%252F%252Fwww.douban.com%26source%3DNone%26error%3D1013%22%5D; ll=\"108296\"; ue=\"793890838@qq.com\"; __utmt=1; _ga=GA1.2.388925103.1505404043; _gid=GA1.2.1409223546.1506515083; dbcl2=\"161927939:ZDwWtUnYaH4\"; ck=rMaO; ap=1; push_noty_num=0; push_doumail_num=0; __utma=30149280.388925103.1505404043.1506510959.1506515077.8; __utmb=30149280.22.9.1506516374528; __utmc=30149280; __utmz=30149280.1506510959.7.5.utmcsr=accounts.douban.com|utmccn=(referral)|utmcmd=referral|utmcct=/login; __utmv=30149280.16192; _pk_id.100001.8cb4=1df4f52fdf296b72.1505404042.8.1506516380.1506512502.; _pk_ses.100001.8cb4=*"));
        config.setDefaultHeaders(collections);
//        /*
//         * Instantiate the controller for this crawl.
//         */
//        PageFetcher pageFetcher = new PageFetcher(config);
//        RobotstxtConfig robotstxtConfig = new RobotstxtConfig();
//        RobotstxtServer robotstxtServer = new RobotstxtServer(robotstxtConfig, pageFetcher);
//
//        // CrawController 控制爬虫，先addseed，再开启多个爬虫，并不断监听各个爬虫存活状态
//        CrawlController controller = new CrawlController(config, pageFetcher, robotstxtServer);

        /*
         * 实例化爬虫控制器
         */
        PageFetcher pageFetcher = new PageFetcher(config); // 实例化页面获取器
        RobotstxtConfig robotstxtConfig = new RobotstxtConfig(); // 实例化爬虫机器人配置 比如可以设置 user-agent

        // 实例化爬虫机器人对目标服务器的配置，每个网站都有一个robots.txt文件 规定了该网站哪些页面可以爬，哪些页面禁止爬，该类是对robots.txt规范的实现
        RobotstxtServer robotstxtServer = new RobotstxtServer(robotstxtConfig, pageFetcher);
        // 实例化爬虫控制器
        CrawlController controller = new CrawlController(config, pageFetcher, robotstxtServer);

        /*
         * For each crawl, you need to add some seed urls. These are the first
         * URLs that are fetched and then the crawler starts following links
         * which are found in these pages
         */
//        controller.addSeed("https://tieba.baidu.com/");
//        controller.addSeed("https://tieba.baidu.com/p/*.html");
        controller.addSeed("https://tieba.baidu.com/f?kw=%E5%89%91%E7%BD%91%E4%B8%89%E4%BA%A4%E6%98%93&fr=index");
//        for (int i = 0; i < pageNum; i ++) {
//            controller.addSeed("https://tieba.baidu.com/f?kw=%E5%89%91%E7%BD%91%E4%B8%89%E4%BA%A4%E6%98%93&ie=utf-8&pn=" + 50 * i);
//        }
//        controller.addSeed("https://tieba.baidu.com/f?kw=%E5%89%91%E7%BD%91%E4%B8%89%E4%BA%A4%E6%98%93&ie=utf-8&pn=50");


        /*
         * Start the crawl. This is a blocking operation, meaning that your code
         * will reach the line after this only when crawling is finished.
         */
        controller.start(Crawler4jDemo.class, numberOfCrawlers);
    }
}
