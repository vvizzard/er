/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.er.erproject.service;

import com.er.erproject.modele.ArticleBon;
import com.er.erproject.modele.Bon;
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
import com.itextpdf.text.html.WebColors;
import com.itextpdf.text.pdf.GrayColor;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.util.Date;
import java.text.SimpleDateFormat;
import com.er.erproject.modele.VueInventaire;
import com.itextpdf.text.BadElementException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author zacharie
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
    private static Font smallFontPliss = new Font(Font.FontFamily.HELVETICA, 10, Font.NORMAL);

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

    public PdfService() {        
    }

    public PdfService(Bon bon,Date date, String er, String telma) throws Exception {
        this.bon = bon;
        Document document = new Document();
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("preuveEntree/bonDeSortie.pdf"));
        setNumberPage(writer);
        document.open();
        addMetaData(document);
        addContent(document,er,telma);
        sautPage(document,1);
//        addLastPage(document,date,er,telma,lieu);78   
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

    private static void addMetaData(Document document, String subject) {
        document.addTitle("PDF Generator");
        document.addSubject(subject);
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

        cell = new PdfPCell(new Phrase(20, "ER", boltTableFont)/**Image.getInstance("C:/Users/diary/Documents/Develeppoment/Logo/telma.jpg")*/);
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

    private static void addEmptyLine(Paragraph paragraph, int number) {
        for (int i = 0; i < number; i++) {
            paragraph.add(new Paragraph(" "));
        }
    }

    public void addTable(Document document, List<List<String>> data) throws DocumentException {
        PdfPTable table = new PdfPTable(data.get(0).size());
        table.setWidthPercentage(100);        
        for (int i = 0; i < data.get(0).size() ; i++) {
                PdfPCell cell = new PdfPCell(new Phrase(data.get(0).get(i), header));
                table.addCell(cell);
            }               
        for (int j = 1; j < data.size(); j++) {
            for (int i = 0; i < data.get(j).size() ; i++) {
                PdfPCell cell = new PdfPCell(new Phrase(data.get(j).get(i), smallFont));
                table.addCell(cell);
            }               
        }        
        document.add(table);       
    }

    public void addTable(Document document, List<List<String>> data, PdfPTable table) throws DocumentException {
        table = new PdfPTable(data.get(0).size());
        table.setWidthPercentage(100);        
        for (int i = 0; i < data.get(0).size() ; i++) {
                PdfPCell cell = new PdfPCell(new Phrase(data.get(0).get(i), header));
                table.addCell(cell);
            }               
        for (int j = 1; j < data.size(); j++) {
            for (int i = 0; i < data.get(j).size() ; i++) {
                PdfPCell cell = new PdfPCell(new Phrase(data.get(j).get(i), smallFont));
                table.addCell(cell);
            }               
        }        
        document.add(table);       
    }

    public void addTable(Document document, List<List<String>> data, PdfPTable table, BaseColor couleurDeFondHeaderTable) throws DocumentException {
        table = new PdfPTable(data.get(0).size());
        table.setWidthPercentage(100);        
        for (int i = 0; i < data.get(0).size() ; i++) {
                PdfPCell cell = new PdfPCell(new Phrase(data.get(0).get(i), header));
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setBackgroundColor(couleurDeFondHeaderTable);
                table.addCell(cell);
            }               
        for (int j = 1; j < data.size(); j++) {
            for (int i = 0; i < data.get(j).size() ; i++) {
                PdfPCell cell = new PdfPCell(new Phrase(data.get(j).get(i), smallFont));
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                table.addCell(cell);
            }               
        }        
        document.add(table);       
    }

    public void addTable(Document document, List<List<String>> data, PdfPTable table, BaseColor couleurDeFondHeaderTable, String listeNombre) throws DocumentException {
        table = new PdfPTable(data.get(0).size());
        table.setWidthPercentage(100);    
        table.setWidths(new float[]{(float) 1, 3, 3, 3, 3, 2, 3, 3});
        for (int i = 0; i < data.get(0).size() ; i++) {
                PdfPCell cell = new PdfPCell(new Phrase(data.get(0).get(i), header));
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setBackgroundColor(couleurDeFondHeaderTable);
                table.addCell(cell);
            }               
        for (int j = 1; j < data.size(); j++) {
            for (int i = 0; i < data.get(0).size() ; i++) {
                PdfPCell cell = new PdfPCell(new Phrase(data.get(j).get(i), smallFontPliss));
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                if(listeNombre.contains(Integer.toString(i))) cell.setHorizontalAlignment(Element.ALIGN_RIGHT);                
                else cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cell);
            }               
        }        
        document.add(table);       
    }
    
    private boolean isPhrase(Object o) {
        if(o.getClass().getSimpleName().compareTo(new Phrase().getClass().getSimpleName())==0) return true;
        return false;
    }

    public void addEntete(Document document, Object aGauche, Object titre, Object aDroite, Object enBas) throws DocumentException {
        PdfPTable table = new PdfPTable(3);
        table.setWidthPercentage(100);
        table.setWidths(new float[]{(float) 3 / 2, 5, (float) 3 / 2});

        PdfPCell cell;
        
        if(isPhrase(aGauche)) cell = new PdfPCell((Phrase) aGauche);
        else cell = new PdfPCell((Image) aGauche);        
        cell.setRowspan(5);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.addCell(cell);

        if(isPhrase(titre)) cell = new PdfPCell((Phrase) titre);
        else cell = new PdfPCell((Image) titre);        
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.addCell(cell);

        if(isPhrase(aDroite)) cell = new PdfPCell((Phrase) aDroite);
        else cell = new PdfPCell((Image) aDroite);        
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell.setRowspan(5);
        table.addCell(cell);

        if(isPhrase(enBas)) cell = new PdfPCell((Phrase) enBas);
        else cell = new PdfPCell((Image) enBas);        
        cell.setRowspan(4);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.addCell(cell);

        document.add(table);
    }    

    public void addEnteteDefaut(Document document, String titre, String aDroite, String enBas) throws BadElementException, IOException, DocumentException {
        addEntete(document, new Phrase(20, "ER", boltTableFont), new Phrase(20, titre, boltTableFont), new Phrase(20, aDroite, boltTableFont), new Phrase(20, enBas, boltTableFont));        
    }

    public void addTableInventaire(Document document, List<VueInventaire> liste) throws IOException, DocumentException {
//      Entete        
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Calendar today = Calendar.getInstance();
        addEnteteDefaut(document, "Inventaire", formatter.format(today.getTime()), "Etat des articles");
        
//      Description        
        Paragraph information = new Paragraph();            
        addEmptyLine(information, 1);
        information.add(new Paragraph("Etat de stock : ", normalFont));
        addEmptyLine(information, 1);
        document.add(information);

//      PdfPTable table;
        List<List<String>> data = new ArrayList<>();
        List<String> header = new ArrayList<>();
        header.add("Id");
        header.add("Reference");
        header.add("Designation");
        header.add("Famille");
        header.add("Emplacement");
        header.add("Nombre");
        header.add("Unite");
        header.add("Valeur");
        data.add(header);
        for (int i = 0; i < liste.size(); i++) {
            List<String> ligne = new ArrayList<>();
            ligne.add(Integer.toString(liste.get(i).getId()));
            ligne.add(liste.get(i).getCode());
            ligne.add(liste.get(i).getArticle());
            ligne.add(liste.get(i).getFamille());
            ligne.add(liste.get(i).getEmplacement());
            ligne.add(Double.toString(liste.get(i).getNombre()));
            ligne.add(liste.get(i).getUnite());
            ligne.add(Double.toString(liste.get(i).getValeur()));
            data.add(ligne);
        }
        PdfPTable tableI = new PdfPTable(8);        
        addTable(document, data, tableI, WebColors.getRGBColor("#693f29"), "057");        
    }

    public void getInventairePdf(List<VueInventaire> liste) throws Exception {        
        Document document = new Document();
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("E:/vvizard/Projet en cours/ERproject/src/main/webapp/preuveEntree/Inventaire.pdf"));        
        document.open();
        addMetaData(document, "Inventaire");
        addTableInventaire(document, liste);
        sautPage(document,1);
        document.close();
    }
}
