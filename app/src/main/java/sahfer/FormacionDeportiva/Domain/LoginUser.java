package sahfer.FormacionDeportiva.Domain;

public class LoginUser {
    String user;
    String pass;

    public LoginUser (String user, String pass){
        this.user = user;
        this.pass = pass;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

}
