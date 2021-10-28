package task12;

import java.util.StringTokenizer;

public class Address {
    private String country;
    private String region;
    private String city;
    private String street;
    private String building;
    private String body;
    private String apartment;

    private Address() {
    }

    public static Address parse(String addressString){
        StringTokenizer st = new StringTokenizer(addressString.trim(), ",./! #-_");
        if (st.countTokens() != 7){
            throw new RuntimeException("st.countTokens() != 7");
        }
        Address address = new Address();
        address.country = st.nextToken();
        address.region = st.nextToken();
        address.city = st.nextToken();
        address.street = st.nextToken();
        address.building = st.nextToken();
        address.body = st.nextToken();
        address.apartment = st.nextToken();

        return address;
    }

    public String getCountry() {
        return country;
    }

    public String getRegion() {
        return region;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public String getBuilding() {
        return building;
    }

    public String getBody() {
        return body;
    }

    public String getApartment() {
        return apartment;
    }

    @Override
    public String toString() {
        return "Address{" +
                "country='" + country + '\'' +
                ", region='" + region + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", building='" + building + '\'' +
                ", body='" + body + '\'' +
                ", apartment='" + apartment + '\'' +
                '}';
    }
}
