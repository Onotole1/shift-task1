import java.util.prefs.Preferences
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

fun main() {
    val viewModel = UserViewModel(Preferences.userRoot())
    println(viewModel.userName)
}

class UserViewModel(preferences: Preferences) {

    var userName: String? by preferences.string()
    var userToken: String? by preferences.string()
}

fun Preferences.string(key: String? = null): ReadWriteProperty<Any, String?> =
    StringPreferencesDelegate(this, key)

private class StringPreferencesDelegate(
    private val preferences: Preferences,
    private val key: String? = null
) : ReadWriteProperty<Any, String?> {

    override fun getValue(thisRef: Any, property: KProperty<*>): String? =
        preferences.get(key ?: property.name, null)

    override fun setValue(thisRef: Any, property: KProperty<*>, value: String?) =
        preferences.put(key ?: property.name, value)
}