package devicereportv.domain;

import devicereportv.domain.*;
import devicereportv.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class ReportCreated extends AbstractEvent {

    private Long reportId;
    private String deviceId;
    private Long userId;
    private Long reviewerId;
    private Date createdAt;
    private Date updatedAt;
    private Object status;
}
