package com.api.users.pojo.auditorUpdateProfileUser;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class CaseResult {
    @SerializedName("data")
    private List<MainRoot> runsList = new ArrayList<>();

    public List<MainRoot> getRunsList() {
        return runsList;
    }

    public void setRunsList(List<MainRoot> runsList) {
        this.runsList = runsList;
    }
}
