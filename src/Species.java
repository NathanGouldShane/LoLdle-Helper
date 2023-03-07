public enum Species {

    WHAT("WHAT"),
    NONE("NONE"),
    DARKIN("DARKIN"),
    UNDEAD("UNDEAD"),
    HUMAN("HUMAN"),
    YORDLE("YORDLE"),
    ICEBORN("ICEBORN"),
    MAGICALLY_ALTERED("MAGICALLY_ALTERED"),
    CHEMICALLY_ALTERED("CHEMICALLY_ALTERED"),
    GOLEM("GOLEM"),
    SPIRIT("SPIRIT"),
    DEMON("DEMON"),
    SHADE("SHADE"),
    VOIDBORN("VOIDBORN"),
    GOD("GOD"),
    GOD_WARRIOR("GOD_WARRIOR"),
    VASTAYAN("VASTAYAN"),
    REVENANT("REVENANT"),
    YETI("YETI"),
    VOID_BEING("VOID_BEING"),
    BRACKERN("BRACKERN"),
    CELESTIAL("CELESTIAL"),
    RAT("RAT"),
    CAT("CAT"),
    MINOTAUR("MINOTAUR"),
    UNKNOWN("UNKNOWN"),
    MAGICBORN("MAGICBORN"),
    ASPECT("ASPECT"),
    SPIRITUALIST("SPIRITUALIST"),
    DRAGON("DRAGON"),
    ASCENDED("ASCENDED"),
    CYBORG("CYBORG"),
    TROLL("TROLL"),
    ;

    public final String name;

    Species(String name) {
        this.name = name;
    }

    public static Species toSpecies(String string) {
        for (Species species : Species.values()) {
            if (string.equals(species.name)) {
                return species;
            }
        }
        return WHAT;
    }

}
