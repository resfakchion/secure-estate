package org.resfa.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

public class RealEstate {
    public String id;
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

    public RealEstate(String id, Double regionId, Double cityId, Double typeAd, Double sectionId, Double categoryId, String title, String address, Integer floor, Double sq, Double sqLand, BigDecimal cost, String text, ArrayList<String> images, String lat, String lng, String name, ArrayList<String> phones, String url, Double agent, String source, Date created, Date updated) {
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getRegionId() {
        return regionId;
    }

    public void setRegionId(Double regionId) {
        this.regionId = regionId;
    }

    public Double getCityId() {
        return cityId;
    }

    public void setCityId(Double cityId) {
        this.cityId = cityId;
    }

    public Double getTypeAd() {
        return typeAd;
    }

    public void setTypeAd(Double typeAd) {
        this.typeAd = typeAd;
    }

    public Double getSectionId() {
        return sectionId;
    }

    public void setSectionId(Double sectionId) {
        this.sectionId = sectionId;
    }

    public Double getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Double categoryId) {
        this.categoryId = categoryId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public Double getSq() {
        return sq;
    }

    public void setSq(Double sq) {
        this.sq = sq;
    }

    public Double getSqLand() {
        return sqLand;
    }

    public void setSqLand(Double sqLand) {
        this.sqLand = sqLand;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public ArrayList<String> getImages() {
        return images;
    }

    public void setImages(ArrayList<String> images) {
        this.images = images;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getPhones() {
        return phones;
    }

    public void setPhones(ArrayList<String> phones) {
        this.phones = phones;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Double getAgent() {
        return agent;
    }

    public void setAgent(Double agent) {
        this.agent = agent;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
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
