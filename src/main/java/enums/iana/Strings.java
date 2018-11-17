package enums.iana;

public enum Strings {
    DOMAIN_NAMES("Domain Names"),
    DOMAIN_SECTION_TEXT("Management of the DNS Root Zone (assignments of ccTLDs and gTLDs)" +
            " along with other functions such as the .int and .arpa zones."),
    ROOT_ZONE_MANAGEMENT_URL("https://www.iana.org/domains/root"),
    TEXT_UNDER_LOGO("The global coordination of the DNS Root, IP addressing, and other Internet protocol" +
            " resources is performed as the Internet Assigned Numbers Authority (IANA) functions. Learn more.");

    private String str;

    Strings(String str) {
        this.str = str;
    }

    @Override
    public String toString() {
        return str;
    }
}
