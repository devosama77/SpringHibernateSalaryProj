package org.osama.reportView;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.osama.model.SalaryToEcxcel;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

public class ExcelSalaryReport extends AbstractXlsxView {
    @Override
    protected void buildExcelDocument(Map<String, Object> model, org.apache.poi.ss.usermodel.Workbook workbook,
                                      HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        @SuppressWarnings("unchecked")
        List<SalaryToEcxcel> salaryList= (List<SalaryToEcxcel>) model.get("salaryExcel");
        httpServletResponse.setHeader("Content-Disposition", "attachment; filename=\"salary.xlsx\"");

        Sheet sheet = workbook.createSheet("sheet1");
        Row header = sheet.createRow(0);
        header.createCell(0).setCellValue("codeTransfer");
        header.createCell(1).setCellValue("sequence");
        header.createCell(2).setCellValue("Full Name");
        header.createCell(3).setCellValue("Swift Code");
        header.createCell(4).setCellValue("Bank Number");
        header.createCell(5).setCellValue("Ic Number");
        header.createCell(6).setCellValue("Amount");

        int i=1;
        for (SalaryToEcxcel s:salaryList){
            Row row = sheet.createRow(i++);
            row.createCell(0).setCellValue(s.getCodeTransfer());
            row.createCell(1).setCellValue(s.getSequence());
            row.createCell(2).setCellValue(s.getFullName());
            row.createCell(3).setCellValue(s.getBankSwiftCode());
            row.createCell(4).setCellValue(s.getBankNumber());
            row.createCell(5).setCellValue(s.getIcNumber());
            row.createCell(6).setCellValue(s.getAmount());
        }

    }
}
