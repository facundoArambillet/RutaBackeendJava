public class Doctor {
  private  static int id = 0;
  private  String name;
  private String speciality;

  Doctor(String name, String speciality) {
      this.id++;
      this.name = name;
      this.speciality = speciality;
  }
    public int getId() {
        return this.id;
    }
    public String getName() {
        return this.name;
    }
    public String getSpeciality() {
        return speciality;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }
}
