package com.example.jonghyun.datemaker_v2;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Deran on 3/26/2017.
 */

public class Plan {


    private Idea idea1, idea2, idea3;
    private int totalBudget;

    public Plan(Idea idea1, Idea idea2, Idea idea3) {
        this.idea1 = idea1;
        this.idea2 = idea2;
        this.idea3 = idea3;
        totalBudget = idea1.getBudget() + idea2.getBudget() + idea3.getBudget();
    }

    public Plan(Idea idea1, Idea idea2) {
        this.idea1 = idea1;
        this.idea2 = idea2;
        totalBudget = idea1.getBudget() + idea2.getBudget();
    }

    public Idea getIdea1() {
        return idea1;
    }

    public int getTotalBudget() {
        return totalBudget;
    }
    public ArrayList<Idea> getParcelableArrayList(){
        ArrayList<Idea> pArrayL = new ArrayList<>();
        pArrayL.add(idea1);
        pArrayL.add(idea2);
        pArrayL.add(idea3);
        return pArrayL;
    }
    public void setIdea1(Idea idea1) {
        this.idea1 = idea1;
    }

    public Idea getIdea2() {
        return idea2;
    }

    public void setIdea2(Idea idea2) {
        this.idea2 = idea2;
    }

    public Idea getIdea3() {
        return idea3;
    }

    public void setIdea3(Idea idea3) {
        this.idea3 = idea3;
    }
}
