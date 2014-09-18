path = "." as File
if (args) {
    path = args[0] as File
}
printDir path,0

def printDir(File path, int depth,boolean isLast = false) {
    if (depth > 0) {
        if (isLast)
            print '└'
        else
            print '├'
        print '── '
    }

    println path.name
    if (path.isDirectory()) {
        File[] files = path.listFiles()
        files.each {
            print ' '*depth*4
            if (it == files.last())
                printDir(it, depth+1, true)
            else
                printDir(it, depth+1)
        }
    }
}
