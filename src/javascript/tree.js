var walk = function(prefix, list) {
    for (var i = 0; i < list.length; i++) {
        var node = list[i];
        println(prefix + (i < list.length - 1? '├': '└') + '──' + node.getName());
        if (node.isDirectory()) {
            walk(prefix + (i < list.length - 1? '│   ': '    '), node.listFiles());
        }
    }
};

var path = arguments.length? arguments[0]: '.';
println(path);
walk('', new java.io.File(path).listFiles());
