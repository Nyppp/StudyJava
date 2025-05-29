import java.io.*;

public class Main {
    public static void main(String[] args) {
        try {
            FileReader reader = new FileReader("sample.txt");
            reader.close();
        }catch (FileNotFoundException e){
            System.out.println("파일이 존재하지 않습니다 : " + e.getMessage());
        } catch (IOException e) {
            System.out.println("파일 닫는 중 오류 발생 : " + e.getMessage());
        }
    }
}
