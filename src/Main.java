import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    static boolean debug = false;

    static boolean coolMode = false;

    static Window window;

    static LinkedList<Champion> allChampions;

    static LinkedList<Champion> remainingChampions = new LinkedList<>();

    static Gender filteredGender = null;

    static LinkedList<Lane> filteredLanes = new LinkedList<>();

    static LinkedList<Species> filteredSpecieses = new LinkedList<>();

    static SecondaryResource filteredSecondaryResource = null;

    static LinkedList<Range> filteredRanges = new LinkedList<>();

    static LinkedList<Region> filteredRegions = new LinkedList<>();

    static int filteredYear = 0;

    static String yearDirection = "=";

    public static void main(String[] args) {
        try {
            allChampions = returnAllChampionsOfReadChampionsFile(Constants.CHAMPION_FILE_PATH);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        remainingChampions.addAll(allChampions);
        initializeWindow();
    }

    public static void initializeWindow() {
        window = new Window("Loldle-Solver by Nathan Gould");
        // calculates the needed dimensions and position for the window
        GraphicsDevice screen = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        int screenWidth = screen.getDisplayMode().getWidth();
        int screenHeight = screen.getDisplayMode().getHeight();
        int windowWidth = (int) (screenWidth * (0.01 * Constants.WINDOW_SCALING_FACTOR));
        int windowHeight = (int) (screenHeight * (0.01 * Constants.WINDOW_SCALING_FACTOR));
        int windowLocationX = (screenWidth - windowWidth) / 2;
        int windowLocationY = (screenHeight - windowHeight) / 2;
        // Creates the new window and assigns the values to it
        SwingUtilities.invokeLater(() -> {
            // window.setDefaultCloseOperation(window.EXIT_ON_CLOSE);
            window.setDefaultCloseOperation(window.DISPOSE_ON_CLOSE);
            window.setResizable(false);
            ImageIcon windowIcon = new ImageIcon(Constants.FILE_LOCATION_ICON);
            window.setIconImage(windowIcon.getImage());
            window.setSize(windowWidth, windowHeight);
            window.setLocation(windowLocationX, windowLocationY);
            window.setVisible(true);
            if (debug) {
                int debugWindowWidth = (int) (screenWidth * 0.5);
                int debugWindowHeight = (int) (screenHeight * 0.5);
                int debugWindowLocationX = (screenWidth - debugWindowWidth);
                int debugWindowLocationY = (screenHeight - debugWindowHeight);
                window.setSize(debugWindowWidth, debugWindowHeight);
                window.setLocation(debugWindowLocationX, debugWindowLocationY);
            }
        });
    }


    private static LinkedList<Champion> returnAllChampionsOfReadChampionsFile(String filePath) throws FileNotFoundException {
        LinkedList<Champion> addedChampions = new LinkedList<>();
        FileReader championsFile = new FileReader(filePath);
        Scanner championsScanner = new Scanner(championsFile);
        while (championsScanner.hasNextLine()) {
            String currentChampionInfoString = championsScanner.nextLine();
            String[] currentChampionInfoArray = currentChampionInfoString.split(Constants.SEPERATION_TOKEN);
            if (currentChampionInfoArray.length < Constants.CHAMPION_INFO_LENGTH || currentChampionInfoArray.length > Constants.CHAMPION_INFO_LENGTH) {
                System.out.println(Constants.CHAMPION_INFO_LENGTH);
                System.out.println("error " + currentChampionInfoArray.length);
                break;
            }
            int i = 0;
            String name = currentChampionInfoArray[i];
            i++;
            Gender gender = Gender.toGender(currentChampionInfoArray[i]);
            i++;
            LinkedList<Lane> lanes = new LinkedList<>();
            String[] splitLanes = currentChampionInfoArray[i].split(Constants.COMMA_TOKEN);
            for (String splitLane : splitLanes) {
                lanes.add(Lane.toLane(splitLane));
            }
            i++;
            LinkedList<Species> specieses = new LinkedList<>();
            String[] splitSpecies = currentChampionInfoArray[i].split(Constants.COMMA_TOKEN);
            for (String species : splitSpecies) {
                specieses.add(Species.toSpecies(species));
            }
            i++;
            SecondaryResource secondaryResource = SecondaryResource.toSecondaryResource(currentChampionInfoArray[i]);
            i++;
            LinkedList<Range> ranges = new LinkedList<>();
            String[] splitRange = currentChampionInfoArray[i].split(Constants.COMMA_TOKEN);
            for (String range : splitRange) {
                ranges.add(Range.toRange(range));
            }
            i++;
            LinkedList<Region> regions = new LinkedList<>();
            String[] splitRegions = currentChampionInfoArray[i].split(Constants.COMMA_TOKEN);
            for (String region : splitRegions) {
                regions.add(Region.toRegion(region));
            }
            i++;
            int releaseYear = Integer.parseInt(currentChampionInfoArray[i]);
            addedChampions.add(new Champion(name, gender, lanes, specieses, secondaryResource, ranges, regions, releaseYear));
        }
        return addedChampions;
    }

    public static void updateRemainingChampions() {
        remainingChampions = new LinkedList<>();
        remainingChampions.addAll(allChampions);
        removeGenders(filteredGender);
        removeLanes(filteredLanes);
        removeSpecies(filteredSpecieses);
        removeResources(filteredSecondaryResource);
        removeRanges(filteredRanges);
        removeRegions(filteredRegions);
        removeReleaseYears(filteredYear, yearDirection);
    }

    public static void removeGenders(Gender gender) {
        if (gender != null) {
            remainingChampions.removeIf(champion -> champion.getGender() != gender);
        }
    }

    public static void removeLanes(LinkedList<Lane> lanes) {
        for (Lane lane : lanes) {
            remainingChampions.removeIf(champion -> !champion.getPlayableLanes().contains(lane));
        }
    }

    public static void removeSpecies(LinkedList<Species> specieses) {
        for (Species species : specieses) {
            remainingChampions.removeIf(champion -> !champion.getSpecies().contains(species));
        }
    }

    public static void removeResources(SecondaryResource secondaryResource) {
        if (secondaryResource != null) {
            remainingChampions.removeIf(champion -> !champion.getSecondaryResource().equals(secondaryResource));
        }
    }

    public static void removeRanges(LinkedList<Range> ranges) {
        for (Range range : ranges) {
            remainingChampions.removeIf(champion -> !champion.getRanges().contains(range));
        }
    }

    public static void removeRegions(LinkedList<Region> regions) {
        for (Region region : regions) {
            remainingChampions.removeIf(champion -> !champion.getRegions().contains(region));
        }
    }

    public static void removeReleaseYears(int releaseYear, String direction) {
        if (releaseYear != 0) {
            switch (direction) {
                case "<":
                    remainingChampions.removeIf(champion -> champion.getReleaseYear() > releaseYear - 1);
                    break;
                case "=":
                    remainingChampions.removeIf(champion -> champion.getReleaseYear() != releaseYear);
                    break;
                case ">":
                    remainingChampions.removeIf(champion -> champion.getReleaseYear() < releaseYear + 1);
                    break;
            }
        }
    }

    public static LinkedList<Champion> getRemainingChampions() {
        return remainingChampions;
    }

    public static String returnFilterString() {
        String paddedNameString = Helper.padString("Current Criteria: ", " ", Constants.DISPLAY_ELEMENT_WIDTH_NAME, false);
        String genderString = String.valueOf(filteredGender);
        if (genderString.equals("null")) {
            genderString = Constants.NO_FILTER;
        }
        String paddedGenderString = Helper.padString(genderString, " ", Constants.DISPLAY_ELEMENT_WIDTH_GENDER, false);
        StringBuilder laneStringBuilder = new StringBuilder();
        boolean firstLane = true;
        for (Lane lane : filteredLanes) {
            if (firstLane) {
                firstLane = false;
            } else {
                laneStringBuilder.append(", ");
            }
            laneStringBuilder.append(lane);
        }
        String laneString = laneStringBuilder.toString();
        if (laneString.equals("")) {
            laneString = Constants.NO_FILTER;
        }
        String paddedLaneString = Helper.padString(laneString, " ", Constants.DISPLAY_ELEMENT_WIDTH_POSITION, false);
        StringBuilder speciesStringBuilder = new StringBuilder();
        boolean firstSpecies = true;
        for (Species species : filteredSpecieses) {
            if (firstSpecies) {
                firstSpecies = false;
            } else {
                speciesStringBuilder.append(", ");
            }
            speciesStringBuilder.append(species);
        }
        String speciesString = speciesStringBuilder.toString();
        if (speciesString.equals("")) {
            speciesString = Constants.NO_FILTER;
        }
        String paddedSpeciesString = Helper.padString(speciesString, " ", Constants.DISPLAY_ELEMENT_WIDTH_SPECIES, false);
        String resourceString = String.valueOf(filteredSecondaryResource);
        if (resourceString.equals("null")) {
            resourceString = Constants.NO_FILTER;
        }
        String paddedResourceString = Helper.padString(resourceString, " ", Constants.DISPLAY_ELEMENT_WIDTH_RESOURCE, false);
        StringBuilder rangeStringBuilder = new StringBuilder();
        boolean firstRange = true;
        for (Range range : filteredRanges) {
            if (firstRange) {
                firstRange = false;
            } else {
                rangeStringBuilder.append(", ");
            }
            rangeStringBuilder.append(range);
        }
        String rangeString = rangeStringBuilder.toString();
        if (rangeString.equals("")) {
            rangeString = Constants.NO_FILTER;
        }
        String paddedRangeString = Helper.padString(rangeString, " ", Constants.DISPLAY_ELEMENT_WIDTH_RANGE, false);
        StringBuilder regionStringBuilder = new StringBuilder();
        boolean firstRegion = true;
        for (Region region : filteredRegions) {
            if (firstRegion) {
                firstRegion = false;
            } else {
                regionStringBuilder.append(", ");
            }
            regionStringBuilder.append(region);
        }
        String regionString = regionStringBuilder.toString();
        if (regionString.equals("")) {
            regionString = Constants.NO_FILTER;
        }
        String paddedRegionString = Helper.padString(regionString, " ", Constants.DISPLAY_ELEMENT_WIDTH_REGION, false);
        String filteredYearString = String.valueOf(filteredYear);
        if (filteredYearString.equals("0")) {
            filteredYearString = Constants.NO_FILTER;
        }
        String paddedReleaseString = Helper.padString(filteredYearString, " ", Constants.DISPLAY_ELEMENT_WIDTH_RELEASE, false);
        return paddedNameString + paddedGenderString + paddedLaneString + paddedSpeciesString + paddedResourceString + paddedRangeString + paddedRegionString + paddedReleaseString;
    }

}
