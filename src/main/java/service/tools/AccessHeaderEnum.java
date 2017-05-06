package service.tools;
public enum AccessHeaderEnum {

    ACCESS_CONTROL_ALLOW_ORIGIN("Access-Control-Allow-Origin", "*"),
    ACCESS_CONTROL_ALLOW_CREDENTIALS ("Access-Control-Allow-Credentials", "true"),
    ACCESS_CONTROL_ALLOW_HEADERS("Access-Control-Allow-Headers", "Cache-Control, Pragma, Origin, Authorization, Content-Type, X-Requested-With, Accept"),
    ACCESS_CONTROL_ALLOW_METHODS("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD");
    private final String accesString;
    private final String accesValue;

    AccessHeaderEnum(String accessControllString, String accesControllValue) {
        accesString = accessControllString;
        accesValue = accesControllValue;
    }

    public String getAccesString() {
        return accesString;
    }

    public String getAccesValue() {
        return accesValue;
    }
}

