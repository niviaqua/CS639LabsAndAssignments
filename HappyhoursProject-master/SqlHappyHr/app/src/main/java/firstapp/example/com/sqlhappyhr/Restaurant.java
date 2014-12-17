package firstapp.example.com.sqlhappyhr;

/**
 * Created by murlidhar on 12/5/14.
 */
public class Restaurant
{
    Integer id = null;
    String name = null;
    String address = null;
    String phone = null;
    String offers = null;
    String time = null;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getOffers() {
        return offers;
    }
    public void setOffers(String offer) {
        this.offers = offer;
    }

    public void setTime(String time) {
        this.time = time;
    }
    public String getTime() {
        return time;
    }

}
