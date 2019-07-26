package Model;

import java.text.SimpleDateFormat;

public enum DateFormat {
    PADRAO("dd/MM/yyyy");
    private SimpleDateFormat dateFormat;
    private DateFormat(String dateFormat){
        this.dateFormat = new SimpleDateFormat(dateFormat);
    }

    public SimpleDateFormat getDateFormat() {
        return dateFormat;
    }
}
