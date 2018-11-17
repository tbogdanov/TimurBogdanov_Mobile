package enums.contactManager;

public enum Strings {

    CONTACT_NAME("Contact Name"),
    CONTACT_PHONE("Contact Phone");

    private String str;

    Strings(String str){
        this.str = str;
    }

    @Override
    public String toString() {
        return str;
    }
}