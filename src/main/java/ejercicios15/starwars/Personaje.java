package ejercicios15.starwars;

public class Personaje {
    private String name;
    private String gender;
    private String birth_year;
    private int height;
    private float mass;
    private String hair_colour;
    private String skin_colour;
    private String eye_colour;
    private String planet;
    private String species;

    //Constructor vacío
    public Personaje() {
    }

    //Constructor con parámetros
    public Personaje(String name, String gender, String birth_year, int height, float mass, String hair_colour, String skin_colour, String eye_colour, String planet, String species) {
        setName(name);
        setGender(gender);
        setBirth_year(birth_year);
        setHeight(height);
        setMass(mass);
        setHair_colour(hair_colour);
        setSkin_colour(skin_colour);
        setEye_colour(eye_colour);
        setPlanet(planet);
        setSpecies(species);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()){
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
        this.name = name.trim();
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        if (gender == null || gender.isEmpty()){
            throw new IllegalArgumentException("El género no puede estar vacío");
        }
        this.gender = gender.trim();
    }

    public String getBirth_year() {
        return birth_year;
    }

    public void setBirth_year(String birth_year) {
        if (birth_year == null || birth_year.isEmpty()){
            throw new IllegalArgumentException("El género no puede estar vacío");
        }
        this.birth_year = birth_year.trim();
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        if (height < 0){
            throw new IllegalArgumentException("La altura no puede ser inferior a 0");
        }
        this.height = height;
    }

    public float getMass() {
        return mass;
    }

    public void setMass(float mass) {
        if (mass < 0){
            throw new IllegalArgumentException("El peso no puede ser inferior a 0");
        }
        this.mass = mass;
    }

    public String getHair_colour() {
        return hair_colour;
    }

    public void setHair_colour(String hair_colour) {
        if (hair_colour == null || hair_colour.isEmpty()){
            throw new IllegalArgumentException("El color de pelo no puede estar vacío");
        }
        this.hair_colour = hair_colour;
    }

    public String getSkin_colour() {
        return skin_colour;
    }

    public void setSkin_colour(String skin_colour) {
        if (skin_colour == null || skin_colour.isEmpty()){
            throw new IllegalArgumentException("El color de piel no puede estar vacío");
        }
        this.skin_colour = skin_colour.trim();
    }

    public String getEye_colour() {
        return eye_colour;
    }

    public void setEye_colour(String eye_colour) {
        if (eye_colour == null || eye_colour.isEmpty()){
            throw new IllegalArgumentException("El color de ojos no puede estar vacío");
        }
        this.eye_colour = eye_colour;
    }

    public String getPlanet() {
        return planet;
    }

    public void setPlanet(String planet) {
        if (planet == null || planet.isEmpty()){
            throw new IllegalArgumentException("El planeta no puede estar vacío");
        }
        this.planet = planet;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        if (species == null || species.isEmpty()){
            throw new IllegalArgumentException("La especie no puede estar vacía");
        }
        this.species = species;
    }

    @Override
    public String toString() {
        return "Nombre='" + name + '\'' +
                ", Género='" + gender + '\'' +
                ", Año de nacimiento='" + birth_year + '\'' +
                ", Altura=" + height +
                ", Peso=" + mass +
                ", Color de pelo=" + hair_colour + '\'' +
                ", Color de piel='" + skin_colour + '\'' +
                ", Color de ojos='" + eye_colour + '\'' +
                ", Planeta='" + planet + '\'' +
                ", Especie='" + species + '\'' +
                '}';
    }
    public String toCSV(){
        return name + "," + gender + "," + birth_year + "," + height + "," +
                mass + "," + hair_colour +"," + skin_colour + "," + eye_colour + "," + planet + "," + species;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;     //Misma referencia
        if (o == null || getClass() != o.getClass()) return false;      //Tipo distinto
        Personaje p = (Personaje) o;
        return name.equalsIgnoreCase(p.getName()); //Igualdad de nombre
    }

    @Override
    public int hashCode() {
        return name.toLowerCase().hashCode();
    }
}
