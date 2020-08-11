package com.example.primenumber;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.regex.Pattern;

public class PrimeNumber {
    public static void main(String[] args) throws IOException {
        Number pn = new Number();
        File file = new File(args[0]);
        FileInputStream fis = new FileInputStream(file);

        XSSFWorkbook pnWorkbook = new XSSFWorkbook(fis);
        XSSFSheet pnSheet = pnWorkbook.getSheetAt(0);
        Iterator<Row> rowIterator = pnSheet.iterator();

        while(rowIterator.hasNext()) {
            Row row = rowIterator.next();

            Iterator<Cell> cellIterator = row.cellIterator();
            while(cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                pn.setNumber(cell.getStringCellValue());
                if (pn.isPrime())
                    System.out.println(cell.getStringCellValue());
            }
        }
    }


}
