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

    private Long deviceId;

    private Long userId;

    private Long reviewerId;

    private Date createdAt;

    private Date updatedAt;

    @Enumerated(EnumType.STRING)
    private ReportStatus status;

    public static DeviceReportRepository repository() {
        DeviceReportRepository deviceReportRepository = ReportApplication.applicationContext.getBean(
            DeviceReportRepository.class
        );
        return deviceReportRepository;
    }

    //<<< Clean Arch / Port Method
    public void report(ReportCommand reportCommand) {
        //implement business logic here:
        this.deviceId = reportCommand.getDeviceId();
        this.userId = reportCommand.getUserId();
        this.status = ReportStatus.CREATED;
        this.createdAt = new Date();
        this.updatedAt = new Date();

        repository().save(this);

        ReportCreated reportCreated = new ReportCreated(this);
        reportCreated.publishAfterCommit();
    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public void review(ReviewCommand reviewCommand) {
        //implement business logic here:
        this.reviewerId = reviewCommand.getReviewerId();
        this.status = reviewCommand.getStatus();
        this.updatedAt = new Date();

        repository().save(this);

        ReportReviewed reportReviewed = new ReportReviewed(this);
        reportReviewed.publishAfterCommit();
    }

    //>>> Clean Arch / Port Method

    //<<< Clean Arch / Port Method
    public static void resolveStatus(DeviceStatusUpdated deviceStatusUpdated) {

        // Find all reports for this device that are not already resolved
        List<DeviceReport> reports = repository().findByDeviceIdAndStatusNot(
            deviceStatusUpdated.getDeviceId(),
            ReportStatus.RESOLVED
        );

        for (DeviceReport deviceReport : reports) {
            deviceReport.setStatus(ReportStatus.RESOLVED);
            deviceReport.setUpdatedAt(new Date());
            repository().save(deviceReport);

            ReportResolved reportResolved = new ReportResolved(deviceReport);
            reportResolved.publishAfterCommit();
        }
    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
