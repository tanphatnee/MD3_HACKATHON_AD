package ra.service;

import ra.model.Song;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SongService {
    private List<Song> songs;

    public SongService() {
        songs = new ArrayList<>();
    }

    public void addSong(Song song) {
        songs.add(song);
    }

    public void updateSong(Song song) {
        for (int i = 0; i < songs.size(); i++) {
            if (songs.get(i).getSongId().equals(song.getSongId())) {
                songs.set(i, song);
                break;
            }
        }
    }

    public void deleteSong(String songId) {
        songs.removeIf(song -> song.getSongId().equals(songId));
    }

    public List<Song> searchSongsByName(String keyword) {
        return songs.stream()
                .filter(song -> song.getSongName().toLowerCase().contains(keyword.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Song> getSongsByNameAscending() {
        return songs.stream()
                .sorted(Comparator.comparing(Song::getSongName))
                .collect(Collectors.toList());
    }

    public List<Song> getNewestSongs() {
        return songs.stream()
                .sorted(Comparator.comparing(Song::getCreatedDate).reversed())
                .limit(10)
                .collect(Collectors.toList());
    }

    public Song findSongById(String songId) {
        for (Song song : songs) {
            if (song.getSongId().equals(songId)) {
                return song;
            }
        }
        return null;
    }

    public List<Song> getAllSongs() {
        return songs;
    }
}
