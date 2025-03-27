package hw6.api;

public class SuccessfulReg {
   private Integer id;
   private String token;

    public SuccessfulReg() {
    }

    public SuccessfulReg(Integer id, String token) {
        this.id = id;
        this.token = token;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
