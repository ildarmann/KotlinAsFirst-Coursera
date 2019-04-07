@file:Suppress("UNUSED_PARAMETER")

package lesson1.task1

import kotlin.math.*

/**
 * Пример
 *
 * Вычисление квадрата целого числа
 */
fun sqr(x: Int) = x * x

/**
 * Пример
 *
 * Вычисление квадрата вещественного числа
 */
fun sqr(x: Double) = x * x

/**
 * Пример
 *
 * Вычисление дискриминанта квадратного уравнения
 */
fun discriminant(a: Double, b: Double, c: Double) = sqr(b) - 4 * a * c

/**
 * Пример
 *
 * Поиск одного из корней квадратного уравнения
 */
fun quadraticEquationRoot(a: Double, b: Double, c: Double) =
        (-b + sqrt(discriminant(a, b, c))) / (2 * a)

/**
 * Пример
 *
 * Поиск произведения корней квадратного уравнения
 */
fun quadraticRootProduct(a: Double, b: Double, c: Double): Double {
    val sd = sqrt(discriminant(a, b, c))
    val x1 = (-b + sd) / (2 * a)
    val x2 = (-b - sd) / (2 * a)
    return x1 * x2 // Результат
}

/**
 * Пример главной функции
 */
fun main(args: Array<String>) {
//    val x1x2 = quadraticRootProduct(1.0, 13.0, 42.0)
//    println("Root product: $x1x2")
    val x = 7
    val result = sqr(x)
    println("$x * $x = $result")
}

/**
 * Преобразуем минуты в секунды
 */
fun min2sec(minutes: Int) = minutes * 60

/**
 * Преобразуем часы в секунды
 */
fun hours2sec(hours: Int) = min2sec(hours * 60)

/**
 * Тривиальная
 *
 * Пользователь задает время в часах, минутах и секундах, например, 8:20:35.
 * Рассчитать время в секундах, прошедшее с начала суток (30035 в данном случае).
 */
fun seconds(hours: Int, minutes: Int, seconds: Int): Int = seconds + min2sec(minutes) + hours2sec(hours)

/**
 * Преобразуем вершки в метры
 */
fun vershoks2meters(vershoks: Int): Double = vershoks * 4.445 / 100

/**
 * Преобразуем аршины в вершки
 */
fun arshins2vershoks(arshins: Int): Int = arshins * 16

/**
 * Преобразуем сажни в аршины
 */
fun sagenes2arshins(sagenes: Int): Int = sagenes * 3

/**
 * Тривиальная
 *
 * Пользователь задает длину отрезка в саженях, аршинах и вершках (например, 8 саженей 2 аршина 11 вершков).
 * Определить длину того же отрезка в метрах (в данном случае 18.98).
 * 1 сажень = 3 аршина = 48 вершков, 1 вершок = 4.445 см.
 */
fun lengthInMeters(sagenes: Int, arshins: Int, vershoks: Int): Double {
    return vershoks2meters(
            vershoks
                    + arshins2vershoks(arshins)
                    + arshins2vershoks(sagenes2arshins(sagenes))
    )
}


/**
 * Преобразуем градусы в минуты
 */
fun deg2min(deg: Int): Int = deg * 60

/**
 * Преобразуем секунды в радианы
 */
fun sec2radian(sec: Int): Double = sec / 206265.0

/**
 * Тривиальная
 *
 * Пользователь задает угол в градусах, минутах и секундах (например, 36 градусов 14 минут 35 секунд).
 * Вывести значение того же угла в радианах (например, 0.63256).
 * 1 рад = 57 градусов 17 мин 45 сек = 57 * 60 * 60 + 17 * 60 + 45 сек = 205200 + 1020 + 45 = 206 265 сек
 */
fun angleInRadian(deg: Int, min: Int, sec: Int): Double {
    return sec2radian(
            sec
                    + min2sec(min)
                    + min2sec(deg2min(deg))
    )
}

/**
 * Тривиальная
 *
 * Найти длину отрезка, соединяющего точки на плоскости с координатами (x1, y1) и (x2, y2).
 * Например, расстояние между (3, 0) и (0, 4) равно 5
 */
fun trackLength(x1: Double, y1: Double, x2: Double, y2: Double): Double {

    val cathetusSquaresSum = sqr(x2 - x1) + sqr(y2 - y1)
    return sqrt(cathetusSquaresSum)
}

/**
 * Простая
 *
 * Пользователь задает целое число, большее 100 (например, 3801).
 * Определить третью цифру справа в этом числе (в данном случае 8).
 */
fun thirdDigit(number: Int): Int = (number / 100) % (10)


/**
 * Преобразуем часы в минуты
 */
fun hours2min(hours2min: Int): Int = hours2min * 60

/**
 * Простая
 *
 * Поезд вышел со станции отправления в h1 часов m1 минут (например в 9:25) и
 * прибыл на станцию назначения в h2 часов m2 минут того же дня (например в 13:01).
 * Определите время поезда в пути в минутах (в данном случае 216).
 */
fun travelMinutes(hoursDepart: Int, minutesDepart: Int, hoursArrive: Int, minutesArrive: Int): Int =
        (hours2min(hoursArrive) + minutesArrive) - (hours2min(hoursDepart) + minutesDepart )

/**
 * Простая
 *
 * Человек положил в банк сумму в s рублей под p% годовых (проценты начисляются в конце года).
 * Сколько денег будет на счету через 3 года (с учётом сложенных процентов)?
 * Например, 100 рублей под 10% годовых превратятся в 133.1 рубля
 */
fun accountInThreeYears(initial: Int, percent: Int): Double {

    var result: Double = initial.toDouble()
    for (year in 1..3) {
        result += result * percent / 100
    }
    return result
}



/**
 * Получить цифру из числа по указанному порядку в числе
 * @param number число для вычленения из него цифры
 * @param at номер позиции цифры в числе. <BR/>
 *  - номер первой позиции = 0<BR/>
 *  - нумерация с права налево<BR/>
 */
fun getDigit(number: Int, at: Int): Int {
    val result = (number / (Math.pow(10.toDouble(), at.toDouble()))) % 10
    return result.toInt()
}

/**
 * Простая
 *
 * Пользователь задает целое трехзначное число (например, 478).
 * Необходимо вывести число, полученное из заданного перестановкой цифр в обратном порядке (например, 874).
 */
fun numberRevert(number: Int): Int {
    var result = 0.0
    for (i in 0..2) {
        result += getDigit(number, i) * Math.pow(10.toDouble(), 2 - i.toDouble())
    }
    return result.toInt()

}
