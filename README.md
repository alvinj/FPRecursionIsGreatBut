Recursion is Great, But ...
===========================

This repository is for the “Recursion is Great, But ...”
lesson in my book, [Learning Functional Programming in 
Scala](https://alvinalexander.com/scala/learning-functional-programming-in-scala-book).


## Source code

The source code for the last two objects in this lesson are in the
*src/main/scala/folding* folder. The remainder of the source code
consists of the following “source code snippets.” The snippets of
code are listed in the order in which they are presented in the 
lesson.

---

    val list = List(1, 2, 3, 4)

    def sum(list: List[Int]): Int = list match {
        case Nil => 0
        case x :: xs => x + sum(xs)
    }

    def product(list: List[Int]): Int = list match {
        case Nil => 1
        case x :: xs => x * product(xs)
    }

---

    def sum(list: List[Int]): Int = list.reduce(_ + _)
    def sum(list: List[Int]): Int = list.reduce((x,y) => x + y)
    val a = List(1,2,3,4)
    sum(a)

---

    def add(x: Int, y: Int): Int = {
        val theSum = x + y
        println(s"received $x and $y, their sum is $theSum")
        theSum
    }

    val a = List(1,2,3,4)
    a.reduceLeft(add)

    a.reduceLeft(product)

---

    def max(a: Int, b: Int) = {
        val max = if (a > b) a else b
        println(s"received $a and $b, their max is $max")
        max
    }
    val xs = List(11, 7, 14, 9)
    xs.reduceLeft(max)

---

val a = List(1, 2, 5, 10)
a.reduceLeft(add)

---

    val peeps = Vector("al", "hannah", "emily", "christina", "aleka")
    peeps.reduceLeft((x,y) => if (x.length > y.length) x else y)
    peeps.reduceLeft((x,y) => if (x.length < y.length) x else y)

    def longest(x: String, y: String) = if (x.length > y.length) x else y
    def shortest(x: String, y: String) = if (x.length < y.length) x else y

    peeps.reduceLeft(longest)
    peeps.reduceLeft(shortest)
    
    val x = List("foo", "bar", "baz")
    x.reduceLeft(_ + _)

---

    val a = List(1,2,3,4)
    a.reduceLeft(_ + _)
    a.reduceRight(_ + _)
    
    val a = List(1,2,3,4)
    a.reduceLeft(_ - _)
    a.reduceRight(_ - _)

---

    val a = List(1,2,3,4)
    a.reduceRight(add(_,_))

---

    val a = Seq(1, 2, 3)
    a.reduceLeft(_ + _)
    a.foldLeft(20)(_ + _)
    a.foldLeft(100)(_ + _)
    
    def add (x: Int, y: Int): Int = {
        val theSum = x + y
        println(s"received $x and $y, their sum is $theSum")
        theSum
    }
    
    val a = Seq(1, 2, 3)
    a.foldLeft(100)(add)
    
    a.foldRight(100)(add)

---

    def add (x: Int, y: Int): Int = {
        val theSum = x + y
        println(s"received $x and $y, their sum is $theSum")
        theSum
    }
    
    val a = Seq(1, 2, 3)
    a.scanLeft(10)(add)
    
    a.scanRight(10)(add)

---

    def foldLeft(a: Int)(xs: List[Int])(f: (Int, Int) => Int): Int = {
    
        // 1st application
        val result1 = f(a, xs(0))
    
        // 2nd application
        val result2 = f(result1, xs(1))
    
        // 3rd application
        val result3 = f(result2, xs(2))

        result3
    }

---

Alvin Alexander    
http://alvinalexander.com




