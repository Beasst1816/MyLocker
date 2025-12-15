package datastore

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore



object PrefKeys {
    val IS_LOGGED_IN = booleanPreferencesKey("is_logged_in")
    val USER_ROLE  = stringPreferencesKey("user_role")
    val HAS_VIRTUAL_ID = booleanPreferencesKey("has_virtual_id")

    val ID_NAME = stringPreferencesKey("id_name")

    val ID_ENROLL = stringPreferencesKey("id_enroll")

    val ID_COURSE = stringPreferencesKey("id_course")

    val ID_COLLEGE = stringPreferencesKey("id_college")

    val ID_YEAR = stringPreferencesKey("id_year")
}