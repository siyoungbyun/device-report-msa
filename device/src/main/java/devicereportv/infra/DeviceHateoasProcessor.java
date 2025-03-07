package devicereportv.infra;

import devicereportv.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class DeviceHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Device>> {

    @Override
    public EntityModel<Device> process(EntityModel<Device> model) {
        model.add(
            Link
                .of(model.getRequiredLink("self").getHref() + "/add")
                .withRel("add")
        );

        return model;
    }
}
