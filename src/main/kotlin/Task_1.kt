//Компьютер загадывает 4-ч значное число, которое состоит из цифр 0-9.
//Пользователь пытается угадать это число, вводя числа до тех пор, пока не выиграет
//Bulls - цифра числа угадана верно
//Cows - цифра есть в загаданном числе, но не на своем месте

fun main() {
    val botChislo = genBotChislo()
    var separator = ""
    println("\nКомпьютер загадал число:\n${botChislo.joinToString(separator)}")

    var userChislo: List<Int>
    var resultGame: Pair<Int, Int>

    do {
        userChislo = inputUserChislo()
        resultGame = scanerList(botChislo, userChislo)

        println("\nВаш результат: \nБыки: ${resultGame.first} \nКоровы: ${resultGame.second}")

        if (resultGame.first < 4) println("\nПопробуйте еще раз((")
        else println("\nYOU WINNER!!")
    }
    while (resultGame.first < 4)
}