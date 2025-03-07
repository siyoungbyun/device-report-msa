package devicereportv.infra;

import devicereportv.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class DeviceReportHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<DeviceReport>> {

    @Override
    public EntityModel<DeviceReport> process(EntityModel<DeviceReport> model) {
        model.add(
            Link
                .of(model.getRequiredLink("self").getHref() + "/report")
                .withRel("report")
        );
        model.add(
            Link
                .of(model.getRequiredLink("self").getHref() + "/review")
                .withRel("review")
        );

        return model;
    }
}
