package excel;


import org.mozilla.universalchardet.UniversalDetector;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Encoding {
    public static String getEncoding(String filename) throws IOException {
        byte[] buf = new byte[4096];
        java.io.FileInputStream fis = new java.io.FileInputStream("C:/Users/user/Downloads/"+filename);
        UniversalDetector detector = new UniversalDetector(null);
        int nread;
            while ((nread = fis.read(buf)) > 0 && !detector.isDone()){
            detector.handleData(buf, 0, nread);
        }
            detector.dataEnd();
        String encoding = detector.getDetectedCharset();

        System.out.println(filename + " " + encoding);
        return encoding;
    }
}
