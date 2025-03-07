package devicereportv.domain;

import devicereportv.domain.*;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//<<< PoEAA / Repository
@RepositoryRestResource(
    collectionResourceRel = "deviceReports",
    path = "deviceReports"
)
public interface DeviceReportRepository
    extends PagingAndSortingRepository<DeviceReport, Long> {

    List<DeviceReport> findByDeviceId(Long deviceId);

    List<DeviceReport> findByDeviceIdAndStatusNot(Long deviceId, ReportStatus status);
}
