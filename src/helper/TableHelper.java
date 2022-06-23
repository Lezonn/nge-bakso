package helper;

import java.util.ArrayList;

public class TableHelper
{
    private static int tableWidth = 128;
    
    public static void PrintLine() {
        for(int i = 0; i < tableWidth; i++) {
        	System.out.print('-');
        }
        System.out.println();
    }

    public static void PrintRow(ArrayList<String> columns) {
        int width = (tableWidth - columns.size()) / columns.size();
        String row = "|";

        for(String column : columns) {
            row += CheckLen(column, width) + "|";
        }

        System.out.println(row);
    }

    private static String CheckLen(String text, int width) {
        text = text.length() > width ? text.substring(0, width - 3) + "..." : text;

        if (text.equals("") || text.equals(null)) {
        	for(int i = 0; i < width; i++) {
            	System.out.print(' ');
            }
        }
        else {
            String pr = PadRight(text, width - (width - text.length()) / 2);
            return PadLeft(pr, width);
        }
        
        return text;
    }
    
    public static String PadRight(String s, int n) {
        return String.format("%-" + n + "s", s);  
    }

    public static String PadLeft(String s, int n) {
       return String.format("%" + n + "s", s);  
    }
}

