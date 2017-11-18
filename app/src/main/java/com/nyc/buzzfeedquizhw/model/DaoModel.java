package com.nyc.buzzfeedquizhw.model;

/**
 * Created by c4q on 11/16/17.
 */

public class DaoModel {
    private String url;
    private String question;
    private String[] answer;
    private int boxChecked;

    public int getBoxChecked() {
        return boxChecked;
    }

    public void setBoxChecked(int boxChecked) {
        this.boxChecked = boxChecked;
    }

    public DaoModel(String url, String question, String[] answer) {
        this.url = url;
        this.question = question;
        this.answer = answer;
    }

    public String getUrl() {
        return url;
    }

    public String getQuestion() {
        return question;
    }

    public String[] getAnswer() {
        return answer;
    }
}
