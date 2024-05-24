package service;

import model.TeaRecipeData;

public class TeaRecipeDataService {
    public static TeaRecipeData getTestData() {
        return new TeaRecipeData(
                "#menu-item-2122 > a",
                "#menu-item-2127 > a",
                "Hard",
                "10 minutes",
                "Earl Grey"
        );
    }
}
