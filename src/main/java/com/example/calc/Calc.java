package com.example.calc;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.FormParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Context;

import javax.json.JsonObjectBuilder;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonWriter;

import java.io.StringWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Path("execute")
public class Calc {
    @Context
    private HttpServletRequest request;

    @POST
    @Consumes("application/x-www-form-urlencoded")
    @Produces("application/json")
    public String execute(@FormParam("a") String paramA, @FormParam("b") String paramB) throws WebApplicationException {
        try {
            long a = Integer.parseInt(paramA);
            long b = Integer.parseInt(paramB);

            HttpSession session = request.getSession(false);
            String sessionid = session.getId();

            JsonObject jsonObject = Json.createObjectBuilder()
            .add("answer", a + b)
            .add("a", a)
            .add("b", b)
            .add("sessionid", sessionid)
            .build();

            StringWriter stWriter = new StringWriter();
            JsonWriter jsonWriter = Json.createWriter(stWriter);
            jsonWriter.writeObject(jsonObject);
            jsonWriter.close();
            return stWriter.toString();
        }
        catch(NumberFormatException e) {
            throw new WebApplicationException(e, Response.Status.BAD_REQUEST);
        }
    }
}
