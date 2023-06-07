package mysteram.myreader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;

public class ReadLineExampleApp {
    public static void main(String[] args) throws Exception {
        // 문자열 입출력 스트림은 Reader / Writer 로 끝낸다.

        // 읽어오기
        Reader reader = new FileReader("C:\\Programing\\gookbi\\gookbi-practice\\temp\\language.txt");

        // 읽기속도 향상
        BufferedReader br = new BufferedReader(reader);

        // 파일내용 가져오기
        while (true) {
            // 파일로부터 라인단위("\n" 또는 "\r\n" 으로 끝나는 경우)로 읽기
            String data = br.readLine();
            if (data == null) break;

            System.out.println("data = " + data);
        }

        br.close();
    }
}
