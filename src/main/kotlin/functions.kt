import kotlin.math.abs

fun genBotChislo(): List<Int> {

    val diapozonZnach = (0..9) //диапазон допустимых значений для заполнения коллекции
    val diapozonZnachList = diapozonZnach.toMutableList()

    val BotChislo = mutableListOf<Int>()
    val sizeChislo = 4

    do {
        val index = (0..< diapozonZnachList.size).random()//рандомный выбор элемента по индексу из диапазона значений
        BotChislo += diapozonZnachList[index]//добавление этого элемента в коллекцию загаданного числа
        diapozonZnachList.removeAt(index)
    } while (BotChislo.size < sizeChislo)

    return BotChislo
}

fun inputUserChislo(): List<Int> {

    println("\nВведите 4-х значное число: ")
    var inpUserChislo: String = readln()

    val sizeChislo = 4
    var TRUEinpUserChislo: String

    //Если введено цифр больше 4, то мы обрабатываем строку, удаляя лишнии элементы с конца
    if (inpUserChislo.length > sizeChislo) {
        println("Число должно состоять и 4-х цифр!")

        TRUEinpUserChislo = inpUserChislo.substring(0, inpUserChislo.length - abs(4 - inpUserChislo.length))
        println("""
            Редактируем введенное число...
            
            Ваше число = ${TRUEinpUserChislo.toInt()}"""
        )
    } else {
        TRUEinpUserChislo = inpUserChislo
    }

    val UserChislo = mutableListOf<Int>()

    repeat(4) { //переводим строку в коллекцию
        UserChislo += TRUEinpUserChislo[it].toString().toInt()
    }

    return UserChislo
}

fun scanerList(botChislo: List<Int>, userChislo: List<Int>): Pair<Int, Int> {

    var bulls = 0
    var cows = 0

    val resultScanner = mutableSetOf<Int>()//коллекция для хранения не совпадающих элементов

    for (element in botChislo.indices) {
        if (botChislo[element] == userChislo[element]) bulls++
        else resultScanner.add(botChislo[element])
    }

    for (element in resultScanner.indices) {
        if (botChislo[element] != userChislo[element] && userChislo[element] in resultScanner) {
            cows++
            resultScanner.remove(botChislo[element])
        }
    }

    return Pair(bulls, cows)
}