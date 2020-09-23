// Returns the queue and a page, that was removed from memory (if none, returns -1)
fun processOne(queue: MutableList<Int>, memorySize: Int, page: Int): Pair<MutableList<Int>, Int> {
    var deletedPage = -1
    if (queue.contains(page)) {
        queue.remove(page)
    } else if (queue.size >= memorySize) {
        deletedPage = queue[0]
        queue.removeAt(0)
    }
    queue.add(page)
    return queue to deletedPage
}
