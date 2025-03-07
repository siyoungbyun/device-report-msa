package devicereportv.infra;

import devicereportv.domain.*;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//<<< Clean Arch / Inbound Adaptor

@RestController
// @RequestMapping(value="/deviceReports")
@Transactional
public class DeviceReportController {

    @Autowired
    DeviceReportRepository deviceReportRepository;

    @RequestMapping(
        value = "/deviceReports/report",
        method = RequestMethod.POST,
        produces = "application/json;charset=UTF-8"
    )
    public DeviceReport report(
        HttpServletRequest request,
        HttpServletResponse response,
        @RequestBody ReportCommand reportCommand
    ) throws Exception {
        System.out.println("##### /deviceReport/report  called #####");
        DeviceReport deviceReport = new DeviceReport();
        deviceReport.report(reportCommand);
        deviceReportRepository.save(deviceReport);
        return deviceReport;
    }

    @RequestMapping(
        value = "/deviceReports/{id}/review",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public DeviceReport review(
        @PathVariable(value = "id") Long id,
        @RequestBody ReviewCommand reviewCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /deviceReport/review  called #####");
        Optional<DeviceReport> optionalDeviceReport = deviceReportRepository.findById(
            id
        );

        optionalDeviceReport.orElseThrow(() -> new Exception("No Entity Found")
        );
        DeviceReport deviceReport = optionalDeviceReport.get();
        deviceReport.review(reviewCommand);

        deviceReportRepository.save(deviceReport);
        return deviceReport;
    }
}
//>>> Clean Arch / Inbound Adaptor
