package dev.modulo.report.utils;

import java.io.OutputStream;
import java.util.Map;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimplePdfExporterConfiguration;
import net.sf.jasperreports.export.SimplePdfReportConfiguration;

public class JasperReportsUtils {

	public JasperReportsUtils() {
    }

	public void geraPdf(String jrxml, Map<String, Object> parametros, OutputStream saida) {

		try {

			// compila jrxml em memoria
			JasperReport jasper = JasperCompileManager.compileReport(jrxml);

			// preenche relatorio
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasper, parametros);
			
			JRPdfExporter exporter = new JRPdfExporter();
			 
			exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
			exporter.setExporterOutput(new SimpleOutputStreamExporterOutput("employeeReport.pdf"));

			SimplePdfReportConfiguration reportConfig = new SimplePdfReportConfiguration();
			reportConfig.setSizePageToContent(true);
			reportConfig.setForceLineBreakPolicy(false);
			 
			SimplePdfExporterConfiguration exportConfig = new SimplePdfExporterConfiguration();
			exportConfig.setMetadataAuthor("baeldung");
			exportConfig.setEncrypted(true);
			exportConfig.setAllowedPermissionsHint("PRINTING");
			 
			exporter.setConfiguration(reportConfig);
			exporter.setConfiguration(exportConfig);
			 
			exporter.exportReport();
			

		} catch (Exception e) {
			throw new RuntimeException("Erro ao gerar relatório", e);
		}
	}

}
