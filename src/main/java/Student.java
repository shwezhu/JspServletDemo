public class Student {
    public Student(){}

    public Student(int id, String name, String gender, String phone) {
        this.setId(id);
        this.setName(name);
        this.setName(name);
        this.setPhone(phone);
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getPhone() {
        return phone;
    }

    private int id;
    private String name;
    private String gender;
    private String phone;
}
