package com.example.springsecurity.service;

import com.example.springsecurity.Entity.Contrat;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ContratExcelExporter {
    private XSSFWorkbook workbook;
    private XSSFSheet sheet;
    private List<Contrat> listContrats;
    private void writeHeaderRow(){
Row row = sheet.createRow(0);
Cell cell = row.createCell(0);
cell.setCellValue("Contrat id");
        cell = row.createCell(1);
        cell.setCellValue("Montant");
        cell = row.createCell(2);
        cell.setCellValue("Comission");
        cell = row.createCell(3);
        cell.setCellValue("Etudiant");



    }

    public ContratExcelExporter(List<Contrat> listContrats) {
        this.listContrats = listContrats;
        workbook = new XSSFWorkbook();
        sheet = workbook.createSheet("Contrats");


    }

    private void writeDataRows(){
int RowCount=1;
for( Contrat contrat : listContrats)
{
    Row row = sheet.createRow(RowCount++);
     Cell cell = row.createCell(0);
cell.setCellValue(contrat.getIdContrat());
    cell = row.createCell(1);
    cell.setCellValue(contrat.getMontantContrat()+"dt");
     cell = row.createCell(3);
    cell.setCellValue(contrat.getEtudiantC().getIdEtudiant());

    cell = row.createCell(2);
    cell.setCellValue(contrat.getComissionContrat()+"dt");
}
    }
    public void export(HttpServletResponse response) throws IOException
    {
        writeHeaderRow();
        writeDataRows();
        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
    }
}
