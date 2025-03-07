package devicereportv.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class ReviewCommand {

    private Long reportId;
    private String deviceId;
    private Long reviewerId;
    private Status status;
}
