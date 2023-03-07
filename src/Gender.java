public enum Gender {

    WHAT("WHAT"),
    NONE("NONE"),
    MALE("MALE"),
    FEMALE("FEMALE"),
    OTHER("OTHER");

    private final String name;

    Gender(String string) {
        this.name = string;
    }

    public static Gender toGender(String string) {
        for (Gender gender : Gender.values()) {
            if (string.equals(gender.name)) {
                return gender;
            }
        }
        return WHAT;
    }
}
