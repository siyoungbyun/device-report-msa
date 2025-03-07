package devicereportv.infra;

import devicereportv.config.kafka.KafkaProcessor;
import devicereportv.domain.*;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class DeviceDashboardViewHandler {

    //<<< DDD / CQRS
    @Autowired
    private DeviceDashboardRepository deviceDashboardRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenDeviceCreated_then_CREATE_1(
        @Payload DeviceCreated deviceCreated
    ) {
        try {
            if (!deviceCreated.validate()) return;

            // view 객체 생성
            DeviceDashboard deviceDashboard = new DeviceDashboard();
            // view 객체에 이벤트의 Value 를 set 함
            deviceDashboard.setId(deviceCreated.getDeviceId());
            deviceDashboard.setImei(deviceCreated.getImei());
            deviceDashboard.setUserId(deviceCreated.getUserId());
            deviceDashboard.setPhoneNumber(deviceCreated.getPhoneNumber());
            deviceDashboard.setDeviceStatus(
                String.valueOf(deviceCreated.getDeviceStatus())
            );
            deviceDashboard.setCreatedAt(deviceCreated.getCreatedAt());
            deviceDashboard.setUpdatedAt(deviceCreated.getUpdatedAt());
            // view 레파지 토리에 save
            deviceDashboardRepository.save(deviceDashboard);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenDeviceStatusUpdated_then_UPDATE_1(
        @Payload DeviceStatusUpdated deviceStatusUpdated
    ) {
        try {
            if (!deviceStatusUpdated.validate()) return;
            // view 객체 조회
            Optional<DeviceDashboard> deviceDashboardOptional = deviceDashboardRepository.findById(
                deviceStatusUpdated.getDeviceId()
            );

            if (deviceDashboardOptional.isPresent()) {
                DeviceDashboard deviceDashboard = deviceDashboardOptional.get();
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                deviceDashboard.setDeviceStatus(
                    String.valueOf(deviceStatusUpdated.getDeviceStatus())
                );
                deviceDashboard.setUpdatedAt(
                    deviceStatusUpdated.getUpdatedAt()
                );
                // view 레파지 토리에 save
                deviceDashboardRepository.save(deviceDashboard);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //>>> DDD / CQRS
}
