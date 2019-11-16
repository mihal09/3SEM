package eu.jpereira.trainings.designpatterns.creational.factorymethod.ConcreteGenerators;

import eu.jpereira.trainings.designpatterns.creational.factorymethod.*;

public class XMLReportGenerator extends ReportGenerator {
    @Override
    public Report generateReport(ReportData data) {
        Report generatedReport = new XMLReport();
        generatedReport.generateReport(data);
        return generatedReport;
    }
}
