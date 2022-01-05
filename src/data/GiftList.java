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
}
