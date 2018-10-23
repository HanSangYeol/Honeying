package kr.ac.doowon.honeying.Data.Question;

public class Question1 {

    private int Category;
    private String Content;

    public Question1() {
    }

    public Question1(int category, String content) {
        Category = category;
        Content = content;
    }

    public int getCategory() {
        return Category;
    }

    public void setCategory(int category) {
        Category = category;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }
}
