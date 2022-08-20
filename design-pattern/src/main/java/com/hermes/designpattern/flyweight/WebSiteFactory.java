package com.hermes.designpattern.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liu.zongbin
 * @since 2022/8/20 16:20
 */
public class WebSiteFactory {

    private Map<String, ConcreteWebSite> pool = new HashMap<>();

    /**
     * 根据网站类型，返回一个网站，如果没有就创建一个网站并放到池子中
     */
    public WebSite getWebSite(String type) {
        if (!pool.containsKey(type)) {
            pool.put(type, new ConcreteWebSite(type));
        }

        return pool.get(type);
    }

    /**
     * 获取网站的总数
     */
    public int getWebSiteCount() {
        return pool.size();
    }
}
