package eu.jpereira.trainings.designpatterns.creational.builder.builders;

import eu.jpereira.trainings.designpatterns.creational.builder.model.Report;
import eu.jpereira.trainings.designpatterns.creational.builder.model.SaleEntry;
import eu.jpereira.trainings.designpatterns.creational.builder.model.SoldItem;
import eu.jpereira.trainings.designpatterns.creational.builder.xml.XMLReportBody;

import java.util.Iterator;

public class XMLBuilder implements IReportBuilder{
    private final static String type = "XML";

    @Override
    public String getType() {
        return type;
    }

    @Override
    public Report generateReport(SaleEntry saleEntry) {
        Report report = new Report();
        XMLReportBody reportBody = new XMLReportBody();
        reportBody.putContent("<sale><customer><name>");
        reportBody.putContent(saleEntry.getCustomer().getName());
        reportBody.putContent("</name><phone>");
        reportBody.putContent(saleEntry.getCustomer().getPhone());
        reportBody.putContent("</phone></customer>");

        reportBody.putContent("<items>");

        Iterator<SoldItem> it = saleEntry.getSoldItems().iterator();
        while ( it.hasNext() ) {
            SoldItem soldEntry= it.next();
            reportBody.putContent("<item><name>");
            reportBody.putContent(soldEntry.getName());
            reportBody.putContent("</name><quantity>");
            reportBody.putContent(soldEntry.getQuantity());
            reportBody.putContent("</quantity><price>");
            reportBody.putContent(soldEntry.getUnitPrice());
            reportBody.putContent("</price></item>");
        }
        reportBody.putContent("</items></sale>");
        report.setReportBody(reportBody);
        return report;
    }
}
