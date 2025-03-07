package devicereportv.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import devicereportv.DeviceApplication;
import devicereportv.domain.DeviceStatusUpdated;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Device_table")
@Data
//<<< DDD / Aggregate Root
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long deviceId;

    private String imei;

    private Long userId;

    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    private DeviceStatus deviceStatus;

    private Date createdAt;

    private Date updatedAt;

    public static DeviceRepository repository() {
        DeviceRepository deviceRepository = DeviceApplication.applicationContext.getBean(
            DeviceRepository.class
        );
        return deviceRepository;
    }

    //<<< Clean Arch / Port Method
    public void add(AddCommand addCommand) {

        this.imei = addCommand.getImei();
        this.userId = addCommand.getUserId();
        this.phoneNumber = addCommand.getPhoneNumber();
        this.deviceStatus = DeviceStatus.ACTIVATED; // Set initial status to ACTIVATED

        // Set timestamps
        Date now = new Date();
        this.createdAt = now;
        this.updatedAt = now;

        // Save the new device
        repository().save(this);

        DeviceCreated deviceCreated = new DeviceCreated(this);
        deviceCreated.publishAfterCommit();
    }

    //>>> Clean Arch / Port Method

    //<<< Clean Arch / Port Method
    public static void updateDeviceStatus(ReportReviewed reportReviewed) {
        //implement business logic here:

        /** Example 1:  new item
        Device device = new Device();
        repository().save(device);

        DeviceStatusUpdated deviceStatusUpdated = new DeviceStatusUpdated(device);
        deviceStatusUpdated.publishAfterCommit();
        */

        /** Example 2:  finding and process


        repository().findById(reportReviewed.get???()).ifPresent(device->{

            device // do something
            repository().save(device);

            DeviceStatusUpdated deviceStatusUpdated = new DeviceStatusUpdated(device);
            deviceStatusUpdated.publishAfterCommit();

         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
