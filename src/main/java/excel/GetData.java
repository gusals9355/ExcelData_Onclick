package excel;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class GetData {
    public static void getData(String filename, ExcelData data, int j, ArrayList<List<String>> list2) {
        BufferedReader br = null;
        String line;
        int index=0;
        ArrayList<String> list = new ArrayList<>();
        String encoding = "EUC-KR";
        try {
            if(!Encoding.getEncoding(filename).equals(encoding)){
                encoding = "UTF-8";
            }
            br = new BufferedReader(new InputStreamReader(new FileInputStream("C:/Users/user/Downloads/"+filename), encoding));
            int cnt=-1;
            while((line = br.readLine()) != null) {
                String[] temp = line.split(","); // 쉼표로 구분
                cnt++;
                for(int i=0; i<temp.length; i++) {
//                    System.out.print((i+1)+"열: "+temp[i]);
                    temp[i]=temp[i].replace(" ","");
                    temp[i]=temp[i].replace("\"","");
                    if(temp[i].equals(data.getColumn().get(j))) {
                        index=i;
                        continue;
                    }

                    if(cnt != 0 && index == i && list.size()<5){
                        if(temp[index].equals("")){
                            continue;
                        }
                        list.add(temp[index]);
                    }
//                    if(i!=temp.length-1) System.out.print(", ");
//                    else System.out.println();
                }
            }
            //데이터가 없을경우 N/A처리
            if(list.size()==0){
                list.add("N/A");
                list.add("N/A");
                list.add("N/A");
                list.add("N/A");
                list.add("N/A");
            }else if(list.size()<5){
                while(list.size()<5){
                    list.add("");
                }
            }
            list2.add(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
