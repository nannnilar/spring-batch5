package org.example.withoutaop.action;

import org.example.withoutaop.ds.FormattedReport;
import org.example.withoutaop.ds.Report;
import org.example.withoutaop.logger.PerformanceLogger;
import org.example.withoutaop.repo.FormattedReportProvider;
import org.example.withoutaop.repo.FormattedReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import static org.example.withoutaop.logger.PerformanceLogger.PerforamnceLoggerInfo;

@Component
public class ComplexAction {
    @Autowired
    private FormattedReportProvider provider;
    @Autowired
    private FormattedReportRepository repository;

    public void doAction(){
        /*PerformanceLogger logger = new PerformanceLogger();
        PerforamnceLoggerInfo loggerInfo = logger
            .startTime("FormattedReportProvider.getReport()");*/
        FormattedReport formattedReport = provider.getReport(new Report());
//        logger.eclipseTime(loggerInfo);

//        loggerInfo = logger.startTime("FormattedReportRepository.save()");
        repository.save(formattedReport);
//        logger.eclipseTime(loggerInfo);
    }
}
