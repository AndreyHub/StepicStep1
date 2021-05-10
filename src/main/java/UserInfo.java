public class UserInfo {
    String login;
    String password;
    String email;
    String comment;
    Integer id;

    public UserInfo (String login, String passsword, String email, String comment){
        this.login = login;
        this.password = passsword;
        this.email = email;
        this.comment = comment;
       // this.id = id;

    }
    public UserInfo(){};

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() { return email;  }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", comment='" + comment + '\'' +
                ", id=" + id +
                '}';
    }
}


