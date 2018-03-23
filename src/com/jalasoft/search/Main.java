package com.jalasoft.search;
import com.jalasoft.search.controller.SearchController;
import com.jalasoft.search.view.Gui;
import com.jalasoft.search.view.InterfazGui;
import com.jalasoft.search.model.SearchProcess;

class programToSearchFiles {

    public  static  void main(String[] args){
        InterfazGui vista = new Gui();
        SearchProcess modelo = new SearchProcess();
        SearchController control = new SearchController(vista, modelo);
        vista.setControler(control);
        vista.display();
    }
}
