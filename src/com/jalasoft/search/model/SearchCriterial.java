package com.jalasoft.search.model;

public class SearchCriterial {

    private String fileName;
    private String filePath;
    private String owner;
    private boolean isHidden;
    private boolean isReadOnly;

    public SearchCriterial(){}

    public  SearchCriterial(String fileName, String filePath, String owner, boolean isHidden, boolean isReadOnly){
        this.fileName = fileName;
        this.filePath = filePath;
        this.owner = owner;
        this.isHidden = isHidden;
        this.isReadOnly = isReadOnly;
    }

    public String getFileName(){
        return this.fileName;
    }

    public String getFilePath() {
        return this.filePath;
    }

    public String getOwner() {
        return this.owner;
    }

    public boolean getIsHidden() {
        return this.isHidden;
    }

    public boolean getIsReadOnly() {
        return this.isReadOnly;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setIsHidden(boolean hidden) {
        this.isHidden = hidden;
    }

    public void setIsReadOnly(boolean readOnly) {
        this.isReadOnly = readOnly;
    }
}

