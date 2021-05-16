package com.tema7.tema7ejemplo2.Validaciones;

import android.content.SharedPreferences;

public class Validaciones {
    //Devuelve el email guardado
    public static String getUserMailPrefs(SharedPreferences preferences) {
        return preferences.getString("email", "");
    }

    //Devuelve la contraseña guardada
    public static String getUserPassPrefs(SharedPreferences preferences) {
        return preferences.getString("contrasena", "");
    }

    //Borra los valores guardados
    public static void removeSharedPreferences(SharedPreferences preferences) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.remove("email");
        editor.remove("contrasena");
        editor.apply();
    }

}
