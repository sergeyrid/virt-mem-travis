// Returns the queue and a page, that was removed from memory (if none, returns -1)
fun processOneFIFO(queue: MutableList<Int>, memorySize: Int, page: Int): Pair<MutableList<Int>, Int> {
    var substPage = -1
    when {
        queue.contains(page) -> {
            substPage = page
        }
        queue.size < memorySize -> {
            queue.add(page)
        }
        else -> {
            substPage = queue[0]
            queue.removeAt(0)
            queue.add(page)
        }
    }
    return queue to substPage
}

