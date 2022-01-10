package org.resfa.pojo;

import java.util.ArrayList;

public class ParserResponse {
    public ArrayList<RealEstate> data;
    public Meta meta;

    @Override
    public String toString() {
        return "ParserResponse{" +
                "data=" + data +
                ", meta=" + meta +
                '}';
    }
}
