package hw6.api;


public class TimeData extends UpdateUserData {
    private String updatedAt;

    public TimeData() {
    }

    public TimeData(String name, String job, String updatedAt) {
        super(name, job);
        this.updatedAt = updatedAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }
}
