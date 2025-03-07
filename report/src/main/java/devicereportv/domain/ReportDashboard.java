package devicereportv.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

//<<< EDA / CQRS
@Entity
@Table(name = "ReportDashboard_table")
@Data
public class ReportDashboard {

    @Id
    //@GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private Long deviceId;
    private Long userId;
    private Long reviewerId;
    private Date createdAt;
    private Date updatedAt;
    private String reportStatus;
}
