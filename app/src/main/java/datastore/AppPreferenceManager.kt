package datastore

import android.content.Context
import androidx.datastore.preferences.core.edit
import data.VirtualIdData
import kotlinx.coroutines.flow.first

class AppPreferenceManager(private val context: Context) {

    suspend fun saveLogin(role: String) {
        context.dataStore.edit { prefs ->
            prefs[PrefKeys.IS_LOGGED_IN] = true
            prefs[PrefKeys.USER_ROLE] = role
        }
    }

    suspend fun isLoggedIn(): Boolean {
        val prefs = context.dataStore.data.first()
        return prefs[PrefKeys.IS_LOGGED_IN] ?: false
    }

    suspend fun getUserRole(): String? {
        val prefs = context.dataStore.data.first()
        return prefs[PrefKeys.USER_ROLE]
    }

    suspend fun saveVirtualId(data: VirtualIdData) {
        context.dataStore.edit { prefs ->
            prefs[PrefKeys.HAS_VIRTUAL_ID] = true
            prefs[PrefKeys.ID_NAME] = data.name
            prefs[PrefKeys.ID_ENROLL] = data.enrollment
            prefs[PrefKeys.ID_COURSE] = data.cource
            prefs[PrefKeys.ID_COLLEGE] = data.collage
            prefs[PrefKeys.ID_YEAR] = data.admissionYear
        }
    }

    suspend fun getVirtualId(): VirtualIdData? {
        val prefs = context.dataStore.data.first()
        if (prefs[PrefKeys.HAS_VIRTUAL_ID] != true) return null

        return VirtualIdData(
            name = prefs[PrefKeys.ID_NAME] ?: "",
            enrollment = prefs[PrefKeys.ID_ENROLL] ?: "",
            cource = prefs[PrefKeys.ID_COURSE] ?: "",
            collage = prefs[PrefKeys.ID_COLLEGE] ?: "",
            admissionYear = prefs[PrefKeys.ID_YEAR] ?: ""
        )
    }

    suspend fun logout() {
        context.dataStore.edit { it.clear() }
    }
}
