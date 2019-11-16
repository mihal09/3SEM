package eu.jpereira.trainings.designpatterns.creational.factorymethod.ConcreteGenerators;

import eu.jpereira.trainings.designpatterns.creational.factorymethod.*;

public class PDFReportGenerator extends ReportGenerator {
    @Override
    public Report generateReport(ReportData data) {
        Report generatedReport = new PDFReport();
        generatedReport.generateReport(data);
        return generatedReport;
    }
}
