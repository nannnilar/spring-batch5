package org.example.withoutaop.repo;

import org.example.withoutaop.ds.FormattedReport;
import org.springframework.stereotype.Component;

@Component
public class FormattedReportRepository {

     public void save(FormattedReport formattedReport) {
        try{
            System.out.println("FormattedReport saved.");
            Thread.sleep(5000);
        }catch (InterruptedException e){

        } finally {
            System.out.println("Finished FormattedReport saved.");
        }
        return;
    }
}
