package eu.jpereira.trainings.designpatterns.creational.factorymethod.ConcreteGenerators;

import eu.jpereira.trainings.designpatterns.creational.factorymethod.HTMLReport;
import eu.jpereira.trainings.designpatterns.creational.factorymethod.Report;
import eu.jpereira.trainings.designpatterns.creational.factorymethod.ReportData;
import eu.jpereira.trainings.designpatterns.creational.factorymethod.ReportGenerator;

public class HTMLReportGenerator extends ReportGenerator {
    @Override
    public Report generateReport(ReportData data) {
        Report generatedReport = new HTMLReport();
        generatedReport.generateReport(data);
        return generatedReport;
    }
}
