package org.example.withoutaop.logger;

import java.time.Duration;

public class PerformanceLogger {

    public PerforamnceLoggerInfo startTime(String name){
        return new PerforamnceLoggerInfo(name,System.currentTimeMillis());
    }

    public void eclipseTime(PerforamnceLoggerInfo perforamnceLoggerInfo){
        long startTime = perforamnceLoggerInfo.getStartTime();
        long endTime = System.currentTimeMillis();
        System.out.println(
                String.format("%s method invoking take time %d miliseconds."
                        ,perforamnceLoggerInfo.getMethodName(),
                        (endTime-startTime))
        );
    }

     public static class PerforamnceLoggerInfo{
        private String methodName;
        private long startTime;

        public PerforamnceLoggerInfo(String methodName, long startTime) {
            this.methodName = methodName;
            this.startTime = startTime;
        }

        public String getMethodName() {
            return methodName;
        }

        public long getStartTime() {
            return startTime;
        }
    }
}
