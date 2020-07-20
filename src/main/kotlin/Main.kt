fun main() {
    val name = getName()
    val age = getAge()

    val user = User(name, age)
    println(getHumanReadableName(user))
}

private fun getAge(): Int {
    println(
            "Сколько тебе лет?"
    )
    return readLine()?.toIntOrNull() ?: throw error("Введите возраст в виде числа")
}

private fun getName(): String {
    println(
            "Привет! Как тебя зовут"
    )
    return readLine() ?: throw error("Введите имя")
}

fun getHumanReadableName(user: User): String =
        when (user.age) {
            in 0..18 -> "Молодёжь"
            in 18..50 -> "Зрелый"
            in 50..120 -> "Старик"
            else -> "Не человек"
        }