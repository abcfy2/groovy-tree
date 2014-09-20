import java.io.File;

public class FileTree {
    public static void main(String[] args) {
        File path = new File(".");
        if (args.length > 0) {
            path = new File(args[0]);
        }
    
        new FileTree().printDir(path, 0, false, "");
    }
    
    public void printDir(File path, int depth, boolean isLast, String nextLinePre) {
        if (depth > 0) {
            if (isLast) {
                System.out.print("└");
                nextLinePre += "    ";
            } else {
                System.out.print("├");
                nextLinePre += "│   ";
            }
            System.out.print("── ");
        }

        System.out.println(path.getName());
        if(path.isDirectory()) {
            File[] files = path.listFiles();
            int i = 1;
            for (File file: files) {
                System.out.print(nextLinePre);
                printDir(file, depth+1, i==files.length, nextLinePre);
                i ++;
            }
        }
    }
}
