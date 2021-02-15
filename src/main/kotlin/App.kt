fun main() {
    /* Задание 1 */
    val myClosure = { println("I love Kotlin") }
    repeatTask(10, myClosure)

    /* Задание 2 */
    demoMoving()

    /* Задание 3 */
    val rectangle = Rectangle(4, 6)
    val square = Square(10)
    val circle = Circle(2)

    println("Периметр прямоугольника: ${rectangle.perimeter()}.\n" +
            "Площадь примоугольника: ${rectangle.area()}.\n")
    println("Периметр квадрата: ${square.perimeter()}.\n" +
            "Площадь квадрата: ${square.area()}.\n")
    println("Периметр круга: ${circle.perimeter()}.\n" +
            "Площадь круга: ${circle.area()}.\n")
}

/* Функция для запуска лямбда-выражения task times раз */
fun repeatTask(times: Int, task: () -> Unit) {
    for (i in 0 until times)
        task()
}

/* Функция, принимающая координаты и направление поворота */
fun move(location: Point, direction: Directions): Point {
    when (direction.name) {
        "UP" -> location.y++
        "DOWN" -> location.y--
        "LEFT" -> location.x--
        "RIGHT" -> location.x++
    }
    return location
}

/* Функция, осуществляющая несколько преходов от первоначальной координаты
* и выводящая координату после каждого перехода */
fun demoMoving() {
    var location = Point(0, 0)
    val directions = arrayOf(
        Directions.UP, Directions.UP,
        Directions.LEFT, Directions.DOWN,
        Directions.LEFT, Directions.DOWN,
        Directions.DOWN, Directions.RIGHT,
        Directions.RIGHT, Directions.DOWN, Directions.RIGHT
    )

    for (dir in directions) {
        location = move(location, dir)
        println("Движение: ${dir.name}.\nТекущие координаты: (${location.x};${location.y}).\n")
    }
}

/* Перечисление направлений движений */
enum class Directions {
    UP, DOWN, LEFT, RIGHT
}

/* Интерфейс для площади и периметра */
interface Shape {
    fun perimeter(): Int
    fun area(): Int
}

/* Класс прямоугольника */
class Rectangle(var width: Int, var height: Int) : Shape {
    override fun perimeter(): Int {
        return 2 * (width + height)
    }

    override fun area(): Int {
        return width * height
    }
}

/* Класс квадрата */
class Square(var a: Int) : Shape {
    override fun perimeter(): Int {
        return 4 * a
    }

    override fun area(): Int {
        return a * a
    }
}

/* Класс круга */
class Circle(var diameter: Int) : Shape {
    override fun perimeter(): Int {
        return (Math.PI * diameter).toInt()
    }

    override fun area(): Int {
        return (0.25 * diameter * diameter * Math.PI).toInt()
    }
}

/* Класс точки для второго задания */
class Point(var x: Int, var y: Int) {}