package spring.boot.demo.web.crawler.webcollector.demo;

import org.jsoup.nodes.Document;

import cn.edu.hfut.dmic.webcollector.model.CrawlDatums;
import cn.edu.hfut.dmic.webcollector.model.Page;
import cn.edu.hfut.dmic.webcollector.plugin.berkeley.BreadthCrawler;

public class NewsCrawler extends BreadthCrawler {
    /**
     *
     * @param crawlPath
     *      CrawlPath是维护目录的路径  这是crawler的信息
     * @param autoParse
     *      true 代表如果可以自动解析,则BreadthCrawler会自动提取
     *      从这个页面用正则表达式去匹配链接
     *      这是一个构造函数
     */
    public NewsCrawler(String crawlPath, boolean autoParse) {
        super(crawlPath, autoParse);
        /*页面开始*/
        this.addSeed("https://tieba.baidu.com/f?kw=%E5%89%91%E7%BD%91%E4%B8%89%E4%BA%A4%E6%98%93&fr=index");

        /*获取像这样的http://news.hfut.edu.cn/show-xxxxxxhtmlurl*/
        this.addRegex("http://news.hfut.edu.cn/show-.*html");
        /*不获取这样的格式 jpg|png|gif*/
        this.addRegex("-.*\\.(jpg|png|gif).*");
        /*也不要这样的 #*/
        this.addRegex("-.*#.*");
    }

    @Override
    public void visit(Page page, CrawlDatums next) {
        String url = page.url();
        /*如果是一个新的页面*/
        if (page.matchUrl("http://news.hfut.edu.cn/show-.*html")) {
            /*用JSOUP去解析这个页面*/
            Document doc = page.doc();
            String html = page.html();
            /*的提取新闻和标题的css选择器*/
            String title = page.select("div[id=Article]>h2").first().text();
            String content = page.select("div#artibody", 0).text();

            System.out.println("URL:\n" + url);
            System.out.println("title:\n" + title);
            System.out.println("content:\n" + content);

            /*如果你想要抓取新的url,添加他们到 nextLink*/
            /*WebCollector 可以自动去重*/
            /*如果autoparse 为真则添加链接去nextlinks 如果与正则不匹配则不会添加*/
            //next.add("http://xxxxxx.com");
        }
    }

    public static void main(String[] args) throws Exception {
        NewsCrawler crawler = new NewsCrawler("crawl", true);
        crawler.setThreads(50);
//        crawler.setTopN(100);
        //crawler.setResumable(true);
        /*网页爬取深度为4*/
        crawler.start(4);
    }

}
