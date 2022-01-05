package data;

import entities.Gift;
import enums.Category;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GiftList {
    List<Gift> boardGames;
    List<Gift> books;
    List<Gift> clothes;
    List<Gift> sweets;
    List<Gift> tech;
    List<Gift> toys;

    public GiftList() {
        boardGames = new ArrayList<>();
        books = new ArrayList<>();
        clothes = new ArrayList<>();
        sweets = new ArrayList<>();
        tech = new ArrayList<>();
        toys = new ArrayList<>();
    }

    public void populateGiftList(List<Gift> santaGiftList) {
        for (Gift gift : santaGiftList) {
            if (gift.getCategory().equals(Category.BOARD_GAMES)) {
                boardGames.add(gift);
            } else if (gift.getCategory().equals(Category.BOOKS)) {
                books.add(gift);
            } else if (gift.getCategory().equals(Category.CLOTHES)) {
                clothes.add(gift);
            } else if (gift.getCategory().equals(Category.SWEETS)){
                sweets.add(gift);
            } else if (gift.getCategory().equals(Category.TECHNOLOGY)){
                tech.add(gift);
            } else if (gift.getCategory().equals(Category.TOYS)) {
                toys.add(gift);
            }
        }
        boardGames.sort((o1, o2) -> {
            if (o1.getPrice().compareTo(o2.getPrice()) > 0) {
                return Double.compare(o1.getPrice(), o2.getPrice());
            } else {
                return Double.compare(o2.getPrice(), o1.getPrice());
            }
        });
        books.sort((o1, o2) -> {
            if (o1.getPrice().compareTo(o2.getPrice()) > 0) {
                return Double.compare(o1.getPrice(), o2.getPrice());
            } else {
                return Double.compare(o2.getPrice(), o1.getPrice());
            }
        });
        clothes.sort((o1, o2) -> {
            if (o1.getPrice().compareTo(o2.getPrice()) > 0) {
                return Double.compare(o1.getPrice(), o2.getPrice());
            } else {
                return Double.compare(o2.getPrice(), o1.getPrice());
            }
        });
        sweets.sort((o1, o2) -> {
            if (o1.getPrice().compareTo(o2.getPrice()) > 0) {
                return Double.compare(o1.getPrice(), o2.getPrice());
            } else {
                return Double.compare(o2.getPrice(), o1.getPrice());
            }
        });
        tech.sort((o1, o2) -> {
            if (o1.getPrice().compareTo(o2.getPrice()) > 0) {
                return Double.compare(o1.getPrice(), o2.getPrice());
            } else {
                return Double.compare(o2.getPrice(), o1.getPrice());
            }
        });
        toys.sort((o1, o2) -> {
            if (o1.getPrice().compareTo(o2.getPrice()) > 0) {
                return Double.compare(o1.getPrice(), o2.getPrice());
            } else {
                return Double.compare(o2.getPrice(), o1.getPrice());
            }
        });
    }

    public List<Gift> getSpecifiedList(Category category) {
        switch (category) {
            case BOARD_GAMES -> {
                return boardGames;
            }
            case TECHNOLOGY -> {
                return tech;
            }
            case TOYS -> {
                return toys;
            }
            case BOOKS -> {
                return books;
            }
            case CLOTHES -> {
                return clothes;
            }
            case SWEETS -> {
                return sweets;
            }
        }
        return null;
    }

    public List<Gift> getBoardGames() {
        return boardGames;
    }

    public void setBoardGames(List<Gift> boardGames) {
        this.boardGames = boardGames;
    }

    public List<Gift> getBooks() {
        return books;
    }

    public void setBooks(List<Gift> books) {
        this.books = books;
    }

    public List<Gift> getClothes() {
        return clothes;
    }

    public void setClothes(List<Gift> clothes) {
        this.clothes = clothes;
    }

    public List<Gift> getSweets() {
        return sweets;
    }

    public void setSweets(List<Gift> sweets) {
        this.sweets = sweets;
    }

    public List<Gift> getTech() {
        return tech;
    }

    public void setTech(List<Gift> tech) {
        this.tech = tech;
    }

    public List<Gift> getToys() {
        return toys;
    }

    public void setToys(List<Gift> toys) {
        this.toys = toys;
    }
}
