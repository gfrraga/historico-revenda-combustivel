package Model;

import java.text.SimpleDateFormat;

public enum DateFormat {
    //atribuindo um formato padrão para a data
    PADRAO("dd/MM/yyyy");
    private SimpleDateFormat dateFormat;
    
    //função setDateFormat atribuindo isoladamente o dateFormat
    private DateFormat(String dateFormat){
        this.dateFormat = new SimpleDateFormat(dateFormat);
    }

    //função para retornar isoladamente o DateFormat
    public SimpleDateFormat getDateFormat() {
        return dateFormat;
    }
}
