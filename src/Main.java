import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Album album1=new Album("album1","Alan Walker");
        album1.addSong("Song 1", 5.2);
        album1.addSong("Song 2", 4.5);
        album1.addSong("Song 3", 3.5);
        album1.addSong("Song 4", 3.3);
        album1.addSong("Song 5", 5.5);

        LinkedList<Song> myPlaylist=new LinkedList<>();
        album1.addToPlayList("Song 1", myPlaylist);
        album1.addToPlayList("Song 2", myPlaylist);
        album1.addToPlayList("Song 3", myPlaylist);
        album1.addToPlayList("Song 4", myPlaylist);
        album1.addToPlayList("Song 5", myPlaylist);

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

        boolean forward=true;

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
                case 3:
                    if(!forward){
                        if(itr.hasNext()) itr.next();
                    }
                    if(!itr.hasNext()){
                        System.out.println("You have reached the end of the playlist");
                    }
                    else{
                        System.out.println("You are listening to " + itr.next());
                    }
                    forward=true;
                    break;
                case 4:
                    if(forward){
                        if(itr.hasPrevious()) itr.previous();
                    }
                    if(!itr.hasPrevious()){
                        System.out.println("You have reached the start of the playlist");
                    }
                    else{
                        System.out.println("You are listening to " + itr.previous());
                    }
                    forward=false;
                    break;
                case 5:
                    if(forward){
                        if(itr.hasPrevious()){
                            System.out.println("You are listening to " + itr.previous());
                            forward=false;
                        }
                        else System.out.println("You have not started the playlist");
                    }
                    else{
                        if(itr.hasNext()){
                            System.out.println("You are listening to " + itr.next());
                            forward=true;
                        }
                    }
                    break;
                case 6:
                    if(forward) itr.remove();
                    else System.out.println("You have not started the playlist");
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
