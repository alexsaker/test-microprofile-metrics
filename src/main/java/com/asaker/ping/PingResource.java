package com.asaker.ping;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import org.eclipse.microprofile.metrics.Counter;
import org.eclipse.microprofile.metrics.annotation.Counted;
import org.eclipse.microprofile.metrics.annotation.Metric;



@Stateless
@Path("ping")
public class PingResource {

    @Inject
    @Metric(name="total-ping-2",absolute=true)
    Counter pingNumber;

    @Counted(name="total-ping",absolute=true,monotonic=true)
    @GET
    public String ping() {
        pingNumber.inc();
        return "Enjoy Java EE 8!" ;
    }

    @GET
    @Path("counter")
    public Long count() {
        return pingNumber.getCount();
    }

}
