interface Vehicle {

    fun roll()
}

class Wheel : Vehicle {

    override fun roll() {
        println("aaaaa")
        println("aaaaa")
        println("aaaaa")
    }
}

class Bicycle(vehicle: Vehicle) : Vehicle by vehicle

class KickScooter : Vehicle by Wheel()