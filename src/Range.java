public enum Range {
    WHAT("WHAT"),
    NONE("NONE"),
    RANGED("RANGED"),
    MELEE("MELEE"),
    BOTH("BOTH"),
    ;

    public final String name;

    Range(String string) {
        this.name = string;
    }

    public static Range toRange(String string) {
        for (Range range : Range.values()) {
            if (string.equals(range.name)) {
                return range;
            }
        }
        return WHAT;
    }

}
