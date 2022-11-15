import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String name;
    private String artist;
    private ArrayList<Song> songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<>();
    }

    public boolean findSong(String title){
        for(Song checkSong:this.songs) {
            if (checkSong.getTitle().equals(title)) {
                System.out.println("Song Found !!");
                return true;
            }
        }
        return false;
    }

    public boolean addSong(String title, double duration){
        if(findSong(title)==true){
            System.out.println("Song already present");
            return false;
        }
        return this.songs.add(new Song(title, duration));
    }

    public boolean addToPlayList(String title, LinkedList<Song> playlist){
        for(Song checkSong:this.songs){
            if(checkSong.getTitle().equals(title)){
                playlist.add(checkSong);
                return true;
            }
        }
        return false;
    }

    public boolean addToPlayList(int trackNumber, LinkedList<Song> playlist){
        int index=trackNumber-1;
        if(index>=0 && index<=this.songs.size()-1){
            playlist.add(this.songs.get(index));
            return true;
        }
        return false;
    }
}
