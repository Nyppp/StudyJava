import java.io.*;

public class Practice2 {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("source.txt"));
            BufferedWriter writer = new BufferedWriter(new FileWriter("copy.txt"));
            String line;
            while((line = reader.readLine()) != null){
                writer.write(line);
                writer.newLine();
            }
            System.out.println("파일 복사 성공.");

            reader.close();
            writer.close();
        } catch (FileNotFoundException e) {
            System.out.println("파일이 존재하지 않습니다. : " + e.getMessage());
        } catch (IOException e){
            System.out.println("파일 처리 중 오류가 발생했습니다 : " + e.getMessage());
        } finally {
            System.out.println("프로그램을 종료합니다.");
        }
    }
}
