package org.resfa.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

public class RealEstate {
    public Double id;
    public Double regionId;
    public Double cityId;
    public Double typeAd;
    public Double sectionId;
    public Double categoryId;
    public String title;
    public String address;
    public Integer floor;
    public Double sq;
    public Double sqLand;
    public BigDecimal cost;
    public String text;
    public ArrayList<String> images;
    public String lat;
    public String lng;
    public String name;
    public ArrayList<String> phones;
    public String url;
    public Double agent;
    public String source;
    public Date created;
    public Date updated;

    public RealEstate() {
    }

    public RealEstate(Double id, Double regionId, Double cityId, Double typeAd, Double sectionId, Double categoryId, String title, String address, Integer floor, Double sq, Double sqLand, BigDecimal cost, String text, ArrayList<String> images, String lat, String lng, String name, ArrayList<String> phones, String url, Double agent, String source, Date created, Date updated) {
        this.id = id;
        this.regionId = regionId;
        this.cityId = cityId;
        this.typeAd = typeAd;
        this.sectionId = sectionId;
        this.categoryId = categoryId;
        this.title = title;
        this.address = address;
        this.floor = floor;
        this.sq = sq;
        this.sqLand = sqLand;
        this.cost = cost;
        this.text = text;
        this.images = images;
        this.lat = lat;
        this.lng = lng;
        this.name = name;
        this.phones = phones;
        this.url = url;
        this.agent = agent;
        this.source = source;
        this.created = created;
        this.updated = updated;
    }

    @Override
    public String toString() {
        return "RealEstate{" +
                "id=" + id +
                ", regionId=" + regionId +
                ", cityId=" + cityId +
                ", typeAd=" + typeAd +
                ", sectionId=" + sectionId +
                ", categoryId=" + categoryId +
                ", title='" + title + '\'' +
                ", address='" + address + '\'' +
                ", floor=" + floor +
                ", sq=" + sq +
                ", sqLand=" + sqLand +
                ", cost=" + cost +
                ", text='" + text + '\'' +
                ", images=" + images +
                ", lat='" + lat + '\'' +
                ", lng='" + lng + '\'' +
                ", name='" + name + '\'' +
                ", phones=" + phones +
                ", url='" + url + '\'' +
                ", agent=" + agent +
                ", source='" + source + '\'' +
                ", created=" + created +
                ", updated=" + updated +
                '}';
    }
}
