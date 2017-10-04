package folding

object FoldLeftInt extends App {

    val a = List(1,2,3,4)

    def add(a: Int, b: Int) = a + b

    println(foldLeft(0)(a)(add))

    def foldLeft(lastResult: Int)(list: List[Int])(f: (Int, Int) => Int): Int = list match {
        case Nil => lastResult
        case x :: xs => {
            val result = f(lastResult, x)
            println(s"last: $lastResult, x: $x, result = $result")
            foldLeft(result)(xs)(f)
        }
    }

}


