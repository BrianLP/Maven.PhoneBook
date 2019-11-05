package com.zipcodewilmington.phonebook;

import java.util.*;

import java.util.Map;

/**
 * Created by leon on 1/23/18.
 */
public class PhoneBook {
    Map<String,List<String>> map;

    public PhoneBook(LinkedHashMap<String, List<String>> map) {
        this.map = new LinkedHashMap<>();

    }

    public PhoneBook() {
        this.map = new LinkedHashMap<>();
    }

    public void add(String name, String phoneNumber) {
        map.put(name, new ArrayList<>(Arrays.asList(phoneNumber)));
    }

    public void addAll(String name, String... phoneNumbers) {
        map.put(name, new ArrayList<>(Arrays.asList(phoneNumbers)));
    }

    public void remove(String name) {
        map.remove(name);
    }

    public Boolean hasEntry(String name) {
        return reverseLookup(name) != null || map.containsKey(name);
    }

    public List<String> lookup(String name) {
        return map.get(name);

    }

    public String reverseLookup(String phoneNumber) {
        String foundName = "";
        for (String i : map.keySet()) {
            if (map.get(i).contains(phoneNumber)) {
                return i;
            }
        }
        return null;
    }

    public List<String> getAllContactNames() {
        ArrayList<String> contacts = new ArrayList<>();
        for (String key : map.keySet()) {
            contacts.add(key);
        }
        return contacts;
    }
    public Map<String, List<String>> getMap() {
        return map;
    }
}
