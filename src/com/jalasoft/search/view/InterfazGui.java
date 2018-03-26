package com.jalasoft.search.view;

import com.jalasoft.search.controller.SearchController;

public interface InterfazGui {
    void display();
    String getFileName();
    String getFilePath();
    String getOowner();
    boolean getIsHidden();
    boolean getIsReadOnly();
    void displayResult(String res);
    void setControler(SearchController controler);

}
