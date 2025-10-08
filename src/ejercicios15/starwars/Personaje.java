package ejercicios15.starwars;

public class Personaje {
    private String name;
    private String gender;
    private String birth_year;
    private int height;
    private float mass;
    private String skin_color;
    private String eye_color;
    private String planet;
    private String species;

    //Constructor vacío
    public Personaje() {
    }

    //Constructor con parámetros
    public Personaje(String name, String gender, String birth_year, int height, float mass, String skin_color, String eye_color, String planet, String species) {
        setName(name);
        setGender(gender);
        setBirth_year(birth_year);
        setHeight(height);
        setMass(mass);
        setSkin_color(skin_color);
        setEye_color(eye_color);
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

    public String getSkin_color() {
        return skin_color;
    }

    public void setSkin_color(String skin_color) {
        if (skin_color == null || skin_color.isEmpty()){
            throw new IllegalArgumentException("El color de piel no puede estar vacío");
        }
        this.skin_color = skin_color.trim();
    }

    public String getEye_color() {
        return eye_color;
    }

    public void setEye_color(String eye_color) {
        if (eye_color == null || eye_color.isEmpty()){
            throw new IllegalArgumentException("El color de ojos no puede estar vacío");
        }
        this.eye_color = eye_color;
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
                ", Color de piel='" + skin_color + '\'' +
                ", Color de ojos='" + eye_color + '\'' +
                ", Planeta='" + planet + '\'' +
                ", Especie='" + species + '\'' +
                '}';
    }
    public String toCSV(){
        return name + ";" + gender + ";" + birth_year + ";" + height + ";" +
                mass + ";" + skin_color + ";" + eye_color + ";" + planet + ";" + species;
    }
}
