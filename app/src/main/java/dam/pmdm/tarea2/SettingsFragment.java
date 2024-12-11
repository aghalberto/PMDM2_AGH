package dam.pmdm.tarea2;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.SwitchPreference;

public class SettingsFragment extends PreferenceFragmentCompat {


   // public static final String TAG = "SettingsFragment";
    /**
     * Constructor. Constructor por defecto.
     */
    /*
    public SettingsFragment() {
    }
    */
    @Override
    public void onCreatePreferences(@Nullable Bundle savedInstanceState, @Nullable String rootKey) {
        //Inflar el archivo de preferencias xml
        setPreferencesFromResource(R.xml.settings_fragment, rootKey);
        SwitchPreference englishPreference = findPreference("english");
        if (englishPreference != null ){
            englishPreference.setOnPreferenceChangeListener(((preference, newValue) -> {
                return true; //Devuelve true para guardar el nuevo valor
            }));

            }


    }
}
