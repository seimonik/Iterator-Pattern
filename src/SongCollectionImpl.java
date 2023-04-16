import java.util.ArrayList;
import java.util.List;

public class SongCollectionImpl implements SongCollection {
    private List<Song> songsList;

    public SongCollectionImpl() {
        songsList = new ArrayList<>();
    }

    public void addChannel(Song c) {
        this.songsList.add(c);
    }

    public void removeChannel(Song c) {
        this.songsList.remove(c);
    }

    @Override
    public SongIterator iterator(MusicGenreEnum type) {
        return new SongIteratorImpl(type, this.songsList);
    }

    private class SongIteratorImpl implements SongIterator {

        private MusicGenreEnum type;
        private List<Song> songs;
        private int position;

        public SongIteratorImpl(MusicGenreEnum ty,
                                List<Song> songList) {
            this.type = ty;
            this.songs = songList;
        }

        @Override
        public boolean hasNext() {
            while (position < songs.size()) {
                Song c = songs.get(position);
                if (c.getTYPE().equals(type) || type.equals(MusicGenreEnum.ALL)) {
                    return true;
                } else
                    position++;
            }
            return false;
        }

        @Override
        public Song next() {
            Song c = songs.get(position);
            position++;
            return c;
        }
    }
}
