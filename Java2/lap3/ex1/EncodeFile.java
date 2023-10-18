package java2Laps.lap3.ex1;
import java.io.*;
public class EncodeFile {
    public String readFile(String fp){
        String st = "";
        try {
            File f = new File(fp);
            FileInputStream fis = new FileInputStream(f);
            BufferedInputStream bis = new BufferedInputStream(fis);
            int i;
            while ((i = bis.read()) != -1){
                System.out.println((char) (i+3));
                st += (char) (i+3);
            }
            System.out.println("");
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return st;
    }
    public void writeFile(String str){
        //chuyen chuoi thanh byte
        byte[] b = str.getBytes();
        try {
            FileOutputStream fos = new FileOutputStream("ex12.txt");
            fos.write(b);
            fos.flush();
            fos.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        EncodeFile ef = new EncodeFile();
        ef.writeFile(ef.readFile("ex1.txt"));
    }
}
