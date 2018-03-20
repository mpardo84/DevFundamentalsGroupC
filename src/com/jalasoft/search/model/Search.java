package com.jalasoft.search.model;

import java.io.*;
import java.util.*;
class Search
{
    public void findFile(String name,File file)
    {
        File[] list = file.listFiles();
        if(list!=null)
            for (File fil : list)
            {
                if (fil.isDirectory())
                {
                    findFile(name,fil);
                }
                else if (name.equalsIgnoreCase(fil.getName()))
                {
                    System.out.println("Found");
                    System.out.println("File found at : "+fil.getParentFile());
                    System.out.println("Path diectory: "+fil.getAbsolutePath());
                }
            }
    }
    public static void main(String[] args)
    {
        Search ff = new Search();
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the file to be searched.. " );
        String name = scan.next();
        System.out.println("Enter the directory where to search ");
        String directory = scan.next();
        ff.findFile(name,new File(directory));
    }
}