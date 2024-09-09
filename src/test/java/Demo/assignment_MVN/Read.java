package Demo.assignment_MVN;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Read {
 
    public static void main(String[] args) throws IOException 
    { 
        String excelFilePath = ".\\DataFiles\\Excel.xlsx";

        try (FileInputStream fileInputStream = new FileInputStream(excelFilePath);
             XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream)) {

            XSSFSheet sheet = workbook.getSheetAt(0);
            int numberOfRows = sheet.getPhysicalNumberOfRows();

            for (int i = 0; i < numberOfRows; i++) {
                Row row = sheet.getRow(i);
                if (row == null) continue;

                int numberOfCells = row.getPhysicalNumberOfCells();

                for (int j = 0; j < numberOfCells; j++) {
                    Cell cell = row.getCell(j);
                    if (cell == null) continue;

                    switch (cell.getCellType()) {
                        case STRING:
                            System.out.print(cell.getStringCellValue() + "\t");
                            break;
                        case NUMERIC:
                            if (DateUtil.isCellDateFormatted(cell)) {
                                System.out.print(cell.getDateCellValue() + "\t");
                            } else {
                                System.out.print(cell.getNumericCellValue() + "\t");
                            }
                            break;
                        case BOOLEAN:
                            System.out.print(cell.getBooleanCellValue() + "\t");
                            break;
                        default:
                            System.out.print("UNKNOWN\t");
                            break;
                    }
                }
                System.out.println();
            }

        } //catch (IOException e) {
            //e.printStackTrace();
        }
    }

