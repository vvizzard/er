/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.er.erproject.service;

import com.er.erproject.modele.ArticleBon;
import com.er.erproject.modele.Bon;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.Section;
import com.itextpdf.text.html.WebColors;
import com.itextpdf.text.pdf.GrayColor;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.VerticalPositionMark;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

/**
 *
 * @author diary
 */
public class PdfService {

    private static final Font boltTableFont = new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.BOLD);
    private static final Font normalBoldTableFont = new Font(Font.FontFamily.TIMES_ROMAN, 9, Font.BOLD);
    private static final Font normalFont = new Font(Font.FontFamily.TIMES_ROMAN, 11, Font.NORMAL);
    private static final Font boldFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);
    private static final Font header = new Font(Font.FontFamily.HELVETICA, 12, Font.NORMAL, GrayColor.WHITE);
    private static final Font redFont = new Font(Font.FontFamily.COURIER, 12, Font.NORMAL, BaseColor.RED);
    private static final Font subFont = new Font(Font.FontFamily.TIMES_ROMAN, 16, Font.BOLD);
    private static final Font bold = new Font(Font.FontFamily.COURIER, 12, Font.BOLD);
    private static Font smallFont = new Font(Font.FontFamily.HELVETICA, 12, Font.NORMAL);

    private static int idBon;

    private Bon bon;

    public static Font getSmallFont() {
        return smallFont;
    }

    public static void setSmallFont(Font smallFont) {
        PdfService.smallFont = smallFont;
    }

    public static int getIdBon() {
        return idBon;
    }

    public static void setIdBon(int idfacture) {
        PdfService.idBon = idfacture;
    }

    public Bon getBon() {
        return bon;
    }

    public void setBon(Bon offre) {
        this.bon = offre;
    }

    public PdfService(Bon bon,Date date, String er, String telma) throws Exception {
        this.bon = bon;
        Document document = new Document();
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("E:/vvizard/Projet en cours/ERproject/src/main/webapp/preuveEntree/bonDeSortie.pdf"));
        setNumberPage(writer);
        document.open();
        addMetaData(document);
        addContent(document,er,telma);
        sautPage(document,1);
//        addLastPage(document,date,er,telma,lieu);
        document.close();
    }

    // iText allows to add metadata to the PDF which can be viewed in your Adobe
    // Reader
    // under File -> Properties
    private static void addMetaData(Document document) {
        document.addTitle("PDF Generator");
        document.addSubject("Bon");
        document.addKeywords("Java, PDF, iText");
        document.addAuthor("E.R Systeme");
        document.addCreator("E.R Systeme");
    }
    
    public static Paragraph addTitle(){
         Font fontbold = FontFactory.getFont("Times-Roman", 20, Font.BOLD);
         Paragraph p = new Paragraph("BON DE SORTIE", fontbold);
         p.setSpacingAfter(20);
         p.setAlignment(1); // Center
         return p;
    }
    
    private void addContent(Document document, String er, String telma) throws Exception {
        PdfPTable table = new PdfPTable(3);
        table.setWidthPercentage(100);
        table.setWidths(new float[]{(float) 3 / 2, 5, (float) 3 / 2});

        PdfPCell cell;

        cell = new PdfPCell(new Phrase(20, "BON DE SORTIEjhlkhljkh", boltTableFont)/**Image.getInstance("C:/Users/diary/Documents/Develeppoment/Logo/telma.jpg")*/);
        cell.setRowspan(5);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase(20, "BON DE SORTIE", boltTableFont));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase(this.bon.getDateString()+"\n\n", normalBoldTableFont));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell.setRowspan(5);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase(this.bon.getProjet().getDesignation()+"\n"+this.bon.getFacture() , boltTableFont));
        cell.setRowspan(4);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.addCell(cell);

        document.add(table);
//        document.add(addTitle());
        Chunk underline;
        Paragraph information = new Paragraph();
//        addEmptyLine(information, 1);
//        
//        underline = new Chunk("Date", boldFont);
//        underline.setUnderline(0.1f, -2f);
//        information.add(underline);
//
//        information.add(new Paragraph(" :              " + this.bon.getDateString(), normalFont));
//        addEmptyLine(information, 1);
//
//        underline = new Chunk("Projet", boldFont);
//        underline.setUnderline(0.1f, -2f);
//        information.add(underline);
//
//        information.add(new Paragraph(" :           " + this.bon.getProjet().getDesignation(), normalFont));
//        addEmptyLine(information, 1);
//
//        underline = new Chunk("Ticket", boldFont);
//        underline.setUnderline(0.1f, -2f); //0.1 thick, -2 y-location
//        information.add(underline);
//
//        information.add(new Paragraph(" :           "+"ACD000256", normalFont));
//        addEmptyLine(information, 1);       
        
        underline = new Chunk("Demandeur", boldFont);
        underline.setUnderline(0.1f, -2f); //0.1 thick, -2 y-location
        information.add(underline);

        information.add(new Paragraph(" : "+this.bon.getDemandeur().getNom()+" "+this.bon.getDemandeur().getPrenom(), normalFont));
        addEmptyLine(information, 1);       

