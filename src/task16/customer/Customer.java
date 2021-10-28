package task16.customer;

public final class Customer {
    private final String firstName;
    private final String secondName;
    private final int age;
    private final Address address;

    private final static Customer MATURE_UNKNOWN_CUSTOMER = new Customer("", "", 18, null);
    private final static Customer NOT_MATURE_UNKNOWN_CUSTOMER = new Customer("", "", 0, null);

    public Customer(String firstName, String secondName, int age, Address address) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.age = age;
        this.address = address;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public int getAge() {
        return age;
    }

    public Address getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", age=" + age +
                ", address=" + address +
                '}';
    }
}
