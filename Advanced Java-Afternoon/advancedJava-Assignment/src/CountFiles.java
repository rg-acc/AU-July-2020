import java.io.File;
import java.io.FileFilter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class CountFiles {
    //to count no of files and directories in given path
    public static void fileAndDirectoryCount(String path){

        File file = new File(path);
        long total_count = file.listFiles().length;

        File[] directories = file.listFiles(new FileFilter() {
            @Override
            public boolean accept(File ele) {
                return ele.isDirectory();
            }
        });
        long file_count = total_count-directories.length;
        System.out.println("Total number of files in this path:" + file_count);
        System.out.println("Total number of folders in this path:" + directories.length);



    }

    //to count no. total files in path + folder + subfolder
    public static long iterativeFileCount(Path dir) throws Exception{

        return Files.walk(dir)
                .parallel()
                .filter(p -> !p.toFile().isDirectory())
                .count();
    }

    public static void main(String[] args) {
        //input path
        String inputPath = "/home/rg/Desktop/furniture";
        Path dir = Paths.get(inputPath);
        try {

            fileAndDirectoryCount(inputPath);
            long count = iterativeFileCount(dir);
            System.out.println("total file count(including files in folder and subfolders as well:)"+ count);
        }
        catch(Exception e) {
            System.out.println(e);
        }

    }

}







