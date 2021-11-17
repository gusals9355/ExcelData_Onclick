import org.mozilla.universalchardet.UniversalDetector;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        byte[] buf = new byte[4096];
        java.io.FileInputStream fis = new java.io.FileInputStream("C:/Users/user/Downloads/경상남도 창원시_창원시청 청사내 충전소 전기사용량_20210731.csv");
        UniversalDetector detector = new UniversalDetector(null);
        int nread;
        while ((nread = fis.read(buf)) > 0 && !detector.isDone()){
            detector.handleData(buf, 0, nread);
        }
        detector.dataEnd();
        String encoding = detector.getDetectedCharset();
        if (encoding != null) {
            System.out.println("Detected encoding = " + encoding);
        } else {
            System.out.println("No encoding detected.");
        }
        detector.reset();
    }
}
