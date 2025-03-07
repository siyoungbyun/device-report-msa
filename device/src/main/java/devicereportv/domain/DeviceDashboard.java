package devicereportv.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

//<<< EDA / CQRS
@Entity
@Table(name = "DeviceDashboard_table")
@Data
public class DeviceDashboard {

    @Id
    //@GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private String imei;
    private Long userId;
    private String phoneNumber;
    private String deviceStatus;
    private Date createdAt;
    private Date updatedAt;
}
