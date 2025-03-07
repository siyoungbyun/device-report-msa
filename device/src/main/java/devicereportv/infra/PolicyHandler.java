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
    DeviceRepository deviceRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='ReportReviewed'"
    )
    public void wheneverReportReviewed_UpdateDeviceStatus(
        @Payload ReportReviewed reportReviewed
    ) {
        ReportReviewed event = reportReviewed;
        System.out.println(
            "\n\n##### listener UpdateDeviceStatus : " + reportReviewed + "\n\n"
        );

        // Sample Logic //
        Device.updateDeviceStatus(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
