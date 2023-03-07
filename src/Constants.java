import java.awt.*;

public class Constants {
    // Save file location
    public static String CHAMPION_FILE_PATH = "src\\Champions.txt";
    public static String SEPERATION_TOKEN = ";";
    public static String COMMA_TOKEN = ",";
    public static String SPACE_TOKEN = " ";
    public static String NEXT_LINE_TOKEN = "\n";
    public static String ANY = "any";
    public static int WINDOW_SCALING_FACTOR = 50;
    public static String FILE_LOCATION_ICON = "";
    public static String WHAT_STRING = "WHAT";
    public static String NONE_STRING = "NONE";
    public static int WINDOW_HEIGHT = 200;
    public static int WINDOW_WIDTH = 400;
    public static int BUTTON_WIDTH = 0;
    public static int BUTTON_HEIGHT = 0;
    public static int CHAMPION_INFO_LENGTH = 8;
    public static int DISPLAY_ELEMENT_WIDTH_NAME = 18 * 2;
    public static int DISPLAY_ELEMENT_WIDTH_GENDER = 15 * 2;
    public static int DISPLAY_ELEMENT_WIDTH_POSITION = 25 * 2;
    public static int DISPLAY_ELEMENT_WIDTH_SPECIES = 35 * 2;
    public static int DISPLAY_ELEMENT_WIDTH_RESOURCE = 15 * 2;
    public static int DISPLAY_ELEMENT_WIDTH_RANGE = 20 * 2;
    public static int DISPLAY_ELEMENT_WIDTH_REGION = 35 * 2;
    public static int DISPLAY_ELEMENT_WIDTH_RELEASE = 15 * 2;
    public static int MAXIMUM_NUMBER_OF_SHOWN_CHAMPS = 30;
    public static String NO_FILTER = "no filter";
    public static String REMAINING_CHAMPIONS_TOP_BAR_CHAMPION = Helper.padString("Champion", SPACE_TOKEN, DISPLAY_ELEMENT_WIDTH_NAME, false);
    public static String REMAINING_CHAMPIONS_TOP_BAR_GENDER = Helper.padString("Gender", SPACE_TOKEN, DISPLAY_ELEMENT_WIDTH_GENDER, false);
    public static String REMAINING_CHAMPIONS_TOP_BAR_POSITION = Helper.padString("Lane/-s", SPACE_TOKEN, DISPLAY_ELEMENT_WIDTH_POSITION, false);
    public static String REMAINING_CHAMPIONS_TOP_BAR_SPECIES = Helper.padString("Species", SPACE_TOKEN, DISPLAY_ELEMENT_WIDTH_SPECIES, false);
    public static String REMAINING_CHAMPIONS_TOP_BAR_RESOURCE = Helper.padString("Resource", SPACE_TOKEN, DISPLAY_ELEMENT_WIDTH_RESOURCE, false);
    public static String REMAINING_CHAMPIONS_TOP_BAR_RANGE_TYPE = Helper.padString("Ranged", SPACE_TOKEN, DISPLAY_ELEMENT_WIDTH_RANGE, false);
    public static String REMAINING_CHAMPIONS_TOP_BAR_REGION = Helper.padString("Region/-s", SPACE_TOKEN, DISPLAY_ELEMENT_WIDTH_REGION, false);
    public static String REMAINING_CHAMPIONS_TOP_BAR_RELEASE_YEAR = Helper.padString("Release year", SPACE_TOKEN, DISPLAY_ELEMENT_WIDTH_RELEASE, false);
    public static String REMAINING_CHAMPIONS_TOP_BAR = REMAINING_CHAMPIONS_TOP_BAR_CHAMPION + REMAINING_CHAMPIONS_TOP_BAR_GENDER + REMAINING_CHAMPIONS_TOP_BAR_POSITION + REMAINING_CHAMPIONS_TOP_BAR_SPECIES + REMAINING_CHAMPIONS_TOP_BAR_RESOURCE + REMAINING_CHAMPIONS_TOP_BAR_RANGE_TYPE + REMAINING_CHAMPIONS_TOP_BAR_REGION + REMAINING_CHAMPIONS_TOP_BAR_RELEASE_YEAR;

}
