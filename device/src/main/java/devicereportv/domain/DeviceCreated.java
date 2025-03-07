package devicereportv.domain;

import devicereportv.domain.*;
import devicereportv.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class DeviceCreated extends AbstractEvent {

    private Long deviceId;
    private String imei;
    private Long userId;
    private String phoneNumber;
    private DeviceStatus deviceStatus;
    private Date createdAt;
    private Date updatedAt;

    public DeviceCreated(Device aggregate) {
        super(aggregate);
    }

    public DeviceCreated() {
        super();
    }
}
//>>> DDD / Domain Event
