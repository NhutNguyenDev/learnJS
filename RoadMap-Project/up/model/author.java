package model;

public class author {
    private String email;
    private String name;


    
    public author(String email, String name) {
        this.email = email;
        this.name = name;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "\n\t\t\t{\n\t\t\temail=" + email + ", \n\t\t\tname=" + name + "\n\t\t\t}";
    }
    
}
