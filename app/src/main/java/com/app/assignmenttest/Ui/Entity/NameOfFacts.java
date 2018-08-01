package com.app.assignmenttest.Ui.Entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Devanshu Nath Tripathi on 17/7/18.
 */

public class NameOfFacts {
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("rows")
    @Expose
    private ArrayList<ListItem> rows = null;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<ListItem> getRows() {
        return rows;
    }

    public void setRows(ArrayList<ListItem> rows) {
        this.rows = rows;
    }
}
