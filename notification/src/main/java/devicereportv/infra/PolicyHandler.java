package devicereportv.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import devicereportv.config.kafka.KafkaProcessor;
import devicereportv.domain.*;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

//<<< Clean Arch / Inbound Adaptor
@Service
@Transactional
public class PolicyHandler {

    @Autowired
    NotificationHistoryRepository notificationHistoryRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='ReportCreated'"
    )
    public void wheneverReportCreated_PublishNotification(
        @Payload ReportCreated reportCreated
    ) {
        ReportCreated event = reportCreated;
        System.out.println(
            "\n\n##### listener PublishNotification : " + reportCreated + "\n\n"
        );

        // Sample Logic //
        NotificationHistory.publishNotification(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='ReportReviewed'"
    )
    public void wheneverReportReviewed_PublishNotification(
        @Payload ReportReviewed reportReviewed
    ) {
        ReportReviewed event = reportReviewed;
        System.out.println(
            "\n\n##### listener PublishNotification : " +
            reportReviewed +
            "\n\n"
        );

        // Sample Logic //
        NotificationHistory.publishNotification(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='DeviceCreated'"
    )
    public void wheneverDeviceCreated_PublishNotification(
        @Payload DeviceCreated deviceCreated
    ) {
        DeviceCreated event = deviceCreated;
        System.out.println(
            "\n\n##### listener PublishNotification : " + deviceCreated + "\n\n"
        );

        // Sample Logic //
        NotificationHistory.publishNotification(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='DeviceStatusUpdated'"
    )
    public void wheneverDeviceStatusUpdated_PublishNotification(
        @Payload DeviceStatusUpdated deviceStatusUpdated
    ) {
        DeviceStatusUpdated event = deviceStatusUpdated;
        System.out.println(
            "\n\n##### listener PublishNotification : " +
            deviceStatusUpdated +
            "\n\n"
        );

        // Sample Logic //
        NotificationHistory.publishNotification(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='ReportResolved'"
    )
    public void wheneverReportResolved_PublishNotification(
        @Payload ReportResolved reportResolved
    ) {
        ReportResolved event = reportResolved;
        System.out.println(
            "\n\n##### listener PublishNotification : " +
            reportResolved +
            "\n\n"
        );

        // Sample Logic //
        NotificationHistory.publishNotification(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
