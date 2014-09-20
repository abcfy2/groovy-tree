path = "." as File
if (args) {
    path = args[0] as File
}
printDir path,0

def printDir(File path, int depth,boolean isLast = false, String nextLinePre = "") {
    if (depth > 0) {
        if (isLast) {
            print '└'
            nextLinePre += "    "
        } else {
            print '├'
            nextLinePre += "│   "
        }
        print '── '
    }

    println path.name
    if (path.isDirectory()) {
        File[] files = path.listFiles()
        files.each {
            print nextLinePre
            printDir(it, depth+1, it==files.last(), nextLinePre)
        }
    }
}
