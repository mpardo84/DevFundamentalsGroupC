/*
 *     1 21/03/18
 *
 * Copyright (c) 2018 Sun Microsystems, Inc.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of Sun
 * Microsystems, Inc. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 *  with Sun.
 *
 */

package com.jalasoft.search.view;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import java.awt.*;

/**
 *
 This class is the main dialog that contains the tabs for each type of ObjectFile that we could have in the application
 *
 * @version
1.0 21 Mar 2018  * @author
Monica Pardo */
public class SearchProject extends JFrame{
    public JFrame window;
    private JPanel filePanel;
    private JPanel directoryPanel;
    private JPanel multimediaPanel;
    private JTabbedPane tabbedPane;
    private static int w;
    private static int h;

    public SearchProject(String title){
        super(title);
        //initialize variables for tab panel
        tabbedPane = new JTabbedPane();
        filePanel=new FilePanel();
        directoryPanel=new JPanel();
        multimediaPanel=new JPanel();

        //Add tabs to the tab panel
        tabbedPane.add("File",filePanel);
        tabbedPane.add("Directory",directoryPanel);
        tabbedPane.add("Multimedia",multimediaPanel);
        // add the tab panel to the frame
        this.add(tabbedPane);

    }
    //Define the parameters for the dialog
    public void initializeDialog(String title){
        window = new SearchProject(title);
        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment()
                .getDefaultScreenDevice();
        w = gd.getDisplayMode().getWidth();
        h = gd.getDisplayMode().getHeight();

        this.setBounds(0, 0,w,h);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(w, h);
        window.setVisible(true);
    }

}
