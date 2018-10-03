package kr.ac.doowon.honeying.Data;

public class Restaurant {
    private int ID;
    private java.lang.String storeimg;
    private java.lang.String shopname;
    private int grade;
    private int review;
    private java.lang.String area;
    private float street;
    private int category;

    public Restaurant(int ID, java.lang.String storeimg, java.lang.String shopname, int grade, int review, java.lang.String area, float street, int category) {
        this.ID = ID;
        this.storeimg = storeimg;
        this.shopname = shopname;
        this.grade = grade;
        this.review = review;
        this.area = area;
        this.street = street;
        this.category = category;
    }

    public Restaurant() {
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getStoreimg() {
        return storeimg;
    }

    public void setStoreimg(String storeimg) {
        this.storeimg = storeimg;
    }

    public String getShopname() {
        return shopname;
    }

    public void setShopname(String shopname) {
        this.shopname = shopname;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getReview() {
        return review;
    }

    public void setReview(int review) {
        this.review = review;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public float getStreet() {
        return street;
    }

    public void setStreet(float street) {
        this.street = street;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }
}
