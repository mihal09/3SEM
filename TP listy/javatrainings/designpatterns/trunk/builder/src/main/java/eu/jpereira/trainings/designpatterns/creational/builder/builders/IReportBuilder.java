package eu.jpereira.trainings.designpatterns.creational.builder.builders;

import eu.jpereira.trainings.designpatterns.creational.builder.model.Report;
import eu.jpereira.trainings.designpatterns.creational.builder.model.SaleEntry;

public interface IReportBuilder {
    String getType();
    Report generateReport(SaleEntry saleEntry);
}
