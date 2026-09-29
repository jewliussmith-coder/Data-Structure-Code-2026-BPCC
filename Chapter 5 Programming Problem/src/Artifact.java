public class Artifact implements Comparable<Artifact> {
    private String id;
    private String name;
    private String era;

    public Artifact(String id, String name, String era) {
        this.id = id;
        this.name = name;
        this.era = era;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEra() {
        return era;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;

        Artifact other = (Artifact) obj;
        return id.equals(other.id);
    }

    @Override
    public int compareTo(Artifact other) {
        return id.compareTo(other.id);
    }

    @Override
    public String toString() {
        return "Artifact{id='" + id + "', name='" + name + "', era='" + era + "'}";
    }
}
