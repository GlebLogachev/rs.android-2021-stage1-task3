package subtask2
/*
Моя младшая сестра вернулась из школы со следующей задачей: получив квадратный лист бумаги, она должна
разрезать его на части, которые при сборке дают квадраты, стороны которых образуют возрастающую последовательность чисел.
Вначале это было очень весело, но мало-помалу мы устали видеть груду разорванной бумаги. Поэтому мы решили написать программу,
которая могла бы помочь нам и защитить деревья.
Задача
Дано положительное целое число n, вернуть строго возрастающую последовательность (массив) чисел, чтобы сумма квадратов была равна n².
Если существует несколько решений (а их будет), верните, насколько это возможно, результат с максимально возможными значениями:
Примеры
разложить 11 должен вернуть [1, 2, 4, 10]. Обратите внимание, что на самом деле есть два способа
разложить 11², 11² = 121 = 1 + 4 + 16 + 100 = 1² + 2² + 4² + 10², но не возвращайте [2, 6, 9], поскольку 9 меньше 10.
Для разложения 50 не возвращайте [1, 1, 4, 9, 49], но [1, 3, 5, 8, 49], поскольку [1, 1, 4, 9, 49]
не формируют строго возрастающую последовательность. .
Примечание
Ни [n], ни [1, 1, 1,…, 1] не являются допустимыми решениями. Если действительного решения не существует, верните ноль.
Функция «разложить» примет положительное значение Int n и вернет разложение N = n² как [x1 ... xk]
Если n отрицательное, также верните null.
Примеры:
разложить 50 результатов [1, 3, 5, 8, 49]
разложить 4 возвращает ноль
*
* */
class SquareDecomposer {

    fun decomposeNumber(number: Int): Array<Int>? {
        val squareNumber = number.toLong() * number.toLong()

        return squareDecompose(number, squareNumber)
    }

    private fun squareDecompose(number: Int, square: Long): Array<Int>? {
        for (i in number - 1 downTo 1) {
            if (i.toLong() * i.toLong() != square) {
                val diff = square - i.toLong() * i.toLong()
                if (diff > 0) {
                    val decomposeArray = squareDecompose(i, diff)
                    decomposeArray?.let {
                        return decomposeArray.plus(i)
                    }
                }
            } else return arrayOf(i)
        }
        return null
    }
}
