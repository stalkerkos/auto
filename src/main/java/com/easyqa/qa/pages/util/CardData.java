package com.easyqa.qa.pages.util;

import io.qameta.allure.Step;

public class CardData {
    private String cardName;
    private String cardDescription;

    public CardData(String cardName, String cardDescription){
        this.cardName=cardName;
        this.cardDescription=cardDescription;
    }
    @Step
    public String getCardName(){
        return this.cardName;
    }
    @Step
    public String getCardDescription(){
        return this.cardDescription;
    }


}


