package com.sfa.view.backing;

import java.util.Calendar;
import java.util.Locale;

public class Quarter {
    
    public Quarter() {
        super();
    }
    
    private String last1Quarter;
    private String last2Quarter;
    private String last3Quarter;
    private String last4Quarter;


    public void setLast1Quarter(String last1Quarter) {
        this.last1Quarter = last1Quarter;
    }

    public void setLast2Quarter(String last2Quarter) {
        this.last2Quarter = last2Quarter;
    }

    public void setLast3Quarter(String last3Quarter) {
        this.last3Quarter = last3Quarter;
    }

    public void setLast4Quarter(String last4Quarter) {
        this.last4Quarter = last4Quarter;
    }

    public String getLast1Quarter() {
        
        Calendar cal = Calendar.getInstance();
        String quarter = null;
        
        cal.add(Calendar.MONTH, -3);
        int qNum = (cal.get(Calendar.MONTH) / 3) + 1;
        quarter = "Q" + qNum + " " + cal.get(Calendar.YEAR);
        
        
        return quarter;
    }
    
    public String getLast2Quarter() {
        Calendar cal = Calendar.getInstance();
        String quarter = null;
        
        cal.add(Calendar.MONTH, -6);
        int qNum = (cal.get(Calendar.MONTH) / 3) + 1;
        quarter = "Q" + qNum + " " + cal.get(Calendar.YEAR);
        
        
        return quarter;
    }
    
    public String getLast3Quarter() {
        Calendar cal = Calendar.getInstance();
        String quarter = null;
        
        cal.add(Calendar.MONTH, -9);
        int qNum = (cal.get(Calendar.MONTH) / 3) + 1;
        quarter = "Q" + qNum + " " + cal.get(Calendar.YEAR);
        
        
        return quarter;
    }
    
    public String getLast4Quarter() {
        Calendar cal = Calendar.getInstance();
        String quarter = null;
        
        cal.add(Calendar.MONTH, -12);
        int qNum = (cal.get(Calendar.MONTH) / 3) + 1;
        quarter = "Q" + qNum + " " + cal.get(Calendar.YEAR);
        
        
        return quarter;
    }

//    public static void main(String[] args) {
//        Quarter q = new Quarter();
//        
////       System.out.println(q.last1Quarter());
////        System.out.println(q.last2Quarter());
////        System.out.println(q.last3Quarter());
////        System.out.println(q.last4Quarter());
////        
//        
//        
//        
//    }
}
