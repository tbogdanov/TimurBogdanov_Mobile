package enums.contactManager;

public enum TestContact {

    VASILIY_PUPKIN("Vasiliy Pupkin", "+79991234567");

    private String name;
    private String phoneNumber;

    TestContact(String name, String phoneNumber){
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}