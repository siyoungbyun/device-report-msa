package devicereportv.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class AddCommand {

    private String imei;
    private Long userId;
    private String phoneNumber;
}
