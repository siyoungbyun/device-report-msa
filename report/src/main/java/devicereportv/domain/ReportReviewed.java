package devicereportv.domain;

import devicereportv.domain.*;
import devicereportv.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class ReportReviewed extends AbstractEvent {

    private Long reportId;
    private String deviceId;
    private Long userId;
    private Long reviewerId;
    private Date createdAt;
    private Date updatedAt;
    private Status status;

    public ReportReviewed(DeviceReport aggregate) {
        super(aggregate);
    }

    public ReportReviewed() {
        super();
    }
}
//>>> DDD / Domain Event
