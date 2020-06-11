package com.example.esstelingapp;

import com.example.esstelingapp.StoryPiecesInterface;

public class ReadingItem implements StoryPiecesInterface {

    private String StoryPartOne;
    private String StoryPartThree;
    private String StoryPartFive;
    private String StoryPartTwo;
    private String StoryPartFour;
    private int Points;
    private boolean PointsReceived;
    private String audio1;
    private String audio3;
    private String audio5;


    public ReadingItem(String storyPartOne, String storyPartThree, String storyPartFive, String storyPartTwo, String storyPartFour, int points, boolean pointsReceived, String audio1, String audio3, String audio5) {
        StoryPartOne = storyPartOne;
        StoryPartThree = storyPartThree;
        StoryPartFive = storyPartFive;
        StoryPartTwo = storyPartTwo;
        StoryPartFour = storyPartFour;
        Points = points;
        PointsReceived = pointsReceived;
        this.audio1 = audio1;
        this.audio3 = audio3;
        this.audio5 = audio5;
    }

    public String getAudio1() {
        return audio1;
    }

    public String getAudio3() {
        return audio3;
    }

    public String getAudio5() {
        return audio5;
    }

    public String getStoryPartOne() {
        return StoryPartOne;
    }

    public String getStoryPartThree() {
        return StoryPartThree;
    }

    public String getStoryPartFive() {
        return StoryPartFive;
    }

    public String getStoryPartTwo() {
        return StoryPartTwo;
    }

    public String getStoryPartFour() {
        return StoryPartFour;
    }

    @Override
    public int getPoints() {
        return Points;
    }

    @Override
    public boolean canGainPoints() {
        return PointsReceived;
    }
}
