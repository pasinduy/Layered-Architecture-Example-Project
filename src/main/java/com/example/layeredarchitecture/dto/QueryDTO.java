package com.example.layeredarchitecture.dto;

public class QueryDTO {
    private String oid;
    private String id;
    private String name;

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public QueryDTO(String oid, String id, String name) {
        this.oid = oid;
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "QueryTM{" +
                "oid='" + oid + '\'' +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
