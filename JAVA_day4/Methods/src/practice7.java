import java.lang.String;

public class practice7 {
    public static String getExtension(String fileName){
        if(fileName.lastIndexOf(".") < 0){
            return "";
        }

        return fileName.substring(fileName.lastIndexOf(".")+1, fileName.length());
    }


    public static void main(String[] args) {
        System.out.println(getExtension("document.pdf"));
        System.out.println(getExtension("archive.tar.gz"));
        System.out.println(getExtension("README"));
        System.out.println(getExtension(".......zip"));
    }
}
