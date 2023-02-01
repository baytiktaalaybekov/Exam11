package peaksoft.model;


public class Developers {
    private Long id;
    private String fullName;
    private byte age;
    private String company;

    public Developers(Long id, String fullName, byte age, String company) {
        this.id = id;
        this.fullName = fullName;
        this.age = age;
        this.company = company;
    }

    public Developers() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public byte getAge() {
        return (byte) age;
    }

    public void setAge(byte age) {
        this.age = age;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "Developers{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", age=" + age +
                ", company='" + company + '\'' +
                '}';
    }
}
