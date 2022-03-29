package org.resfa.service;


import io.quarkus.qute.Location;
import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateInstance;
import org.resfa.pojo.RealEstate;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;

@ApplicationScoped
public class MapService {

    @Location("map_template.html")
    private Template template;

    public TemplateInstance createMap(ArrayList<RealEstate> realEstates) {
        return template.data("realEstates", realEstates);

    }

}
