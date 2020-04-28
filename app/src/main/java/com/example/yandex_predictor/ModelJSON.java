package com.example.yandex_predictor;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ModelJSON {

    @SerializedName("endOfWord")
    public  boolean endOfWord;

    @SerializedName("pos")
    public int pos;

    @SerializedName("text")
    public ArrayList<String> text;

    public boolean isEndOfWord() {
        return endOfWord;
    }

    public void setEndOfWord(boolean endOfWord) {
        this.endOfWord = endOfWord;
    }

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }

    public ArrayList<String> getText() {
        return text;
    }

    public void setText(ArrayList<String> text) {
        this.text = text;
    }
}
