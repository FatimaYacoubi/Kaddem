package tn.esprit.spring.entity;

import java.util.List;

public class paginationprojet {
    private List<Projet> projets;
    private List<ProjetDetail> projetDetails;

    private int totalPages;
    private int pageNumber;
    private int pageSize;

    public paginationprojet(){}

    public paginationprojet(List<Projet> projets, int totalPages,
                    int pageNumber, int pageSize) {
        this.projets  = projets;
        this.totalPages = totalPages;
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
    }
    public paginationprojet(List<ProjetDetail> projetDetails, int totalPages,
                    int pageNumber, int pageSize,int p) {
        this.projetDetails = projetDetails;
        this.totalPages = totalPages;
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
    }

    public void setprojets(List<Projet> projets) {
        this.projets = projets;
    }

    public List<Projet> getprojets() {
        return this.projets;
    }
    public void setprojetDetails(List<ProjetDetail> projetDetails) {
        this.projetDetails = projetDetails;
    }

    public List<ProjetDetail> getprojetDetails() {
        return this.projetDetails;
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
