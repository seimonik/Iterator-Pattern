public class Song {
    private String Name;
    private String musician;
    private MusicGenreEnum TYPE;

    public Song(String name, String nameMusician, MusicGenreEnum type){
        this.Name=name;
        this.musician =nameMusician;
        this.TYPE=type;
    }

    public String getMusician() {
        return musician;
    }
    public String getName() {
        return Name;
    }
    public MusicGenreEnum getTYPE() {
        return TYPE;
    }

    @Override
    public String toString(){
        return this.Name+" - "+this.musician +" ("+this.TYPE+")";
    }
    @Override
    public boolean equals(Object obj) {
        if (obj == this) { // проверка на идентичность
            return true;
        }
        if (!(obj instanceof Song)) { // проверка типа объекта
            return false;
        }
        Song other = (Song) obj; // приведение объекта к типу Song
        return this.Name.equals(other.Name) && this.musician == other.musician && this.TYPE == other.TYPE;
    }
}
