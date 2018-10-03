package kr.ac.doowon.honeying.Data;

public class Review {
    private java.lang.String reviewImg;
    private java.lang.String reviewImg2;
    private java.lang.String reviewImg3;
    private java.lang.String nickname;
    private int goodPoint;
    private int reviewContents;
    private java.lang.String reviewcomment;
    private java.lang.String reviewshopname;
    private java.lang.String reviewarea;

    public Review(String reviewImg, String reviewImg2, String reviewImg3, String nickname, int goodPoint, int reviewContents, String reviewcomment, String reviewshopname, String reviewarea) {
        this.reviewImg = reviewImg;
        this.reviewImg2 = reviewImg2;
        this.reviewImg3 = reviewImg3;
        this.nickname = nickname;
        this.goodPoint = goodPoint;
        this.reviewContents = reviewContents;
        this.reviewcomment = reviewcomment;
        this.reviewshopname = reviewshopname;
        this.reviewarea = reviewarea;
    }

    public Review() {
    }

    public String getReviewImg() {
        return reviewImg;
    }

    public void setReviewImg(String reviewImg) {
        this.reviewImg = reviewImg;
    }

    public String getReviewImg2() {
        return reviewImg2;
    }

    public void setReviewImg2(String reviewImg2) {
        this.reviewImg2 = reviewImg2;
    }

    public String getReviewImg3() {
        return reviewImg3;
    }

    public void setReviewImg3(String reviewImg3) {
        this.reviewImg3 = reviewImg3;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getGoodPoint() {
        return goodPoint;
    }

    public void setGoodPoint(int goodPoint) {
        this.goodPoint = goodPoint;
    }

    public int getReviewContents() {
        return reviewContents;
    }

    public void setReviewContents(int reviewContents) {
        this.reviewContents = reviewContents;
    }

    public String getReviewcomment() {
        return reviewcomment;
    }

    public void setReviewcomment(String reviewcomment) {
        this.reviewcomment = reviewcomment;
    }

    public String getReviewshopname() {
        return reviewshopname;
    }

    public void setReviewshopname(String reviewshopname) {
        this.reviewshopname = reviewshopname;
    }

    public String getReviewarea() {
        return reviewarea;
    }

    public void setReviewarea(String reviewarea) {
        this.reviewarea = reviewarea;
    }
}
