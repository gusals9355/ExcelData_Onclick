package excel;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Array;
import java.util.*;

public class ExcelDown{
    public static void down(ExcelData data){
        try {
            FileInputStream file = new FileInputStream("C:/Users/user/Downloads/항목명표준화 등록요청 양식.xlsx");
            XSSFWorkbook workbook = new XSSFWorkbook(file);

            XSSFSheet sheet=workbook.getSheetAt(0);
            //행의 수
            int rows=sheet.getPhysicalNumberOfRows();
            LinkedHashSet<String> set = new LinkedHashSet<>();
            LinkedHashSet<String> set2 = new LinkedHashSet<>();
            ArrayList<String> list = new ArrayList();
            List<String> list2 = new ArrayList<>();
            for(int rowindex=1;rowindex<rows+1;rowindex++){
                //행을읽는다
                XSSFRow row=sheet.getRow(rowindex);
                if(row !=null){
                    //셀의 수
                    for(int columnindex=4;columnindex<=6;columnindex++){
                        //셀값을 읽는다
                        XSSFCell cell=row.getCell(columnindex);
                        String value="";
                        //셀이 빈값일경우
                        if(cell==null){
                            continue;
                        }else{
                            //타입별로 내용 읽기
                            switch (cell.getCellType()){
                                case XSSFCell.CELL_TYPE_FORMULA:
                                    value=cell.getCellFormula();
                                    break;
                                case XSSFCell.CELL_TYPE_NUMERIC:
                                    value=cell.getNumericCellValue()+"";
                                    break;
                                case XSSFCell.CELL_TYPE_STRING:
                                    value=cell.getStringCellValue()+"";
                                    break;
                                case XSSFCell.CELL_TYPE_BLANK:
                                    value=cell.getBooleanCellValue()+"";
                                    break;
                                case XSSFCell.CELL_TYPE_ERROR:
                                    value=cell.getErrorCellValue()+"";
                                    break;
                            }
                        }
                        if(columnindex==4){
                            set2.add(value); //파일데이터명
                            list2.add(value+".csv");
                        }else if(columnindex==5){
                            set.add(value); //url
                        }else{
                            value=value.replace(" ","");
                            list.add(value);
                        }
                    }
                }
            }
            data.setFileName(list2);
            data.setColumn(list);
            //파일 다운로드
            Iterator iter = set.iterator();
            Iterator iter2 = set2.iterator();

            while(iter.hasNext()){
                String title = (String)iter2.next()+".csv";
                String url = (String)iter.next();
                data.setTitle(title);
                data.setUrl(url);
                Path path = Paths.get("C:/Users/user/Downloads",title); //저장 경로
                InputStream in = new URL(url).openStream();
                Files.copy(in, path);
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
}
