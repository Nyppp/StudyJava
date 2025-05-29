import java.io.File;
import java.io.IOException;

import javax.print.Doc;
import javax.xml.parsers.*;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

public class XmlParserExample {
    public static void main(String[] args) {
        try{
            //XML 파서 생성
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder(); //파서 생성에 대한 에러 처리 필요

            //파서 > XML 파싱
            Document doc = builder.parse(new File("config.xml")); //파싱 에러, 파일 처리 에러 2가지 필요
            doc.getDocumentElement().normalize();
            
            //<app> 태그에서 name 속성 가져오기
            NodeList list = doc.getElementsByTagName("app");
            if(list.getLength() > 0){
                Element appElement = (Element) list.item(0);
                String name = appElement.getAttribute("name");
                System.out.println("앱 이름 : " + name);
            }else{
                System.out.println("<app> 태그가 존재하지 않습니다.");
            }
        }catch (ParserConfigurationException e){
            System.out.println("파서 설정 오류입니다.");
        }catch (SAXException e){
            System.out.println("XML 구문 오류입니다.");
        }catch (IOException e){
            System.out.println("파일을 찾거나 읽는 중 오류가 발생했습니다.");
        }
    }
}
