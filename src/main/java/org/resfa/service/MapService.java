package org.resfa.service;


import io.quarkus.qute.Location;
import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateInstance;
import org.resfa.pojo.RealEstate;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;

@ApplicationScoped
public class MapService {

    @Location("yandex_map_template.html")
    private Template yandexMapTemplate;

    @Location("default_map_template.html")
    private Template defaultMapTemplate;

    @Location("main_template.html")
    private Template mainTemplate;

    public TemplateInstance createMap(ArrayList<RealEstate> realEstates) {
        return yandexMapTemplate.data("realEstates", realEstates);
    }
    public TemplateInstance createDefaultMap() {
        return defaultMapTemplate.instance();
    }

    public TemplateInstance mainPage() {
        return mainTemplate.instance();

    }

}
