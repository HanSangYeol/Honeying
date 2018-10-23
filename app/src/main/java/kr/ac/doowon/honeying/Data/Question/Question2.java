package kr.ac.doowon.honeying.Data.Question;

public class Question2 {

    private int Question1_Category;
    private int number;
    private boolean Result;
    private String Content;

    public Question2() {
    }

    public Question2(int question1_Category, int number, boolean result, String content) {
        Question1_Category = question1_Category;
        this.number = number;
        Result = result;
        Content = content;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getQuestion1_Category() {
        return Question1_Category;
    }

    public void setQuestion1_Category(int question1_Category) {
        Question1_Category = question1_Category;
    }

    public boolean isResult() {
        return Result;
    }

    public void setResult(boolean result) {
        Result = result;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }
}
