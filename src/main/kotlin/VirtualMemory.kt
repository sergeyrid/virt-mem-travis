val memorySize = 10
val pages = listOf<Int>(1, 5, 12, 3 , 5, 2, 4, 6, 7, 8, 10, 1, 9, 8, 11, 3, 13, 12, 14, 15)

fun main() {
    val memory = arrayOf(-1, -1, -1, -1, -1, -1, -1, -1, -1, -1)
    print(processAll(memory, pages))
}