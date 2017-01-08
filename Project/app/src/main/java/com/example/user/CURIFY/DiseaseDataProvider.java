package com.example.user.CURIFY;

/**
 * Created by FELIX on 1/2/2017.
 */

public class DiseaseDataProvider {
    private int disease_sign_resource;
    private String disease_title;
    private String disease_status;

    public int getDisease_sign_resource() {
        return disease_sign_resource;
    }

    public DiseaseDataProvider(int disease_sign_resource,String disease_title,String disease_status){
        this.setDisease_sign_resource(disease_sign_resource);
        this.setDisease_title(disease_title);
        this.setDisease_status(disease_status);
    }

    public void setDisease_sign_resource(int disease_sign_resource) {
        this.disease_sign_resource = disease_sign_resource;
    }

    public String getDisease_title() {
        return disease_title;
    }

    public void setDisease_title(String disease_title) {
        this.disease_title = disease_title;
    }

    public String getDisease_status() {
        return disease_status;
    }

    public void setDisease_status(String disease_status) {
        this.disease_status = disease_status;
    }
}
