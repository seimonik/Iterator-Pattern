import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SongCollectionImplTest {

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        System.out.println("У меня всё получится");
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        System.out.println("У меня всё получилось!!");
    }

    @org.junit.jupiter.api.Test
    void addChannel() {
        //создаем тестовые данные
        SongCollection channels = new SongCollectionImpl();
        Song trueSong = new Song("Summer Babe", "Pavement", MusicGenreEnum.LoFi);
        channels.addChannel(trueSong);

        SongIterator iterator = channels.iterator(MusicGenreEnum.valueOf("ALL"));
        Song c = iterator.next();

        //запускаем тест, в случае если c и trueSong не будут равны
        //тест будет провален, о результатах теста читаем в консоли
        Assertions.assertEquals(c, trueSong);
    }
    @org.junit.jupiter.api.Test
    void removeChannel() {
        //создаем тестовые данные
        SongCollection channels = new SongCollectionImpl();
        channels.addChannel(new Song("Summer Babe", "Pavement", MusicGenreEnum.LoFi));
        channels.addChannel(new Song("I Wish I Could Cry", "Saturday Looks Good to Me", MusicGenreEnum.LoFi));
        channels.addChannel(new Song("Don’t You Wanna Stay", "Джейсон Олдин и Келли Кларксон",
                MusicGenreEnum.Country));
        channels.addChannel(new Song("Pick Up the Tempo", "Robert Earl Keen", MusicGenreEnum.Country));
        channels.addChannel(new Song("Whiskey River", "Ray Wylie Hubbard", MusicGenreEnum.Country));
        channels.addChannel(new Song("Stompin’ Em Along Slow", "Lonnie Johnson", MusicGenreEnum.Jazz));
        Song remoneSong = new Song("FREEDOM", "Jon Batiste", MusicGenreEnum.Jazz);
        channels.addChannel(remoneSong);

        channels.removeChannel(remoneSong);
        Boolean hasSong = false;

        SongIterator iterator = channels.iterator(MusicGenreEnum.valueOf("ALL"));
        while (iterator.hasNext()) {
            Song c = iterator.next();
            if(c.getName() == remoneSong.getName()){
                hasSong = true;
            }
        }
        Assertions.assertEquals(hasSong, false);
    }
    @org.junit.jupiter.api.Test
    void iterator() {
        //создаем тестовые данные
        SongCollection channels = populateSongs();
        List<Song> jazzChannelsList = new ArrayList<>();
        jazzChannelsList.add(new Song("Stompin’ Em Along Slow", "Lonnie Johnson", MusicGenreEnum.Jazz));
        jazzChannelsList.add(new Song("FREEDOM", "Jon Batiste", MusicGenreEnum.Jazz));

        List<Song> channelsList = new ArrayList<>();
        SongIterator iterator = channels.iterator(MusicGenreEnum.valueOf("Jazz"));
        while (iterator.hasNext()) {
            channelsList.add(iterator.next());
        }

        Assertions.assertEquals(channelsList, jazzChannelsList);
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