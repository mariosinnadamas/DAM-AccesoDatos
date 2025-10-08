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
        this.height = height;
    }

    public float getMass() {
        return mass;
    }

    public void setMass(float mass) {
        this.mass = mass;
    }

    public String getSkin_color() {
        return skin_color;
    }

    public void setSkin_color(String skin_color) {
        this.skin_color = skin_color;
    }

    public String getEye_color() {
        return eye_color;
    }

    public void setEye_color(String eye_color) {
        this.eye_color = eye_color;
    }

    public String getPlanet() {
        return planet;
    }

    public void setPlanet(String planet) {
        this.planet = planet;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    @Override
    public String toString() {
        return "Personaje{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", birth_birday='" + birth_year + '\'' +
                ", height=" + height +
                ", mass=" + mass +
                ", skin_color='" + skin_color + '\'' +
                ", eye_color='" + eye_color + '\'' +
                ", planet='" + planet + '\'' +
                ", human='" + species + '\'' +
                '}';
    }
}
