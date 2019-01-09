package adventOfCode2018

fun main(args: Array<String>) {
    val chosenDay: Day1? = Day1()

    chosenDay?.solve() ?: println("Please set chosenDay in main function")
}