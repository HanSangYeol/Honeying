package kr.ac.doowon.honeying.Data.Question;

public class Question3 {

    private int Question2_Category;
    private int number;
    private boolean Result;
    private String Content;

    public Question3() {
    }

    public Question3(int question2_Category, int number, boolean result, String content) {
        Question2_Category = question2_Category;
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

    public int getQuestion2_Category() {
        return Question2_Category;
    }

    public void setQuestion2_Category(int question2_Category) {
        Question2_Category = question2_Category;
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
