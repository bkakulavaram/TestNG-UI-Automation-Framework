package com.qa.automation.framework.utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;

public class ExcelUtil {

    public static Object[][] getTestData(String filePath, String sheetName) {

        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheet(sheetName);

            if (sheet == null) {
                throw new RuntimeException("Sheet not found: " + sheetName);
            }

            int rows = sheet.getPhysicalNumberOfRows();
            int cols = sheet.getRow(0).getPhysicalNumberOfCells();

            Object[][] data = new Object[rows - 1][cols];

            for (int i = 1; i < rows; i++) {

                Row row = sheet.getRow(i);

                for (int j = 0; j < cols; j++) {

                    Cell cell = row.getCell(j,
                            Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);

                    data[i - 1][j] = getCellValue(cell);
                }
            }

            return data;

        } catch (Exception e) {
            throw new RuntimeException("Failed to read Excel file: " + filePath, e);
        }
    }

    private static String getCellValue(Cell cell) {

        return switch (cell.getCellType()) {
            case STRING -> cell.getStringCellValue();
            case NUMERIC -> String.valueOf(cell.getNumericCellValue());
            case BOOLEAN -> String.valueOf(cell.getBooleanCellValue());
            case BLANK -> "";
            default -> "";
        };
    }
}