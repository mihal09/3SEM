package eu.jpereira.trainings.designpatterns.creational.factorymethod.ConcreteGenerators;

import eu.jpereira.trainings.designpatterns.creational.factorymethod.*;

public class JSONReportGenerator extends ReportGenerator {
    @Override
    public Report generateReport(ReportData data) {
        Report generatedReport = new JSONReport();
        generatedReport.generateReport(data);
        return generatedReport;
    }
}
