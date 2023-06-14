package ra.service;

import ra.model.Singer;

import java.util.ArrayList;
import java.util.List;

public class SingerService {
    private List<Singer> singers;

    public SingerService() {
        singers = new ArrayList<>();
    }

    public void addSinger(Singer singer) {
        singers.add(singer);
    }

    public void updateSinger(Singer singer) {
        for (int i = 0; i < singers.size(); i++) {
            if (singers.get(i).getSingerId() == singer.getSingerId()) {
                singers.set(i, singer);
                break;
            }
        }
    }

    public void deleteSinger(int singerId) {
        for (int i = 0; i < singers.size(); i++) {
            if (singers.get(i).getSingerId() == singerId) {
                singers.remove(i);
                break;
            }
        }
    }

    public List<Singer> searchSingersByName(String keyword) {
        List<Singer> searchResults = new ArrayList<>();
        for (Singer singer : singers) {
            if (singer.getSingerName().toLowerCase().contains(keyword.toLowerCase())) {
                searchResults.add(singer);
            }
        }
        return searchResults;
    }



    public Singer findSingerById(int singerId) {
        for (Singer singer : singers) {
            if (singer.getSingerId() == singerId) {
                return singer;
            }
        }
        return null;
    }

    public List<Singer> getAllSingers() {
        return singers;
    }
}