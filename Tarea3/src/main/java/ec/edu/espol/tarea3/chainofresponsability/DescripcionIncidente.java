package ec.edu.espol.tarea3.chainofresponsability;

public final class DescripcionIncidente {
    private static final int MAX = 500;
    private final String text;

    public DescripcionIncidente(String text) {
        if (text == null || text.isBlank() || text.length() > MAX)
            throw new IllegalArgumentException("Descripción inválida");
        this.text = text.trim();
    }
    
    public static DescripcionIncidente of(String text){ 
        return new DescripcionIncidente(text); 
    }

    public String gettext(){ 
        return text; 
    }
}
