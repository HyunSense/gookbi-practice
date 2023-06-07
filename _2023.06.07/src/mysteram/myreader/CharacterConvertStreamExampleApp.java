package mysteram.myreader;

import java.io.*;

public class CharacterConvertStreamExampleApp {

    // throws Exception: 상위 호출객체인 OS(운영체제)가 처리하라는 의미
    public static void main(String[] args) throws IOException {
        write("문자 변환 스트림을 사용합니다.");
        String data = read();
        System.out.println(data);
    }

    public static void write(String str) throws IOException {
        // FileOutputStream으로 바이트 스트림 끄기
        FileOutputStream fos = new FileOutputStream("C:\\Programing\\gookbi\\gookbi-practice\\temp\\test.txt");
        // 바이트 스트림을 문자열 보조 스트림으로 연결
        Writer writer = new OutputStreamWriter(fos);
        // 문자열 단위로 출력
        writer.write(str);
        writer.flush(); // 데이터가 남아있는지 확인
        writer.close();
    }

    // FileInputSteram 클래스를 사용하여 한 파일을 읽어서 그 내용을 문자열로 리턴
    public static String read() throws IOException{
        // 파일의 내용을 읽어오려면 InputStream 필요
        // 파일이 준비되어있어야 예외 발생 안함
        FileInputStream fis = new FileInputStream("C:\\Programing\\gookbi\\gookbi-practice\\temp\\test.txt");

        // 바이트스트림을 문자열스트림으로 변경
        Reader reader = new InputStreamReader(fis);

        // 파일의 내용을 문자열 단위로 저장
        char[] buffer = new char[100];
        // 파일로부터 데이터를 읽을때 조금더 빠르게 읽기위해 buffer 사용
        int readCharSize = reader.read(buffer);
        reader.close();
        // char[] buffer의 내용을 문자열로 만든다.
        // 0부터 시작해서 지정한 크기만큼의 배열의 내용을 읽어 문자열로 바꿔라
        // 배열전체를 문자열로 바꿔라
        String data = new String(buffer, 0, readCharSize);
        return data;
    }
}
