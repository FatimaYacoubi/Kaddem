package com.example.springsecurity.Entity;

import java.util.List;

public class Response {
    private List<Contrat> contrats;
    private List<Entreprise> entreprises;

    private int totalPages;
    private int pageNumber;
    private int pageSize;

    public Response(){}

    public Response(List<Contrat> contrats, int totalPages,
                    int pageNumber, int pageSize) {
        this.contrats  = contrats;
        this.totalPages = totalPages;
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
    }
    public Response(List<Entreprise> entreprises, int totalPages,
                    int pageNumber, int pageSize,int p) {
        this.entreprises = entreprises;
        this.totalPages = totalPages;
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
    }

    public void setContrats(List<Contrat> contrats) {
        this.contrats = contrats;
    }

    public List<Contrat> getContrats() {
        return this.contrats;
    }
    public void setEntreprises(List<Entreprise> entreprises) {
        this.entreprises = entreprises;
    }

    public List<Entreprise> getEntreprises() {
        return this.entreprises;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getTotalPages() {
        return this.totalPages;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPageNumber() {
        return this.pageNumber;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageSize() {
        return this.pageSize;
    }
}