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
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Excel{
    public static void main(String[] args) {
        ExcelData excelData = new ExcelData();
        ExcelDown.down(excelData);
        ArrayList<List<String>> sample = new ArrayList<>();
        for(int i=0; i<excelData.getColumn().size(); i++){
            GetData.getData(excelData.getFileName().get(i), excelData, i, sample);
        }
        excelData.setSampleData(sample);
        ExcelWrite.write(excelData);
    }
}