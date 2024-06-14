package html;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.itextpdf.html2pdf.HtmlConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HtmlToPdf {

	public static void main(String[] args) {
        String inputHtmlFilePath = "C:/htmltopdfusingjsoup/satya.html";
        String outputPdfFilePath = "C:/htmltopdfusingjsoup/satya.pdf";

        try {
            // Read HTML content from file
            String htmlContent = new String(Files.readAllBytes(Paths.get(inputHtmlFilePath)));

            // Convert HTML to PDF and save to file
            convertHtmlToPdf(htmlContent, outputPdfFilePath);
            System.out.println("PDF created successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void convertHtmlToPdf(String htmlContent, String outputPdfFilePath) {
        try (FileOutputStream outputStream = new FileOutputStream(outputPdfFilePath)) {
            HtmlConverter.convertToPdf(htmlContent, outputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
