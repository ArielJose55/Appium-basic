package core.calculator;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

public class WriteExcel {
	
	private HSSFWorkbook workbook;
	private FileOutputStream fileOutput;
    
    public WriteExcel(HSSFWorkbook workbook) throws FileNotFoundException{
    	this.workbook = workbook;
		fileOutput = new FileOutputStream(new File("C:/Users/ariel.arnedo/Documents/Resources/Documents/reto3.xls"));     
    }
    
    public void write(int column, int row, String number) {
    	Sheet sheet = workbook.getSheetAt(0);
    	
    	Row rowWriter = sheet.getRow(row);
    	Cell cellWriter  = rowWriter.createCell(column);
    	
    	cellWriter.setCellValue(number);
    }
    
    public void flush() throws IOException {
    	workbook.write(fileOutput);
    	fileOutput.close();
    }
}
