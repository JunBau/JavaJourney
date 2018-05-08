package com.company;

import java.util.ArrayList;

public interface ISaveable {

    void DisplayItems(ArrayList<String> Item);
    void AddItems(ArrayList<String> ItemName, ArrayList<String> DestinationSave);

}
