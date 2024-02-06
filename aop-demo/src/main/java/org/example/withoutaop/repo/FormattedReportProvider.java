package org.example.withoutaop.repo;

import org.example.withoutaop.ds.FormattedReport;
import org.example.withoutaop.ds.Report;
import org.springframework.stereotype.Component;

@Component
public class FormattedReportProvider {

    public FormattedReport getReport(Report report) {
        FormattedReport formattedReport = null;
        System.out.println("Start Formatting...");
        try {
            formattedReport = new FormattedReport(report);
            Thread.sleep(3000);

        }catch (InterruptedException e) {
            System.out.println("Finished Formatting...");
        }
        return formattedReport;
    }
}
