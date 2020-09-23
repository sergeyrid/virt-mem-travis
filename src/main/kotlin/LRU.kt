// Returns the queue and a page, that was removed from memory (if none, returns -1)
fun processOneLRU(queue: MutableList<Int>, memorySize: Int, page: Int): Pair<MutableList<Int>, Int> {
    var substPage = -1
    if (queue.contains(page)) {
        substPage = page
        queue.remove(page)
    } else if (queue.size >= memorySize) {
        substPage = queue[0]
        queue.removeAt(0)
    }
    queue.add(page)
    return queue to substPage
}

