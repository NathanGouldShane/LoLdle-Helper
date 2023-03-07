//                                                         //

/**
 * This class contains methods I found universally useful, yet not integrated in base Java so I coded them myself
 *
 * @author Nathan Gould
 * @version 1.0
 */
public class Helper {

    // This method padds a given string with a given char to a given length
    public static String padString(String string, String character, int length, boolean right) {
        if (string.length() < length) {
            for (int i = string.length(); i < length; i++) {
                if (right) {
                    string = string + character;
                } else {
                    string = character + string;
                }
            }
        }
        return string;
    }
}
