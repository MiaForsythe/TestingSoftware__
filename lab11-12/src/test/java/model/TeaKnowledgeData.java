package model;

public class TeaKnowledgeData {
    private String mainPageUrl;
    private String infusedWithImpactLinkText;
    private String latestNewsLinkText;
    private String teaKnowledgeLinkText;
    private String specificBlockCssSelector;
    private String specificLinkCssSelector;

    public TeaKnowledgeData(String mainPageUrl, String infusedWithImpactLinkText, String latestNewsLinkText, String teaKnowledgeLinkText, String specificBlockCssSelector, String specificLinkCssSelector) {
        this.mainPageUrl = mainPageUrl;
        this.infusedWithImpactLinkText = infusedWithImpactLinkText;
        this.latestNewsLinkText = latestNewsLinkText;
        this.teaKnowledgeLinkText = teaKnowledgeLinkText;
        this.specificBlockCssSelector = specificBlockCssSelector;
        this.specificLinkCssSelector = specificLinkCssSelector;
    }

    public String getMainPageUrl() {
        return mainPageUrl;
    }

    public String getInfusedWithImpactLinkText() {
        return infusedWithImpactLinkText;
    }

    public String getLatestNewsLinkText() {
        return latestNewsLinkText;
    }

    public String getTeaKnowledgeLinkText() {
        return teaKnowledgeLinkText;
    }

    public String getSpecificBlockCssSelector() {
        return specificBlockCssSelector;
    }

    public String getSpecificLinkCssSelector() {
        return specificLinkCssSelector;
    }
}
