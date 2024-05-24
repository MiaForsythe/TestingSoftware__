package model;

public class TeaRecipeData {
    private String teaArtistryLinkCssSelector;
    private String teaRecipesLinkCssSelector;
    private String difficulty;
    private String time;
    private String blend;

    public TeaRecipeData(String teaArtistryLinkCssSelector, String teaRecipesLinkCssSelector, String difficulty, String time, String blend) {
        this.teaArtistryLinkCssSelector = teaArtistryLinkCssSelector;
        this.teaRecipesLinkCssSelector = teaRecipesLinkCssSelector;
        this.difficulty = difficulty;
        this.time = time;
        this.blend = blend;
    }

    public String getTeaArtistryLinkCssSelector() {
        return teaArtistryLinkCssSelector;
    }

    public String getTeaRecipesLinkCssSelector() {
        return teaRecipesLinkCssSelector;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public String getTime() {
        return time;
    }

    public String getBlend() {
        return blend;
    }
}
