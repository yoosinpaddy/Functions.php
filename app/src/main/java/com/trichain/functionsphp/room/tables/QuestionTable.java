package com.trichain.functionsphp.room.tables;



import java.io.Serializable;


public class QuestionTable implements Serializable {
    private String questions,players,level;
    private int players1,level1;

    public QuestionTable(String questions, String players, String level) {
        this.questions = questions;
        this.players = players;
        this.level = level;
        this.players1= Integer.parseInt(players);
        this.level1=Integer.parseInt(level);
    }
    //getters and setters

    public String getQuestions() {
        return questions;
    }

    public void setQuestions(String questions) {
        this.questions = questions;
    }

    public String getPlayers() {
        return players;
    }

    public void setPlayers(String players) {
        this.players = players;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public int getPlayers1() {
        return Integer.parseInt(players);
    }

    public int getLevel1() {
        return Integer.parseInt(level);
    }
}
