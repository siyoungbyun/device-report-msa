package devicereportv.infra;

import devicereportv.config.kafka.KafkaProcessor;
import devicereportv.domain.*;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class ReportDashboardViewHandler {

    //<<< DDD / CQRS
    @Autowired
    private ReportDashboardRepository reportDashboardRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenReportCreated_then_CREATE_1(
        @Payload ReportCreated reportCreated
    ) {
        try {
            if (!reportCreated.validate()) return;

            // view 객체 생성
            ReportDashboard reportDashboard = new ReportDashboard();
            // view 객체에 이벤트의 Value 를 set 함
            reportDashboard.setId(reportCreated.getReportId());
            reportDashboard.setDeviceId(
                Long.valueOf(reportCreated.getDeviceId())
            );
            reportDashboard.setUserId(reportCreated.getUserId());
            reportDashboard.setReviewerId(reportCreated.getReviewerId());
            reportDashboard.setCreatedAt(reportCreated.getCreatedAt());
            reportDashboard.setUpdatedAt(reportCreated.getUpdatedAt());
            reportDashboard.setReportStatus(
                String.valueOf(reportCreated.getStatus())
            );
            // view 레파지 토리에 save
            reportDashboardRepository.save(reportDashboard);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenReportReviewed_then_UPDATE_1(
        @Payload ReportReviewed reportReviewed
    ) {
        try {
            if (!reportReviewed.validate()) return;
            // view 객체 조회
            Optional<ReportDashboard> reportDashboardOptional = reportDashboardRepository.findById(
                reportReviewed.getReportId()
            );

            if (reportDashboardOptional.isPresent()) {
                ReportDashboard reportDashboard = reportDashboardOptional.get();
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                reportDashboard.setReviewerId(reportReviewed.getReviewerId());
                reportDashboard.setUpdatedAt(reportReviewed.getUpdatedAt());
                reportDashboard.setReportStatus(
                    String.valueOf(reportReviewed.getStatus())
                );
                // view 레파지 토리에 save
                reportDashboardRepository.save(reportDashboard);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //>>> DDD / CQRS
}
