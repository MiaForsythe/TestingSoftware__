package service;

import model.TeaKnowledgeData;

public class TeaKnowledgeDataService {
    public static TeaKnowledgeData getTestData() {
        return new TeaKnowledgeData(
                "https://www.ahmadtea.com/",
                "#menu-item-8612 > a",
                "#menu-item-8986 > a",
                "#site-content > section > section > ul > li:nth-child(4) > a",
                "#at_posts_wrap > div:nth-child(9)",
                "#post-3054 > section.article_container > div:nth-child(5) > p:nth-child(4) > a"
        );
    }
}
