package restSteps;

import org.aeonbits.owner.ConfigFactory;
import resources.ApiEndPoints;

public class ParentApi {
    protected static ApiEndPoints apiEndPoints
            = ConfigFactory.create(ApiEndPoints.class);
}

