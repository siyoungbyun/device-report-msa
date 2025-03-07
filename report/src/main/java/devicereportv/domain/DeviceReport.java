package devicereportv.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import devicereportv.ReportApplication;
import devicereportv.domain.ReportResolved;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "DeviceReport_table")
@Data
//<<< DDD / Aggregate Root
public class DeviceReport {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long reportId;

    private String deviceId;

    private Long userId;

    private Long reviewerId;

    private Date createdAt;

    private Date updatedAt;

    @Enumerated(EnumType.STRING)
    private Status status;

    public static DeviceReportRepository repository() {
        DeviceReportRepository deviceReportRepository = ReportApplication.applicationContext.getBean(
            DeviceReportRepository.class
        );
        return deviceReportRepository;
    }

    //<<< Clean Arch / Port Method
    public void report(ReportCommand reportCommand) {
        //implement business logic here:

        ReportCreated reportCreated = new ReportCreated(this);
        reportCreated.publishAfterCommit();
    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public void review(ReviewCommand reviewCommand) {
        //implement business logic here:

        ReportReviewed reportReviewed = new ReportReviewed(this);
        reportReviewed.publishAfterCommit();
    }

    //>>> Clean Arch / Port Method

    //<<< Clean Arch / Port Method
    public static void resolveStatus(DeviceStatusUpdated deviceStatusUpdated) {
        //implement business logic here:

        /** Example 1:  new item 
        DeviceReport deviceReport = new DeviceReport();
        repository().save(deviceReport);

        ReportResolved reportResolved = new ReportResolved(deviceReport);
        reportResolved.publishAfterCommit();
        */

        /** Example 2:  finding and process
        

        repository().findById(deviceStatusUpdated.get???()).ifPresent(deviceReport->{
            
            deviceReport // do something
            repository().save(deviceReport);

            ReportResolved reportResolved = new ReportResolved(deviceReport);
            reportResolved.publishAfterCommit();

         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
