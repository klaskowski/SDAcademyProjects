package adapter;

public class Main {
    public static void main(String[] args) {
        AudioPlayer audioPlayer = new AudioPlayer();
        audioPlayer.play("mp3", "file");
        System.out.println();
        audioPlayer.play("mp4", "file1");
        System.out.println();
        audioPlayer.play("vlc", "file2");
        System.out.println();
        audioPlayer.play("mo99", "filex");
    }
}
