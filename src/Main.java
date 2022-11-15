import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Album album1=new Album("album1","Alan Walker");
        album1.addSong("Alone", 5.2);
        album1.addSong("Faded", 4.5);
        album1.addSong("DarkSide", 3.5);

        LinkedList<Song> myPlaylist=new LinkedList<>();
        album1.addToPlayList("Alone", myPlaylist);
        album1.addToPlayList("DarkSide", myPlaylist);

        play(myPlaylist);
    }

    public static void play(LinkedList<Song> playList){
        Scanner sc=new Scanner(System.in);
        ListIterator<Song> itr=playList.listIterator();
        if(!itr.hasNext()){
            System.out.println("Playlist is empty");
        }

        System.out.println("You are now listening " + itr.next().getTitle());
        showMenu();

        while(true){
            int option = sc.nextInt();
            switch(option){
                case 0:
                    System.out.println("Thank you for listening");
                    return;
                case 1:
                    showMenu();
                    break;
                case 2:
                    printList(playList);
                    break;
            }
        }
    }

    public static void printList(LinkedList<Song> playlist){
        ListIterator<Song> itr=playlist.listIterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }
    }

    public static void showMenu(){
        System.out.println("0. Exit");
        System.out.println("1. Print Menu");
        System.out.println("2. Show the list of all Songs in the playlist");
        System.out.println("3. Play next song");
        System.out.println("4. Play previous song");
        System.out.println("5. Repeat the song");
        System.out.println("6. Delete the song");
    }
}
