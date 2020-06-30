import java.util.Scanner

val scanner = Scanner(System.`in`)

class CoffeeMachine (var volumeOfWater: Int = 400,
                     var volumeOfMilk: Int = 540,
                     var gramsOfCoffeeBeans: Int = 120,
                     var disposableCups: Int = 9,
                     var moneyInCash: Int = 550) {

    fun buy() {
        println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ")
        when(scanner.next()) {
            "1" -> {
                Espresso.buy(this)
            }
            "2" -> {
                Latte.buy(this)
            }
            "3" -> {
                Cappuccino.buy(this)
            }
            else -> {

            }
        }
    }

    fun fill() {
        print("Write how many ml of water do you want to add: ")
        volumeOfWater += scanner.nextInt()
        print("Write how many ml of milk do you want to add: ")
        volumeOfMilk += scanner.nextInt()
        print("Write how many grams of coffee beans do you want to add: ")
        gramsOfCoffeeBeans += scanner.nextInt()
        print("Write how many disposable cups of coffee do you want to add: ")
        disposableCups += scanner.nextInt()
    }

    fun take() {
        println("I gave you $moneyInCash")
        moneyInCash = 0
    }

    fun status() {
        println("The coffee machine has:")
        println("$volumeOfWater of water")
        println("$volumeOfMilk of milk")
        println("$gramsOfCoffeeBeans of coffee beans")
        println("$disposableCups of disposable cups")
        println("$moneyInCash of money")
    }
}

fun main() {
    var isActive: Boolean = true
    val coffeeMachine : CoffeeMachine = CoffeeMachine()

    while (isActive) {
        print("Write action (buy, fill, take, remaining, exit): ")
        val action = scanner.next()
        when(action) {
            "buy" -> {
                coffeeMachine.buy()
            }
            "fill" -> {
                coffeeMachine.fill()
            }
            "take" -> {
                coffeeMachine.take()
            }
            "remaining" -> {
                coffeeMachine.status()
            }
            "exit" -> {
                isActive = false
            }
            else -> {

            }
        }
    }
}
