package devicereportv.infra;

import devicereportv.domain.*;
import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(
    collectionResourceRel = "reportDashboards",
    path = "reportDashboards"
)
public interface ReportDashboardRepository
    extends PagingAndSortingRepository<ReportDashboard, Long> {}
