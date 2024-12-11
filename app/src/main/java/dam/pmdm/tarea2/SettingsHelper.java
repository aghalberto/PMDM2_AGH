package dam.pmdm.tarea2;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Clase para gestionar los Settings. Gestiona los settings con shared preferences.
 */
public class SettingsHelper {
    private static final String PREFS_NAME = "app_prefs";
    //Language
    private static final String KEY_ENGLISH = "english";

    //Mode day or night
    private static final String KEY_MODE = "mode";

    /**
     * Guarda la opción de inglés. Es un switch.
     * @param context Contexto
     * @param english ON: Inglés. OFF: Spanish.
     */
    public static void saveEnglish(Context context, boolean english){

        SharedPreferences prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putBoolean(KEY_ENGLISH, english);
        editor.apply();
    }

    /**
     * Obtiene el valor de la clave de idioma
      * @param context
     * @return
     */
    public static boolean getEnglish(Context context){
        SharedPreferences prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        return prefs.getBoolean(KEY_ENGLISH, true);
    }

}
