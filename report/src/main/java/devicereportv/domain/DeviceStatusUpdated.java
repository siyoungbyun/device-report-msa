package devicereportv.domain;

import devicereportv.domain.*;
import devicereportv.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class DeviceStatusUpdated extends AbstractEvent {

    private Long deviceId;
    private String imei;
    private Long userId;
    private String phoneNumber;
    private Object deviceStatus;
    private Date createdAt;
    private Date updatedAt;
}
