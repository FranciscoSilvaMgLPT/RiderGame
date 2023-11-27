public class User {
    private String name;
    private String password;
    private Rider rider;
    protected User(String name, String password) {
        this.name = name;
        this.password = password;
        this.rider = null;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public Rider getRider() {
        return rider;
    }

    public void setRider(Rider rider) {
        this.rider = rider;
    }
}
