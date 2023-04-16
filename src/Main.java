import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        SongCollection songs = populateSongs();

        Scanner in = new Scanner(System.in);
        String genre = in.nextLine();
        try {
            SongIterator iterator = songs.iterator(MusicGenreEnum.valueOf(genre));
            while (iterator.hasNext()) {
                Song c = iterator.next();
                System.out.println(c.toString());
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
    private static SongCollection populateSongs() {
        SongCollection channels = new SongCollectionImpl();
        channels.addChannel(new Song("Summer Babe", "Pavement", MusicGenreEnum.LoFi));
        channels.addChannel(new Song("I Wish I Could Cry", "Saturday Looks Good to Me", MusicGenreEnum.LoFi));
        channels.addChannel(new Song("Don’t You Wanna Stay", "Джейсон Олдин и Келли Кларксон",
                MusicGenreEnum.Country));
        channels.addChannel(new Song("Pick Up the Tempo", "Robert Earl Keen", MusicGenreEnum.Country));
        channels.addChannel(new Song("Whiskey River", "Ray Wylie Hubbard", MusicGenreEnum.Country));
        channels.addChannel(new Song("Stompin’ Em Along Slow", "Lonnie Johnson", MusicGenreEnum.Jazz));
        channels.addChannel(new Song("FREEDOM", "Jon Batiste", MusicGenreEnum.Jazz));
        return channels;
    }
}
