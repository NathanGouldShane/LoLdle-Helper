public enum Lane {
    WHAT("WHAT"),
    NONE("NONE"),
    TOPLANE("TOPLANE"),
    JUNGLE("JUNGLE"),
    MIDLANE("MIDLANE"),
    BOTLANE("BOTLANE"),
    SUPPORT("SUPPORT");

    private final String name;

    Lane(String string) {
        this.name = string;
    }

    public static Lane toLane(String string) {
        for (Lane lane : Lane.values()) {
            if (string.equals(lane.name)) {
                return lane;
            }
        }
        return WHAT;
    }

}
