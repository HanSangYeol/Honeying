package kr.ac.doowon.honeying.Data;

public class Restaurant {
    private int ID;
    private java.lang.String storeimg;
    private java.lang.String shopname;
    private int grade;
    private int review;
    private java.lang.String area;
    private double street;
    private int category;
    private double longitude;
    private double latitude;

    public Restaurant(int ID, String storeimg, String shopname, int grade, int review, String area, double street, int category, double longitude, double latitude) {
        this.ID = ID;
        this.storeimg = storeimg;
        this.shopname = shopname;
        this.grade = grade;
        this.review = review;
        this.area = area;
        this.street = street;
        this.category = category;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public Restaurant() {
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
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

    public double getStreet() {
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
