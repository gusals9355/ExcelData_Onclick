package excel;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

public class ExcelWrite {
    public static void write(ExcelData data){ // 샘플데이터 삽입 & 항목명 정제
        String path="C:/Users/user/Downloads/항목명표준화 등록요청 양식.xlsx";
        try {
            FileInputStream file = new FileInputStream(path);
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet=workbook.getSheetAt(0);

            for(int j=1; j<data.getColumn().size()+1; j++){
                for(int i=12; i<17; i++){ //샘플데이터
                    String sample = data.getSampleData().get(j-1).get(i-12);
                    sheet.getRow(j).createCell(i).setCellValue(sample);
                }
                String item = data.getColumn().get(j-1).replaceAll("[^\uAC00-\uD7A30-9a-zA-Z]","");
                sheet.getRow(j).createCell(7).setCellValue(item);
                sheet.getRow(j).createCell(8).setCellValue(item);
            }

            FileOutputStream outputStream = new FileOutputStream(path);
            workbook.write(outputStream);
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
}
