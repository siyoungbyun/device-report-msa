package devicereportv.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class ReportCommand {

    private Long userId;
    private String deviceId;
}
