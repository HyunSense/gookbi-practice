package mysteram.myreader;

import java.io.*;

public class NonBufferVsBufferExampleApp {
    public static void main(String[] args) throws Exception {
        // 현재 프로그램 경로의 실제위치를 가져와라
        String originalFilePath1 =
                NonBufferVsBufferExampleApp.class.getResource("originalFile1.jpg").getPath();

        // 복사할 경로를 가르키는 문자열
        String targetFilePath1 = "C:\\Programing\\gookbi\\gookbi-practice\\temp\\targetFile1.jpg";

        // 실제 파일을 읽어오는 스트림 (InputStream)
        FileInputStream fis = new FileInputStream(originalFilePath1);

        // 파일을 저장할 스트림 (OutputStream)
        FileOutputStream fos = new FileOutputStream(targetFilePath1);

        // 버퍼스트림을 이용해서 original의 파일내용을 target파일에 저장(=복사)
        String originalFilePath2
                = NonBufferVsBufferExampleApp.class.getResource("originalFile2.jpg").getPath();
        String targetFilePath2 = "C:\\Programing\\gookbi\\gookbi-practice\\temp\\targetFile2.jpg";

        FileInputStream fis2 = new FileInputStream(originalFilePath2);
        FileOutputStream fos2 = new FileOutputStream(targetFilePath2);
        BufferedInputStream bis = new BufferedInputStream(fis2);
        BufferedOutputStream bos = new BufferedOutputStream(fos2);

        // 실제 파일카피를 진행하는 부분(= NonBuffered)
        long nonBufferTime = copy(fis, fos);
        System.out.println("버퍼를 사용하지 않았을 때 : \t" + nonBufferTime + "ms");

        // 실제 파일카피를 진행하는 부분(= Buffered)
        long bufferTime = copy(bis, bos);
        System.out.println("버퍼를 사용했을 때 : \t" + bufferTime + "ms");


        // 열린 입출력 스트림 닫기
        fis.close();
        fos.close();
        bis.close();
        bos.close();
    }
    // 정적멤버 메소드에서 사용할 정적변수 하나 선언
    static int data = -1; // 입력 스트림으로 부터 1바이트의 데이터를 읽을 때 그 데이터를 저장할 변수

    // 데이터를 복사하는 copy 메서드 구현
    public static long copy(InputStream is, OutputStream os) throws Exception {
        long start = System.nanoTime(); // 시작시간을 저장하는 변수

        // 입력스트림이 출력스트림으로 복사하는 루틴
        // 입력스트림의 크기를 모름으로 무한루프
        while (true) {
            data = is.read(); // 입력스트림으로부터 1바이트 읽어오기
            if (data == -1) break; // 입력스트림으로붵 읽은 값이 -1 이면 파일의 끝
            os.write(data); // 실제데이터를 출력스트림에 저장
        }
        os.flush();

        long end = System.nanoTime();

        long diff = (end - start); // 시간차이
        return diff;
    }
}
