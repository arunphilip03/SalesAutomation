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
    private String currentQuarter;


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


    public void setCurrentQuarter(String currentQuarter) {
        this.currentQuarter = currentQuarter;
    }
    
    
    public String getQuarterMonth(int qNum) {
        String quarterMonth = null;

        switch (qNum) {

        case 1:
            quarterMonth = "Jan-Mar";
            break;
        case 2:
            quarterMonth = "Apr-Jun";
            break;
        case 3:
            quarterMonth = "Jul-Sep";
            break;
        case 4:
            quarterMonth = "Oct-Dec";
            break;


        }

        return quarterMonth;
    }

    public String getCurrentQuarter() {

        Calendar cal = Calendar.getInstance();
        StringBuffer quarter = new StringBuffer();

        cal.add(Calendar.MONTH, 0);
        int qNum = (cal.get(Calendar.MONTH) / 3) + 1;
        quarter.append("Q");
        quarter.append(qNum);
        quarter.append(" (");
        quarter.append(getQuarterMonth(qNum));
        quarter.append(") ");
        quarter.append(cal.get(Calendar.YEAR));
        
        return quarter.toString();
    }

    public String getLast1Quarter() {

        Calendar cal = Calendar.getInstance();
        StringBuffer quarter = new StringBuffer();

        cal.add(Calendar.MONTH, -3);
        int qNum = (cal.get(Calendar.MONTH) / 3) + 1;
        quarter.append("Q");
        quarter.append(qNum);
        quarter.append(" (");
        quarter.append(getQuarterMonth(qNum));
        quarter.append(") ");
        quarter.append(cal.get(Calendar.YEAR));
        
        return quarter.toString();
    }

    public String getLast2Quarter() {
        
        Calendar cal = Calendar.getInstance();
        StringBuffer quarter = new StringBuffer();

        cal.add(Calendar.MONTH, -6);
        int qNum = (cal.get(Calendar.MONTH) / 3) + 1;
        quarter.append("Q");
        quarter.append(qNum);
        quarter.append(" (");
        quarter.append(getQuarterMonth(qNum));
        quarter.append(") ");
        quarter.append(cal.get(Calendar.YEAR));
        
        return quarter.toString();
    }

    public String getLast3Quarter() {
        
        Calendar cal = Calendar.getInstance();
        StringBuffer quarter = new StringBuffer();

        cal.add(Calendar.MONTH, -9);
        int qNum = (cal.get(Calendar.MONTH) / 3) + 1;
        quarter.append("Q");
        quarter.append(qNum);
        quarter.append(" (");
        quarter.append(getQuarterMonth(qNum));
        quarter.append(") ");
        quarter.append(cal.get(Calendar.YEAR));
        
        return quarter.toString();
    }

    public String getLast4Quarter() {
        
        Calendar cal = Calendar.getInstance();
        StringBuffer quarter = new StringBuffer();

        cal.add(Calendar.MONTH, -12);
        int qNum = (cal.get(Calendar.MONTH) / 3) + 1;
        quarter.append("Q");
        quarter.append(qNum);
        quarter.append(" (");
        quarter.append(getQuarterMonth(qNum));
        quarter.append(") ");
        quarter.append(cal.get(Calendar.YEAR));
        
        return quarter.toString();
    }

//    public static void main(String[] args) {
//        Quarter q = new Quarter();
//
//        System.out.println(q.getCurrentQuarter());
//        System.out.println(q.getLast1Quarter());
//        System.out.println(q.getLast2Quarter());
//        System.out.println(q.getLast3Quarter());
//        System.out.println(q.getLast4Quarter());
//
//
//    }


   
}
