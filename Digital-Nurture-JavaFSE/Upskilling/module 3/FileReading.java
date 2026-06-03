import java.io.*;
public class FileReading{
    public static void main(String[] args){
        try{
            FileReader reader=new FileReader("D:\\college\\HTML TUTORIAL\\Digital Nurture JavaFSE\\Upskilling\\Core Java\\output.txt");
            int i;
            while((i=reader.read())!=-1){
                System.out.print((char) i);
            }
            reader.close();
        }catch(IOException e){
            System.out.println("an error occurred");
            e.printStackTrace();
        }
    }
}