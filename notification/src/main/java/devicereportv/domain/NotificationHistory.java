package devicereportv.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import devicereportv.NotificationApplication;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "NotificationHistory_table")
@Data
//<<< DDD / Aggregate Root
public class NotificationHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long historyId;

    private String message;

    private Date publishedAt;

    private String eventType;

    public static NotificationHistoryRepository repository() {
        NotificationHistoryRepository notificationHistoryRepository = NotificationApplication.applicationContext.getBean(
            NotificationHistoryRepository.class
        );
        return notificationHistoryRepository;
    }

    public void publish() {
        //
    }

    //<<< Clean Arch / Port Method
    public static void publishNotification(ReportCreated reportCreated) {
        //implement business logic here:

        /** Example 1:  new item 
        NotificationHistory notificationHistory = new NotificationHistory();
        repository().save(notificationHistory);

        */

        /** Example 2:  finding and process
        

        repository().findById(reportCreated.get???()).ifPresent(notificationHistory->{
            
            notificationHistory // do something
            repository().save(notificationHistory);


         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void publishNotification(ReportReviewed reportReviewed) {
        //implement business logic here:

        /** Example 1:  new item 
        NotificationHistory notificationHistory = new NotificationHistory();
        repository().save(notificationHistory);

        */

        /** Example 2:  finding and process
        

        repository().findById(reportReviewed.get???()).ifPresent(notificationHistory->{
            
            notificationHistory // do something
            repository().save(notificationHistory);


         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void publishNotification(DeviceCreated deviceCreated) {
        //implement business logic here:

        /** Example 1:  new item 
        NotificationHistory notificationHistory = new NotificationHistory();
        repository().save(notificationHistory);

        */

        /** Example 2:  finding and process
        

        repository().findById(deviceCreated.get???()).ifPresent(notificationHistory->{
            
            notificationHistory // do something
            repository().save(notificationHistory);


         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void publishNotification(
        DeviceStatusUpdated deviceStatusUpdated
    ) {
        //implement business logic here:

        /** Example 1:  new item 
        NotificationHistory notificationHistory = new NotificationHistory();
        repository().save(notificationHistory);

        */

        /** Example 2:  finding and process
        

        repository().findById(deviceStatusUpdated.get???()).ifPresent(notificationHistory->{
            
            notificationHistory // do something
            repository().save(notificationHistory);


         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void publishNotification(ReportResolved reportResolved) {
        //implement business logic here:

        /** Example 1:  new item 
        NotificationHistory notificationHistory = new NotificationHistory();
        repository().save(notificationHistory);

        */

        /** Example 2:  finding and process
        

        repository().findById(reportResolved.get???()).ifPresent(notificationHistory->{
            
            notificationHistory // do something
            repository().save(notificationHistory);


         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
