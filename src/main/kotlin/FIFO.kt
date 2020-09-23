// Returns stack and a page, that was removed from memory (if none, returns -1)
fun processOne(stack: MutableList<Int>, limit: Int, page: Int): Pair<MutableList<Int>, Int> {
    var deletedPage = -1
    if (stack.contains(page)) {
        stack.remove(page)
    } else if (stack.size >= limit) {
        deletedPage = stack[0]
        stack.removeAt(0)
    }
    stack.add(page)
    return stack to deletedPage
}