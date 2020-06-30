interface Coffee {
    var cost: Int
    var water: Int
    var milk: Int
    var coffeeBeans: Int

    fun buy(coffeeMachine: CoffeeMachine) {
        val n = canBuy(coffeeMachine)
        if (n == Ingredient.COST) {
            coffeeMachine.volumeOfWater -= water
            coffeeMachine.volumeOfMilk -= milk
            coffeeMachine.gramsOfCoffeeBeans -= coffeeBeans
            coffeeMachine.disposableCups--
            coffeeMachine.moneyInCash += cost
        }
        else {
            println("Sorry, not enough ${n.name.toLowerCase().replace('_', ' ')}!")
        }
    }

    fun canBuy(coffeeMachine: CoffeeMachine): Ingredient {
        when {
            coffeeMachine.volumeOfWater < water -> {
                return Ingredient.WATER
            }
            coffeeMachine.volumeOfMilk < milk -> {
                return Ingredient.MILK
            }
            coffeeMachine.gramsOfCoffeeBeans < coffeeBeans -> {
                return Ingredient.COFFEE_BEANS
            }
            coffeeMachine.disposableCups < 1 -> {
                return Ingredient.DISPOSABLE_CUPS
            }
            else -> {
                return Ingredient.COST
            }
        }
     }
}