package com.company.db;

public interface Job {
    void init();
    void saveToFile(String name, String filename);
    void readFromFile(String fileName);
}
