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
// @RequestMapping(value="/devices")
@Transactional
public class DeviceController {

    @Autowired
    DeviceRepository deviceRepository;

    @RequestMapping(
        value = "/devices/add",
        method = RequestMethod.POST,
        produces = "application/json;charset=UTF-8"
    )
    public Device add(
        HttpServletRequest request,
        HttpServletResponse response,
        @RequestBody AddCommand addCommand
    ) throws Exception {
        System.out.println("##### /device/add  called #####");
        Device device = new Device();
        device.add(addCommand);
        deviceRepository.save(device);
        return device;
    }
}
//>>> Clean Arch / Inbound Adaptor
