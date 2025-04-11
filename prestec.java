import java.time.LocalDate;

public class prestec {
    private Usuari usuari;
    private Llibre llibre;
    private LocalDate dataPrestec;
    private LocalDate dataRetorn;

public prestec(Usuari usuari, Llibre llibre, LocalDate dataPrestec) {
    this.usuari = usuari;
    this.llibre = llibre;
    this.dataPrestec = dataPrestec;
    this.dataRetorn = dataPrestec.plusWeeks(2);
}

public Usuari getUsuari() { 
    return usuari; 
}

public Llibre getLlibre() { 
    return llibre; 
}

public LocalDate getDataRetorn() { 
    return dataRetorn; 
}
}