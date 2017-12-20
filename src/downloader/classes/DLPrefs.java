package downloader.classes;

import java.util.prefs.Preferences;

public class DLPrefs {

    public static final String SAVE_LOCATION = "dl_save_location";
    private static final String PREFS_NAME = "dl_prefs_name";
    public static final String CURRENT_VERSION = "0.0.1";


    public static Preferences getPrefs()
    {
        return Preferences.userRoot().node(PREFS_NAME);
    }


    public static boolean getBoolean(String key)
    {
        return getPrefs().getBoolean(key, false);
    }

    public static void setBoolean(String key, boolean value)
    {
        getPrefs().putBoolean(key, value);
    }
    public static void setString(String key, String value)
    {
        getPrefs().put(key, value);
    }

    public static void setInt(String key, int value)
    {
        getPrefs().putInt(key, value);
    }

    public static int getInt(String key)
    {
        return getPrefs().getInt(key, 0);
    }
    public static String getString(String key)
    {
        return getPrefs().get(key, "");
    }

}
