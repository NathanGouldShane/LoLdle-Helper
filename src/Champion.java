import java.util.LinkedList;

public class Champion {

    // constant values
    private final String name;
    private final Gender gender;
    private final LinkedList<Lane> playableLanes;
    private final LinkedList<Species> species;
    private final SecondaryResource secondaryResource;
    private final LinkedList<Range> ranges;
    private final LinkedList<Region> regions;
    private final int releaseYear;

    public Champion(String name, Gender gender, LinkedList<Lane> playableLanes, LinkedList<Species> species, SecondaryResource secondaryResource, LinkedList<Range> ranges, LinkedList<Region> regions, int releaseYear) {
        this.name = name;
        this.gender = gender;
        this.playableLanes = playableLanes;
        this.species = species;
        this.secondaryResource = secondaryResource;
        this.regions = regions;
        this.ranges = ranges;
        this.releaseYear = releaseYear;
    }

    public String returnNameString() {
        return Helper.padString(name, " ", Constants.DISPLAY_ELEMENT_WIDTH_NAME / 2, false);
    }

    public String returnGenderString() {
        return Helper.padString(String.valueOf(gender), " ", Constants.DISPLAY_ELEMENT_WIDTH_GENDER / 2, false);
    }

    public String returnLaneString() {
        StringBuilder laneStringBuilder = new StringBuilder();
        boolean firstLane = true;
        for (Lane lane : playableLanes) {
            if (firstLane) {
                firstLane = false;
            } else {
                laneStringBuilder.append(", ");
            }
            laneStringBuilder.append(lane);
        }
        return Helper.padString(laneStringBuilder.toString(), " ", Constants.DISPLAY_ELEMENT_WIDTH_POSITION / 2, false);
    }

    public String returnSpeciesString() {
        StringBuilder speciesStringBuilder = new StringBuilder();
        boolean firstSpecies = true;
        for (Species species : species) {
            if (firstSpecies) {
                firstSpecies = false;
            } else {
                speciesStringBuilder.append(", ");
            }
            speciesStringBuilder.append(species);
        }
        return Helper.padString(speciesStringBuilder.toString(), " ", Constants.DISPLAY_ELEMENT_WIDTH_SPECIES / 2, false);
    }

    public String returnResourceString() {
        return Helper.padString(String.valueOf(secondaryResource), " ", Constants.DISPLAY_ELEMENT_WIDTH_RESOURCE / 2, false);
    }

    public String returnRangeString() {
        StringBuilder rangeStringBuilder = new StringBuilder();
        boolean firstRange = true;
        for (Range range : ranges) {
            if (firstRange) {
                firstRange = false;
            } else {
                rangeStringBuilder.append(", ");
            }
            rangeStringBuilder.append(range);
        }
        return Helper.padString(rangeStringBuilder.toString(), " ", Constants.DISPLAY_ELEMENT_WIDTH_RANGE / 2, false);
    }

    public String returnRegionString() {
        StringBuilder regionStringBuilder = new StringBuilder();
        boolean firstRegion = true;
        for (Region region : regions) {
            if (firstRegion) {
                firstRegion = false;
            } else {
                regionStringBuilder.append(", ");
            }
            regionStringBuilder.append(region);
        }
        return Helper.padString(regionStringBuilder.toString(), " ", Constants.DISPLAY_ELEMENT_WIDTH_REGION / 2, false);
    }

    public String returnReleaseString() {
        return Helper.padString(String.valueOf(releaseYear), " ", Constants.DISPLAY_ELEMENT_WIDTH_RELEASE / 2, false);
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public LinkedList<Lane> getPlayableLanes() {
        return playableLanes;
    }

    public LinkedList<Species> getSpecies() {
        return species;
    }

    public SecondaryResource getSecondaryResource() {
        return secondaryResource;
    }

    public LinkedList<Region> getRegions() {
        return regions;
    }

    public LinkedList<Range> getRanges() {
        return ranges;
    }

    public int getReleaseYear() {
        return releaseYear;
    }
}
