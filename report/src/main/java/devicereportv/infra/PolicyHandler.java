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
    DeviceReportRepository deviceReportRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='DeviceStatusUpdated'"
    )
    public void wheneverDeviceStatusUpdated_ResolveStatus(
        @Payload DeviceStatusUpdated deviceStatusUpdated
    ) {
        DeviceStatusUpdated event = deviceStatusUpdated;
        System.out.println(
            "\n\n##### listener ResolveStatus : " + deviceStatusUpdated + "\n\n"
        );

        // Comments //
        //Set reportStatus to RESOLVED

        // Sample Logic //
        DeviceReport.resolveStatus(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
