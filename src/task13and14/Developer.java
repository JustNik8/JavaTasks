package task13and14;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Developer {

    private String lastName;
    private Date lastDateReceiving;

    public Developer(String lastName) {
        this.lastName = lastName;
        lastDateReceiving = new Date();
    }

    public void takeTask(){
        lastDateReceiving.setTime(System.currentTimeMillis());
    }

    public String getLastReceivingTime(){
        String pattern = "HH:mm:ss, dd/MM/yyyy";
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);

        return sdf.format(lastDateReceiving);
    }
}
