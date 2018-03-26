package com.jalasoft.search.model;

import java.io.File;

public class FileObject {
    private String fileName;
    private String fileType;
    private File fileDirectory;
    private String ownerName;
    private boolean readOnly;
    private boolean hidden;

    public void FileObject()
    {
    }

    public void setFileName(String filename)
    {
        this.fileName = filename;
    }

    public void setFileType(String fileType)
    {
        this.fileType = fileType;
    }

    public void setFileDirectory(String fileDirectory)
    {
        this.fileDirectory = new File(fileDirectory);
    }

    public void setOwnerName(String ownerName)
    {
        this.ownerName = ownerName;
    }

    public void setReadOnly(boolean readOnly)
    {
        this.readOnly = readOnly;
    }

    public void setHidden(boolean hidden)
    {
        this.hidden = hidden;
    }
}