//        addEmptyLine(information, 1);
//        underline = new Chunk("Pour l'Entreprise RANDRIANANRISOA : ", boldFont);
//        underline.setUnderline(0.1f, -2f); //0.1 thick, -2 y-location
//        information.add(underline);
//
//        addEmptyLine(information, 2);
//        information.add(new Paragraph("- "+er, normalFont));
//        addEmptyLine(information, 1);
//
//        underline = new Chunk("Pour Telma : ", boldFont);
//        underline.setUnderline(0.1f, -2f); //0.1 thick, -2 y-location
//        information.add(underline);

//        addEmptyLine(information, 2);
//        information.add(new Paragraph("- "+telma, normalFont));
        addEmptyLine(information, 1);
        information.add(new Paragraph("Liste des articles demandés : ", normalFont));
        addEmptyLine(information, 1);
        document.add(information);

//        PdfPTable table;
        table = new PdfPTable(7);

        table.setWidthPercentage(100);
        table.setWidths(new float[]{(float) 3, 3, 3, 3, 3, 3, 3});

        BaseColor myColorpan = WebColors.getRGBColor("#693f29");
        PdfPCell c1;
        c1 = new PdfPCell(new Phrase("Reference", header));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        c1.setBackgroundColor(myColorpan);
        c1.setPadding(5);
        table.addCell(c1);        

        c1 = new PdfPCell(new Phrase("Designation", header));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        c1.setBackgroundColor(myColorpan);
        c1.setPadding(5);
        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("Famille", header));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        c1.setBackgroundColor(myColorpan);
        c1.setPadding(5);
        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("Unite", header));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        c1.setBackgroundColor(myColorpan);
        c1.setPadding(5);
        table.addCell(c1);
        
        c1 = new PdfPCell(new Phrase("Nombre", header));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        c1.setBackgroundColor(myColorpan);
        c1.setPadding(5);
        table.addCell(c1);
        
        c1 = new PdfPCell(new Phrase("Prix unitaire", header));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        c1.setBackgroundColor(myColorpan);
        c1.setPadding(5);
        table.addCell(c1);
        
        c1 = new PdfPCell(new Phrase("Valeur", header));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        c1.setBackgroundColor(myColorpan);
        c1.setPadding(5);
        table.addCell(c1);

        //document.add(table);
        for (int i = 0; i < bon.getListeArticle().size(); i++) {
            ArticleBon article = bon.getListeArticle().get(i);
            
            c1 = new PdfPCell(new Phrase(article.getCode(), smallFont));
            c1.setHorizontalAlignment(Element.ALIGN_CENTER);
            c1.setVerticalAlignment(Element.ALIGN_MIDDLE);
            table.addCell(c1);

            c1 = new PdfPCell(new Phrase(article.getDesignation(), smallFont));
            c1.setHorizontalAlignment(Element.ALIGN_LEFT);
            c1.setPadding(10);
            table.addCell(c1);

            c1 = new PdfPCell(new Phrase(article.getFamille().getDesignation(), smallFont));
            c1.setHorizontalAlignment(Element.ALIGN_CENTER);
            c1.setVerticalAlignment(Element.ALIGN_MIDDLE);
            table.addCell(c1);

            c1 = new PdfPCell(new Phrase(article.getUnite().getDesignation(), smallFont));
            c1.setHorizontalAlignment(Element.ALIGN_CENTER);
            c1.setVerticalAlignment(Element.ALIGN_MIDDLE);
            table.addCell(c1);
            
            c1 = new PdfPCell(new Phrase(Double.toString(article.getNombre()), smallFont));
            c1.setHorizontalAlignment(Element.ALIGN_CENTER);
            c1.setVerticalAlignment(Element.ALIGN_MIDDLE);
            table.addCell(c1);
            
            c1 = new PdfPCell(new Phrase(Double.toString(article.getPrixUnitaire()), smallFont));
            c1.setHorizontalAlignment(Element.ALIGN_CENTER);
            c1.setVerticalAlignment(Element.ALIGN_MIDDLE);
            table.addCell(c1);
            
            c1 = new PdfPCell(new Phrase(Double.toString(article.getPrixTotal()), smallFont));
            c1.setHorizontalAlignment(Element.ALIGN_CENTER);
            c1.setVerticalAlignment(Element.ALIGN_MIDDLE);
            table.addCell(c1);                                    
        }         
        document.add(table);
    }
    
    
