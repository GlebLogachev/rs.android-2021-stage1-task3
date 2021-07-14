package subtask1

class Combinator {
    fun checkChooseFromArray(array: Array<Int>): Int? {
        val m = array[0]
        val n = array[1]
        val nFactorial = factorial(n)
        for (i in 1..n) {
            val differenceNAndI = n - i
            val factorialDifferenceNAndI = factorial(differenceNAndI)
            val iFactorial = factorial(i)
            val result = nFactorial / factorialDifferenceNAndI / iFactorial
            
            if (result >= m) return i
        }
        return null
    }

    private fun factorial(n: Int): Long {
        var factorial = 1L
        for (i in 1..n) {
            factorial *= i
        }
        return factorial
    }
}
