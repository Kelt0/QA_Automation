package hw6.api;

public class UnsuccessfulReg {
   private String error;

    public UnsuccessfulReg() {
    }

    public UnsuccessfulReg(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
