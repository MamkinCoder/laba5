import java.io.File;
import java.io.FileNotFoundException;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.io.BufferedOutputStream;

public class FileIO {



    public void ReadQueue(String fileName) {
try {
    File file = new File(fileName);
    Scanner scanner = new Scanner(file);
    while (scanner.hasNext()) {
        System.out.println(scanner.next());
    }
    scanner.close();
}catch (FileNotFoundException kaka){
    kaka.printStackTrace();
}

    }

    public void WriteQueue(String path){
        //тутачки нужно написать запись
    }

}
