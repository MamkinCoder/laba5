import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class FileIO {

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

    public PriorityQueue<Food> readQueue(String path, PriorityQueue<Food> readed) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(path));
        while (scanner.hasNext()){
            String line = scanner.nextLine();
            if (line.equals("")) continue;
            readed.add(parseFood(line));
        }
        return readed;
    }


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

            //Specify the file name and path here
            File file = new File("out_data.csv");

	 /* This logic will make sure that the file
	  * gets created if it is not present at the
	  * specified location*/
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
