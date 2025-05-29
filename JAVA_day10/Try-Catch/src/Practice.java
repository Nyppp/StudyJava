import java.io.*;
import java.util.Scanner;

public class Practice {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("읽을 파일 이름을 입력하세요 : ");
        String fileName = sc.nextLine();

        //try : 예외처리를 진행할 코드 부분
        //catch : 특정 예외가 발생했을 때 처리할 부분
        //finally : 코드 성공이 실행하든, 예외가 발생하든 실행 할 코드
        try {
            readFile(fileName);
            System.out.println("파일 읽기 완료");
        }catch (FileNotFoundException e){
            System.out.println("파일이 존재하지 않습니다 : " + fileName);
        }catch (IOException e){
            System.out.println("파일을 읽는 중에 오류가 발생했습니다 : "+e.getMessage());
        }finally {
            sc.close();
        }
    }
    public static void readFile(String fileName) throws IOException{
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line;
        while((line = reader.readLine()) != null){
            System.out.println(line);
        }
        reader.close();
    }
}
