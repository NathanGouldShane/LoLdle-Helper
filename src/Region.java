public enum Region {
    WHAT("WHAT"),
    NONE("NONE"),
    PILTOVER("PILTOVER"),
    ZAUN("ZAUN"),
    SHURIMA("SHURIMA"),
    SHADOW_ISLES("SHADOW_ISLES"),
    FRELJORD("FRELJORD"),
    NOXUS("NOXUS"),
    DEMACIA("DEMACIA"),
    BILGEWATER("BILGEWATER"),
    THE_VOID("THE_VOID"),
    IXTAL("IXTAL"),
    IONIA("IONIA"),
    RUNETERRA("RUNETERRA"),
    BANDLE_CITY("BANDLE_CITY"),
    CAMAVOR("CAMAVOR"),
    TARGON("TARGON"),
    ICATHIA("ICATHIA"),
    ;

    public final String name;

    Region(String string) {
        this.name = string;
    }

    public static Region toRegion(String string) {
        for (Region region : Region.values()) {
            if (string.equals(region.name)) {
                return region;
            }
        }
        return WHAT;
    }

}
