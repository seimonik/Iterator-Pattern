public interface SongCollection {
    void addChannel(Song c);

    void removeChannel(Song c);

    SongIterator iterator(MusicGenreEnum type);
}
