package com.redhat.healthcare.patient;

import com.redhat.healthcare.patient.dao.IPatientDAO;
import com.redhat.healthcare.patient.domain.Patient;
import io.quarkus.runtime.ShutdownEvent;
import io.quarkus.runtime.StartupEvent;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ApplicationScoped
@Path("/patients")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PatientService {

    private static final Logger logger = LoggerFactory.getLogger(PatientService.class);

    @Inject()
    IPatientDAO patientDAO;

    void onStart(@Observes StartupEvent ev) {
        logger.info("onStart() ");
    }

    @GET
    @Path("/")
    public Response list() {
        return Response.ok(patientDAO.getPatients()).build();
    }

    @GET
    @Path("{id}")
    public Response get(@PathParam("id") Integer patientId){
        return Response.ok(patientDAO.getPatient(patientId)).build();
    }

    @POST
    @Transactional
    public Response add(Patient patient) {
        return Response.ok(patientDAO.addPatient(patient)).build();
    }

    @DELETE
    @Transactional
    @Path("{id}")
    public Response delete(@PathParam("id") Integer patientId){
        patientDAO.deletePatient(patientId);
        return Response.ok().build();
    }

    @PUT
    @Transactional
    public Response update(Patient patient) {
        return (Response.ok(patientDAO.updatePatient(patient))).build();
    }

    void onStop(@Observes ShutdownEvent ev) {
        logger.info("onStop() stopping...");
    }
 

}
