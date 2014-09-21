import java.io.File;

public class Main {
    public static void main(String[] args) {
        File path = new File(args.length > 0? args[0]: ".");
        System.out.println(path.getName());
        walk("", path.listFiles());
    }

    public static void walk(String prefix, File[] list) {
        for (int i = 0; i < list.length; i++) {
            File path = list[i];
            System.out.printf("%s%c-- %s\n", prefix, (i < list.length - 1? '|': '`'), path.getName());
            if (path.isDirectory()) {
                walk(prefix.concat(i < list.length - 1? "|": " ").concat("   "), path.listFiles());
            }
        }
    }
}
