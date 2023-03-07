public enum SecondaryResource {

    WHAT("WHAT"),
    NONE("NONE"),
    MANA("MANA"),
    RAGE("RAGE"),
    MANALESS("MANALESS"),
    FURY("FURY"),
    GRIT("GRIT"),
    COURAGE("COURAGE"),
    HEALTH_COSTS("HEALTH_COSTS"),
    SHIELD("SHIELD"),
    FEROCITY("FEROCITY"),
    ENERGY("ENERGY"),
    HEAT("HEAT"),
    BLOODTHIRST("BLOODTHIRST"),
    FLOW("FLOW"),
    ;

    public final String name;

    SecondaryResource(String string) {
        this.name = string;
    }

    public static SecondaryResource toSecondaryResource(String string) {
        for (SecondaryResource secondaryResource : SecondaryResource.values()) {
            if (string.equals(secondaryResource.name)) {
                return secondaryResource;
            }
        }
        return WHAT;
    }
}
