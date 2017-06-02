import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

/** Запись - чтение из файла.
        * @author Ярослав
        * @author Денис
        * @version over 9000
        * @since 1.0
        */

public class FileIO {

        /** Читаем коллекцию из файла.
         * @param path путь к файлу.
         * @throws FileNotFoundException исключение если файл не найден.
         * @return прочитанную коллекцию.
         */

    public PriorityQueue<Food> readQueue(String path) throws FileNotFoundException {
        PriorityQueue<Food> readed = new PriorityQueue<>();
        Scanner scanner = new Scanner(new File(path));
        while (scanner.hasNext()){
            String line = scanner.nextLine();
            if (line.equals("")) continue;
            readed.add(parseFood(line));
        }
        return readed;
    }

    /** Перегруженный метод.
     * @param path путь к файлу.
     * @throws FileNotFoundException исключение если файл не найден.
     * @return прочитанную коллекцию.
     */

    public PriorityQueue<Food> readQueue(String path, PriorityQueue<Food> readed) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(path));
        while (scanner.hasNext()){
            String line = scanner.nextLine();
            if (line.equals("")) continue;
            readed.add(parseFood(line));
        }
        return readed;
    }


    /** Парсер из csv в джавочку.
     * @param line строка.
     * @return объект класса Food.
     */

    private Food parseFood(String line) {
        Food food = new Food();
        String[] fields = line.split(",");
        try {
            String[] date = fields[0].trim().split("-");
            food.setDate(Integer.parseInt(date[0]),Integer.parseInt(date[1]),Integer.parseInt(date[2]));
            food.setTaste(Food.TASTE.valueOf(fields[2].trim()));
            food.setName(fields[1].trim());
        } catch (Exception e){
            System.out.println("Wrong input line : " + line);
        }
        return food;
    }

    /** Запись в файл коллекции.
     * @param queue что записываем.
     * @return "успешно записан", если успешно записан
     */

    public void writeQueue(PriorityQueue<Food> queue){
        BufferedWriter bw = null;
        Iterator it = queue.iterator();
        String mycontent = "";

        while(it.hasNext()) {
            Food food = (Food)it.next();
            String date = new SimpleDateFormat("yyyy-MM-dd").format(food.getExpirationDate().getTime());
            String name = food.getName();
            String taste = food.getTaste().toString();
            mycontent += date + " , " + name + " , " + taste + "\r\n";
        }
        try {

            File file = new File("out_data.csv");

            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file);
            bw = new BufferedWriter(fw);
            bw.write(mycontent);
            System.out.println("Файл успешно записан");

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        finally
        {
            try{
                if(bw!=null)
                    bw.close();
            }catch(Exception ex){
                System.out.println("Ошибка в закрытии BufferedReader"+ex);
            }
        }

    }
}
