package devicereportv.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class ReviewCommand {

    private Long reportId;
    private Long deviceId;
    private Long reviewerId;
    private ReportStatus status;
}
