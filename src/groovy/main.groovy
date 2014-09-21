def walk(list, prefix = "") {
    list.each {
        println prefix + (it == list.last()? "`": "|") + "-- " + it.name
        if (it.isDirectory()) {
            walk(it.listFiles(), prefix + (it == list.last()? "    ": "|   "))
        }
    }
}

path = (args.length? args[0]: ".") as File
println path.name
walk(path.listFiles())
