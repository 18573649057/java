import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.*;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class PoiTest {
    @Test
    public void testWrite() throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet();
        XSSFRow row = sheet.createRow(1);
        XSSFCell cell = row.createCell(1);
        cell.setCellValue("曾彦士是我的儿wetryuiuioilkhjgfbvxdczsascdvxfbghjk.,hnbxv");
        File file = new File("abc.xlsx");
        FileOutputStream fo = new FileOutputStream(file);
        workbook.write(fo);
        fo.close();
        workbook.close();
    }

    @Test
    public void testRead() throws IOException {
        Workbook sheets = new XSSFWorkbook("/Users/pankelong/IdeaProjects/CompanySystem/abc.xlsx");
        Sheet sheetAt = sheets.getSheetAt(0);
        Row row1 = sheetAt.getRow(1);
        Cell cell1 = row1.getCell(1);
        String stringCellValue = cell1.getStringCellValue();
        System.out.println(stringCellValue);
    }

    @Test
    public void excelTest() throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("在线试题导出信息");

        sheet.addMergedRegion(new CellRangeAddress(1,1,1,12));
        XSSFRow row_1 = sheet.createRow(1);
        XSSFCell cell_1_1 = row_1.createCell(1);
        XSSFCellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setAlignment(HorizontalAlignment.CENTER);
        cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        cell_1_1.setCellStyle(cellStyle);
        cell_1_1.setCellValue("在线试题导出信息");
        File file = new File("在线试题导出信息.xlsx");

        String[] s = {"题目ID", "所属公司ID", "所属目录ID", "题目简介", "题干描述", "题干配图", "题目分析", "题目类型", "题目难度", "是否经典题", "题目状态", "审核状态 " };
        XSSFRow row_2 = sheet.createRow(2);
        for (int i = 0; i < s.length; i++) {
            XSSFCell cell_2_temp = row_2.createCell(1 + i);
            cell_2_temp.setCellValue(s[i]);
            cellStyle.setAlignment(HorizontalAlignment.CENTER);
            cell_2_temp.setCellStyle(cellStyle);
        }




        FileOutputStream fo = new FileOutputStream(file);
        workbook.write(fo);
        fo.close();
        workbook.close();
    }
}
