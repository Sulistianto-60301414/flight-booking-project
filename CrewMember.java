public class CrewMember {
    private String name;
    private String role;

    public CrewMember(String name, String role) {
        this.name = name;
        this.role = role;
    }

    public String toString() {
        return role + ": " + name;
    }
}
