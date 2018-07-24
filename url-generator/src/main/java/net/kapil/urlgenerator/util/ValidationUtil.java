package net.kapil.urlgenerator.util;

public class ValidationUtil {
    private static final String URL_REGEX = "^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";

    public static boolean isValidUrl(final String url) {
        return ((url != null && !url.isEmpty()) && (url.matches(URL_REGEX)));
    }
}
