package devicereportv.domain;

import devicereportv.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//<<< PoEAA / Repository
@RepositoryRestResource(
    collectionResourceRel = "notificationHistories",
    path = "notificationHistories"
)
public interface NotificationHistoryRepository
    extends PagingAndSortingRepository<NotificationHistory, Long> {}
