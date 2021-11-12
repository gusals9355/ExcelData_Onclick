package excel;

import lombok.Data;

import java.util.List;

@Data
public class ExcelData {
    private List<String> fileName;
    private String title;
    private String url;
    private List<String> column;
    private List<List<String>> sampleData;
}
