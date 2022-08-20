package com.hermes.designpattern.flyweight;

/**
 * @author liu.zongbin
 * @since 2022/8/20 16:17
 */
public class Client {

    public static void main(String[] args) {
        WebSiteFactory factory = new WebSiteFactory();

        WebSite webSite1 = factory.getWebSite("新闻");
        webSite1.use(new User("tom"));

        WebSite webSite2 = factory.getWebSite("博客");
        webSite2.use(new User("jack"));

        System.out.println("网站的分类共：" + factory.getWebSiteCount() + "种");
    }
}
