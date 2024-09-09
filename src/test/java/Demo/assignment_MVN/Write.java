package Demo.assignment_MVN;

import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Write {
 
    public static void main(String[] args) throws IOException 
    { 
      XSSFWorkbook workbook = new XSSFWorkbook();
      
      XSSFSheet sheet = workbook.createSheet("Emp Info");
      
      Object empData[][] = { {"EmpID", "Name","Job"},
    		  {101,"Mahesh","Engineer"},
    		  {102, "Shubham","QA"},
    		  {103,"John","Developer"}
      };
      
      int rows= empData.length;
      int cols=empData[0].length;
      
      for(int r=0;r<rows;r++)
    	  
      {
    	  XSSFRow row =  sheet.createRow(r); 
    	  for (int c=0;c<cols;c++)
    	  {
    		  
    		 XSSFCell cell = row.createCell(c);
    		 Object value = empData[r][c];
    		 
    		 if (value instanceof String)
    			 cell.setCellValue((String)value);
    		 if (value instanceof Integer)
    			 cell.setCellValue((Integer)value);
    		 if (value instanceof Boolean)
    			 cell.setCellValue((Boolean )value);
    	  }
    	  
     }
      String filePath=".\\DataFiles\\Excel.xlsx";
      FileOutputStream outstream = new FileOutputStream (filePath);
      workbook.write(outstream);
            
      outstream.close();
      workbook.close();
      
    }
}
      
      
      

	
