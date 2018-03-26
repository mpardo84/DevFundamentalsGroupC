package com.jalasoft.search.view;

import com.jalasoft.search.controller.SearchController;

public interface InterfazGui {
    void display();
    String getFileName();
    String getFilePath();
    String getOowner();
    String getIsHidden();
    String getIsReadOnly();
    void displayValidationResult(String res);
    void setControler(SearchController controler);

}