//    private void addLastPage(Document document,Date date,String er,String telma, String lieu) throws DocumentException, BadElementException, IOException, Exception {
//        PdfPTable table = new PdfPTable(3);
//        table.setWidthPercentage(100);
//        table.setWidths(new float[]{(float) 3 / 2, 5, (float) 3 / 2});
//
//        PdfPCell cell;
//
//        cell = new PdfPCell(Image.getInstance("C:/Users/diary/Documents/Develeppoment/Logo/telma.jpg"));
//        cell.setRowspan(5);
//        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
//        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//        table.addCell(cell);
//
//        cell = new PdfPCell(new Phrase(20, "Document ", boltTableFont));
//        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
//        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//        table.addCell(cell);
//
//        cell = new PdfPCell(new Phrase("Version \n 1.0", normalBoldTableFont));
//        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
//        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//        cell.setRowspan(5);
//        table.addCell(cell);
//
//        cell = new PdfPCell(new Phrase("PROCES VERBAL DE RECEPETION DEFINITIVE \n \n " + "testsetsetsetsetset" + " \n", boltTableFont));
//        cell.setRowspan(4);
//        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
//        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//        table.addCell(cell);
//
//        document.add(table);
//        Phrase phrase;
//        Paragraph paragraphe;
//        Chunk underline;
//        Paragraph information = new Paragraph();
//        addEmptyLine(information, 2);
//
//        underline = new Chunk("Reserve(s) :", boldFont);
//        underline.setUnderline(0.1f, -2f); //0.1 thick, -2 y-location
//        information.add(underline);
//        information.add(new Phrase(" Aucun", boldFont));
//
//        addEmptyLine(information, 1);
//        information.add(new Phrase("En foi de quoi, ce procès-verbal est établi pour servir et valoir"
//                + " ce que de droit", normalFont));
//        addEmptyLine(information, 2);
//        information.add(new Phrase("Fait en troi(3) exemplaires", normalFont));
//        addEmptyLine(information, 2);
//
//        paragraphe = new Paragraph();
//        paragraphe.add(new Phrase("Fait à "+lieu+", le "+"date teststestestsetestestestest", normalFont));
//        paragraphe.setAlignment(Element.ALIGN_RIGHT);
//
//        document.add(information);
//        document.add(paragraphe);
//        information = new Paragraph();
//
//        underline = new Chunk("Ont signé :", boldFont);
//        underline.setUnderline(0.1f, -2f); //0.1 thick, -2 y-location
//        information.add(underline);
//        addEmptyLine(information, 2);
//        document.add(information);
//
//        Chunk glue = new Chunk(new VerticalPositionMark());
//        Paragraph p = new Paragraph("Pour Entreprise RANDRIANARISOA",boldFont);
////        addEmptyLine(p,3);
//        
//        p.add(new Chunk(glue));
//        p.add(new Phrase("Pour telma",boldFont));
//        p.add(new Chunk(glue));
//        addEmptyLine(p,6);
//        
//        p.add(new Phrase(er,boldFont));
//        p.add(new Chunk(glue));
//        p.add(new Phrase(telma,boldFont));
//        p.add(new Chunk(glue));
//        
//       
//        document.add(p);
//
//    }
    private static void sautPage(Document document, int saut) throws DocumentException {
        for (int i = 0; i < saut; i++) {
            document.add(Chunk.NEXTPAGE);
        }
    }

    public void setNumberPage(PdfWriter writer) {
        writer.setPageEvent(new PdfPageEventHelper() {
            public void onEndPage(PdfWriter writer, Document document) {
                
                String text = "Signature Demandeur";
                String text1 = "Validation supérieur";
                String text2 = "Sortie magasin ";
                
                Rectangle page = document.getPageSize();
                PdfPTable structure = new PdfPTable(3);
                
                PdfPCell c2 = new PdfPCell(new Paragraph(text));
                c2.setHorizontalAlignment(Element.ALIGN_CENTER);
                c2.setBorder(PdfPCell.NO_BORDER);

                structure.addCell(c2);
                
                c2 = new PdfPCell(new Paragraph(text1));
                c2.setHorizontalAlignment(Element.ALIGN_CENTER);
                c2.setBorder(PdfPCell.NO_BORDER);

                structure.addCell(c2);
                
                c2 = new PdfPCell(new Paragraph(text2));
                c2.setHorizontalAlignment(Element.ALIGN_CENTER);
                c2.setBorder(PdfPCell.NO_BORDER);

                structure.addCell(c2);
                
                structure.setTotalWidth(page.getWidth() - document.leftMargin() - document.rightMargin());
                structure.writeSelectedRows(0, -1, document.leftMargin(), document.bottomMargin()+50, writer.getDirectContent());
            }
        });
    }

    private static void createTable(Section subCatPart)
            throws BadElementException {
        PdfPTable table = new PdfPTable(3);

        PdfPCell c1 = new PdfPCell(new Phrase("Table Header 1"));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("Table Header 2"));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("Table Header 3"));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);
        table.setHeaderRows(1);

        table.addCell("1.0");
        table.addCell("1.1");
        table.addCell("1.2");
        table.addCell("2.1");
        table.addCell("2.2");
        table.addCell("2.3");

        subCatPart.add(table);

    }
    private static void addEmptyLine(Paragraph paragraph, int number) {
        for (int i = 0; i < number; i++) {
            paragraph.add(new Paragraph(" "));
        }
    }
}
