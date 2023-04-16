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

    public MusicGenreEnum getTYPE() {
        return TYPE;
    }

    @Override
    public String toString(){
        return this.Name+" - "+this.musician +" ("+this.TYPE+")";
    }
}
