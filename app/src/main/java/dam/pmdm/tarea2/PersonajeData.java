package dam.pmdm.tarea2;

public class PersonajeData {

    private final String image;
    private final String name;
    private final String description;
    private final String habilities;

    /**
     * Constructor
     * @param image url de la imagen
     * @param name nombre del personaje
     * @param description descripción del personaje
     * @param habilities habilidades del personaje
     */
    public PersonajeData(String image, String name, String description, String habilities) {
        this.image = image;
        this.name = name;
        this.description = description;
        this.habilities = habilities;
    }

    /**
     * Getter imagen
     * @return Imagen
     */
    public String getImage() {
        return image;
    }

    /**
     * Getter Nombre
     * @return Nombre
     */
    public String getName() {
        return name;
    }

    /**
     * Getter descripción
     * @return Descripción
     */
    public String getDescription() {
        return description;
    }

    /**
     * Getter Habilidades
     * @return Habilidades
     */
    public String getHabilities() {
        return habilities;
    }
}

