package kr.ac.doowon.honeying.Data;

public class User {

    private int Id;
    private String login_Id;
    private String pw;
    private String email;
    public User() {
    }

    public User(int id, String login_Id, String pw, String email) {
        Id = id;
        this.login_Id = login_Id;
        this.pw = pw;
        this.email = email;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getLogin_Id() {
        return login_Id;
    }

    public void setLogin_Id(String login_Id) {
        this.login_Id = login_Id;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
