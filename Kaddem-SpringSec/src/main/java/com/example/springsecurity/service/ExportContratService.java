package com.example.springsecurity.service;

import com.example.springsecurity.Entity.Contrat;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import org.apache.poi.ss.SpreadsheetVersion;
import org.apache.poi.ss.formula.udf.UDFFinder;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

@Service
public class ExportContratService {
    public static ByteArrayInputStream contratsExcelReport(List<Contrat> contrats) throws IOException
    {
String[] columns = {"title","description"};
System.out.println(columns.length);
    try(Workbook workbook =new XSSFWorkbook();
        ByteArrayOutputStream out = new ByteArrayOutputStream();)
    { CreationHelper creationHelper = workbook.getCreationHelper();
        XSSFSheet sheet = (XSSFSheet) workbook.getSheet("Contrats");
        sheet.autoSizeColumn(columns.length);
            Font headerFont = workbook.createFont();
            headerFont.setBold(true);
            headerFont.setColor(IndexedColors.BLACK.getIndex());
            CellStyle cellStyle = workbook.createCellStyle();
            cellStyle.setFont(headerFont);
            Row headerRow= sheet.createRow(0);
            for(int col=0;col < columns.length;col++)
            {
                Cell cell = headerRow.createCell(col);
                cell.setCellValue(columns[col]);
                cell.setCellStyle(cellStyle);
            }
            CellStyle cellStyle1 = workbook.createCellStyle();
            cellStyle1.setDataFormat(creationHelper.createDataFormat().getFormat("#"));
            int rowIndex=1;
            for(Contrat contrat: contrats)
            { Row row = sheet.createRow(rowIndex++);
                row.createCell(0).setCellValue(contrat.getDescriptionContrat());
                row.createCell( 1).setCellValue(contrat.getIdContrat());}
            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());
    }   }

    public static ByteArrayInputStream contratPDFReport(List<Contrat> contrats) {
        Contrat con = new Contrat();
        Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            PdfWriter.getInstance(document, out);
            document.open();
            com.itextpdf.text.Font font = FontFactory.getFont(FontFactory.TIMES_ROMAN, 14, BaseColor.WHITE);
            Paragraph para = new Paragraph("Liste des Contrats", font);
            para.setAlignment(Element.ALIGN_CENTER);
            document.add(para);
            para.setSpacingBefore(250f);

            document.add(Chunk.NEWLINE);
            PdfPTable table = new PdfPTable(5);
            Stream.of("Date Debut Contrat","Date Fin Contrat", "Montant","Nom","Prenom").forEach(headerTitle -> {
                PdfPCell header = new PdfPCell();
                com.itextpdf.text.Font headFont = FontFactory.getFont(FontFactory.TIMES_ROMAN);
                header.setBackgroundColor(BaseColor.MAGENTA);

                header.setHorizontalAlignment(Element.ALIGN_CENTER);
                header.setBorderWidth(1);
                header.setPhrase(new Phrase(headerTitle, headFont));
                table.addCell(header);
            });
            Image image11 = Image.getInstance("C:/Users/Cipher/IdeaProjects/Kaddemm/src/main/resources/Images/background2.png");
            image11.scaleToFit(700F, 850F);
            image11.setAlignment(Element.ALIGN_CENTER);
            image11.setAbsolutePosition(1F, 1F);
            document.add(image11);
            Image image3 = Image.getInstance("C:/Users/Cipher/IdeaProjects/Kaddemm/src/main/resources/Images/background2.png");
            image3.scaleToFit(700F, 850F);
            image3.setAlignment(Element.ALIGN_CENTER);
            image3.setAbsolutePosition(1F, 1F);
            document.add(image3);


            //Image img = new Image();
            for (Contrat cont : contrats) {
                String debutdate = String.format("%1$tb %1$te, %1$tY %1$tI:%1$tM %1$Tp", cont.getDateDebutContrat());
                PdfPCell titleCell = new PdfPCell(new Phrase(debutdate));
                titleCell.setPaddingLeft(1);
                titleCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                titleCell.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(titleCell);
                String findate = String.format("%1$tb %1$te, %1$tY %1$tI:%1$tM %1$Tp", cont.getDateDebutContrat());
                PdfPCell titleeCell = new PdfPCell(new Phrase(findate));
                titleeCell.setPaddingLeft(1);
                titleeCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                titleeCell.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(titleeCell);
                String str = String.format("%d",cont.getMontantContrat());
                PdfPCell titleeCelll = new PdfPCell(new Phrase(str+"dt"));                titleeCelll.setPaddingLeft(1);
                titleeCelll.setVerticalAlignment(Element.ALIGN_MIDDLE);
                titleeCelll.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(titleeCelll);
                if(cont.getEtudiantC().getNomE()==null){
                PdfPCell descCell = new PdfPCell(new Phrase("John"));
                    titleCell.setPaddingLeft(1);
                    titleCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    titleCell.setHorizontalAlignment(Element.ALIGN_LEFT);
                    table.addCell(descCell);}
else
                {PdfPCell descCell = new PdfPCell(new Phrase(cont.getEtudiantC().getNomE()));
                titleCell.setPaddingLeft(1);
                titleCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                titleCell.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(descCell);}
                PdfPCell desccCell = new PdfPCell(new Phrase(cont.getEtudiantC().getPrenomE()));
                desccCell.setPaddingLeft(1);
                desccCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                desccCell.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(desccCell);
            con=cont;

            }
            System.out.println(con);
            if(con.getArchive()==false) {

                document.add(table);}
            Image image2 = Image.getInstance("C:/Users/Cipher/IdeaProjects/Kaddemm/src/main/resources/Images/signature.png");
            image2.setAlignment(Element.ALIGN_BOTTOM);
            image2.setAlignment(Element.ALIGN_RIGHT);
            image2.scaleAbsolute(250, 150);
            image2.setSpacingBefore(3000F);
            document.add(image3);
            document.add(image3);
            document.add(image3);
            document.add(image3);
            document.add(image3);
            document.add(image3);
            document.add(image3);
            document.add(image3);
            document.add(image3);
            document.add(image3);
            document.add(image3);
            document.add(image3);
            document.add(image3);
            document.add(image3);



            //nzid text
            document.add(image2);
            document.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return new ByteArrayInputStream(out.toByteArray());
    }
    public static ByteArrayInputStream contratbyid(Contrat contrat) throws IOException
    {
        String[] columns = {"title","description"};
        System.out.println(columns.length);
        try(Workbook workbook =new XSSFWorkbook();
            ByteArrayOutputStream out = new ByteArrayOutputStream();)
        { CreationHelper creationHelper = workbook.getCreationHelper();
            XSSFSheet sheet = (XSSFSheet) workbook.getSheet("Contrats");
            sheet.autoSizeColumn(columns.length);
            Font headerFont = workbook.createFont();
            headerFont.setBold(true);
            headerFont.setColor(IndexedColors.WHITE.getIndex());
            CellStyle cellStyle = workbook.createCellStyle();
            cellStyle.setFont(headerFont);
            Row headerRow= sheet.createRow(0);
            for(int col=0;col < columns.length;col++)
            {
                Cell cell = headerRow.createCell(col);
                cell.setCellValue(columns[col]);
                cell.setCellStyle(cellStyle);
            }
            CellStyle cellStyle1 = workbook.createCellStyle();
            cellStyle1.setDataFormat(creationHelper.createDataFormat().getFormat("#"));
            int rowIndex=1;
            { Row row = sheet.createRow(rowIndex++);
                row.createCell(0).setCellValue(contrat.getDescriptionContrat());
                row.createCell( 1).setCellValue(contrat.getIdContrat());}
            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());
        }   }

    public static ByteArrayInputStream contratPDFbyid(Contrat contrat) {

        Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            PdfWriter.getInstance(document, out);
            document.open();
            com.itextpdf.text.Font font = FontFactory.getFont(FontFactory.TIMES_ROMAN, 14, BaseColor.BLACK);
            Paragraph para = new Paragraph("Liste des Contrats", font);
            para.setAlignment(Element.ALIGN_CENTER);
            document.add(para);
            para.setSpacingBefore(250f);

            document.add(Chunk.NEWLINE);
            PdfPTable table = new PdfPTable(5);
            Stream.of("Date Debut Contrat","Date Fin Contrat", "Montant","Nom","Prenom").forEach(headerTitle -> {
                PdfPCell header = new PdfPCell();
                com.itextpdf.text.Font headFont = FontFactory.getFont(FontFactory.TIMES_ROMAN);
                header.setBackgroundColor(BaseColor.LIGHT_GRAY);

                header.setHorizontalAlignment(Element.ALIGN_CENTER);
                header.setBorderWidth(1);
                header.setPhrase(new Phrase(headerTitle, headFont));
                table.addCell(header);
            });
            Image image11 = Image.getInstance("C:/Users/Cipher/IdeaProjects/Kaddemm/src/main/resources/Images/background2.png");
            image11.scaleToFit(700F, 850F);
            image11.setAlignment(Element.ALIGN_CENTER);
            image11.setAbsolutePosition(1F, 1F);
            document.add(image11);
            Image image3 = Image.getInstance("C:/Users/Cipher/IdeaProjects/Kaddemm/src/main/resources/Images/background2.png");
            image3.scaleToFit(700F, 850F);
            image3.setAlignment(Element.ALIGN_CENTER);
            image3.setAbsolutePosition(1F, 1F);
            document.add(image3);


            //Image img = new Image();

                String debutdate = String.format("%1$tb %1$te, %1$tY %1$tI:%1$tM %1$Tp", contrat.getDateDebutContrat());
                PdfPCell titleCell = new PdfPCell(new Phrase(debutdate));
                titleCell.setPaddingLeft(1);
                titleCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                titleCell.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(titleCell);
                String findate = String.format("%1$tb %1$te, %1$tY %1$tI:%1$tM %1$Tp", contrat.getDateDebutContrat());
                PdfPCell titleeCell = new PdfPCell(new Phrase(findate));
                titleeCell.setPaddingLeft(1);
                titleeCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                titleeCell.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(titleeCell);
            String str = String.format("%d",contrat.getMontantContrat());

            PdfPCell titleeCelll = new PdfPCell(new Phrase(str));
                titleeCelll.setPaddingLeft(1);
                titleeCelll.setVerticalAlignment(Element.ALIGN_MIDDLE);
                titleeCelll.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(titleeCelll);
                if(contrat.getEtudiantC().getNomE()==null){
                    PdfPCell descCell = new PdfPCell(new Phrase("John"));
                    titleCell.setPaddingLeft(1);
                    titleCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    titleCell.setHorizontalAlignment(Element.ALIGN_LEFT);
                    table.addCell(descCell);}
                else
                {PdfPCell descCell = new PdfPCell(new Phrase(contrat.getEtudiantC().getNomE()));
                    titleCell.setPaddingLeft(1);
                    titleCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    titleCell.setHorizontalAlignment(Element.ALIGN_LEFT);
                    table.addCell(descCell);}
                PdfPCell desccCell = new PdfPCell(new Phrase(contrat.getEtudiantC().getPrenomE()));
                desccCell.setPaddingLeft(1);
                desccCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                desccCell.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(desccCell);


            document.add(table);

            Image image2 = Image.getInstance("C:/Users/Cipher/IdeaProjects/Kaddemm/src/main/resources/Images/signature.png");
            image2.setAlignment(Element.ALIGN_BOTTOM);
            image2.setAlignment(Element.ALIGN_RIGHT);
            image2.scaleAbsolute(250, 150);
            image2.setSpacingBefore(3000F);
            document.add(image3);
            document.add(image3);
            document.add(image3);
            document.add(image3);
            document.add(image3);
            document.add(image3);
            document.add(image3);
            document.add(image3);
            document.add(image3);
            document.add(image3);
            document.add(image3);
            document.add(image3);
            document.add(image3);
            document.add(image3);



            //nzid text
            document.add(image2);
            document.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return new ByteArrayInputStream(out.toByteArray());
    }
}