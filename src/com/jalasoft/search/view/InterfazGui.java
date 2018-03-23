package com.jalasoft.search.view;

import com.jalasoft.search.controller.SearchController;

public interface InterfazGui {
    void display();
    String getQuery();
    void displayResult(String res);
    void setControler(SearchController controler);

}
