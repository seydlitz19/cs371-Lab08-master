package edu.up.cs371.soccer_application;

import android.util.Log;
import android.widget.EditText;

import edu.up.cs371.soccer_application.soccerPlayer.SoccerPlayer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

/**
 * Soccer player database -- presently, all dummied up
 *
 * @author *** put your name here ***
 * @version *** put date of completion here ***
 *
 */
public class SoccerDatabase implements SoccerDB {


    Hashtable<String,SoccerPlayer> players = new Hashtable<String,SoccerPlayer>();

    /**
     * add a player
     *
     * @see SoccerDB#addPlayer(String, String, int, String)
     */
    @Override
    public boolean addPlayer(String firstName, String lastName, int uniformNumber, String teamName) {
        String fullName = firstName+"_"+lastName;
        SoccerPlayer thisPlayer = new SoccerPlayer(firstName,lastName,uniformNumber,teamName);
        if(players.containsKey(fullName)) {
            return false;
        }
        else {
            //add thisPlayer to players
            players.put(fullName,thisPlayer);
            return true;
        }
    }

    /**
     * remove a player
     *
     * @see SoccerDB#removePlayer(String, String)
     */
    @Override
    public boolean removePlayer(String firstName, String lastName) {
        String fullName = firstName+"_"+lastName;
        if(players.containsKey(fullName)){
            players.remove(fullName);
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * look up a player
     *
     * @see SoccerDB#getPlayer(String, String)
     */
    @Override
    public SoccerPlayer getPlayer(String firstName, String lastName) {
        String fullName = firstName+"_"+lastName;
        if(players.containsKey(fullName)){
            return players.get(fullName);
        }
        else{
            return null;
        }
    }

    /**
     * increment a player's goals
     *
     * @see SoccerDB#bumpGoals(String, String)
     */
    @Override
    public boolean bumpGoals(String firstName, String lastName) {
        String fullName = firstName+"_"+lastName;
        if(players.containsKey(fullName)){
            //bump the goals
            players.get(fullName).bumpGoals();
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * increment a player's assists
     *
     * @see SoccerDB#bumpAssists(String, String)
     */
    @Override
    public boolean bumpAssists(String firstName, String lastName) {
        String fullName = firstName+"_"+lastName;
        if(players.containsKey(fullName)){
            //bump the goals
            players.get(fullName).bumpAssists();
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * increment a player's shots
     *
     * @see SoccerDB#bumpShots(String, String)
     */
    @Override
    public boolean bumpShots(String firstName, String lastName) {
        String fullName = firstName+"_"+lastName;
        if(players.containsKey(fullName)){
            //bump the goals
            players.get(fullName).bumpShots();
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * increment a player's saves
     *
     * @see SoccerDB#bumpSaves(String, String)
     */
    @Override
    public boolean bumpSaves(String firstName, String lastName) {
        String fullName = firstName+"_"+lastName;
        if(players.containsKey(fullName)){
            //bump the goals
            players.get(fullName).bumpSaves();
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * increment a player's fouls
     *
     * @see SoccerDB#bumpFouls(String, String)
     */
    @Override
    public boolean bumpFouls(String firstName, String lastName) {
        String fullName = firstName+"_"+lastName;
        if(players.containsKey(fullName)){
            //bump the goals
            players.get(fullName).bumpFouls();
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * increment a player's yellow cards
     *
     * @see SoccerDB#bumpYellowCards(String, String)
     */
    @Override
    public boolean bumpYellowCards(String firstName, String lastName) {
        String fullName = firstName+"_"+lastName;
        if(players.containsKey(fullName)){
            //bump the goals
            players.get(fullName).bumpYellowCards();
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * increment a player's red cards
     *
     * @see SoccerDB#bumpRedCards(String, String)
     */
    @Override
    public boolean bumpRedCards(String firstName, String lastName) {
        String fullName = firstName+"_"+lastName;
        if(players.containsKey(fullName)){
            //bump the goals
            players.get(fullName).bumpRedCards();
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * tells the number of players on a given team
     *
     * @see SoccerDB#numPlayers(String)
     */
    @Override
    // report number of players on a given team (or all players, if null)
    public int numPlayers(String teamName) {
        int teamSize=0;
        if(teamName==null){
            return players.size();
        }
        else{
            Set<String> keys = players.keySet();
            for(String key: keys){
                if(players.get(key).getTeamName().equals(teamName)) {
                    teamSize++;
                }
            }
        }
        return teamSize;
    }

    /**
     * gives the nth player on a the given team
     *
     * @see SoccerDB#playerNum(int, String)
     */
    // get the nTH player
    @Override
    public SoccerPlayer playerNum(int idx, String teamName) {
        Hashtable<Integer,SoccerPlayer> teamPlayers = new Hashtable<Integer,SoccerPlayer>();
        Hashtable<Integer,SoccerPlayer> teamPlayers2 = new Hashtable<Integer,SoccerPlayer>();
        Set<String> keys = players.keySet();
        if(teamName==null){
            int val=0;
            for(String key: keys) {
                teamPlayers.put(val, players.get(key));
                val++;
            }
            return teamPlayers.get(idx);
        }
        else{
            int num=0;
            for(String key: keys){
                if(players.get(key).getTeamName().equals(teamName)) {
                    teamPlayers2.put(num, players.get(key));
                    num++;
                }
            }
            return teamPlayers2.get(idx);
        }
    }

    /**
     * reads database data from a file
     *
     * @see SoccerDB#readData(java.io.File)
     */
    // read data from file
    @Override
    public boolean readData(File file) {
        return file.exists();
    }

    /**
     * write database data to a file
     *
     * @see SoccerDB#writeData(java.io.File)
     */
    // write data to file
    @Override
    public boolean writeData(File file) {
        try{
            PrintWriter printer = new PrintWriter(file);
            Set<String> keys = players.keySet();
            for(String key: keys) {
                printer.println(logString(players.get(key).getFirstName()));
                printer.println(logString(players.get(key).getLastName()));
                printer.println(logString(players.get(key).getTeamName()));
                printer.println(logString(""+players.get(key).getUniform()));
                printer.println(logString(""+players.get(key).getGoals()));
                printer.println(logString(""+players.get(key).getAssists()));
                printer.println(logString(""+players.get(key).getShots()));
                printer.println(logString(""+players.get(key).getSaves()));
                printer.println(logString(""+players.get(key).getFouls()));
                printer.println(logString(""+players.get(key).getYellowCards()));
                printer.println(logString(""+players.get(key).getRedCards()));
            }
            return true;
        }
        catch(Exception e){
            return false;
        }
    }

    /**
     * helper method that logcat-logs a string, and then returns the string.
     * @param s the string to log
     * @return the string s, unchanged
     */
    private String logString(String s) {
        Log.i("write string", s);
        return s;
    }

    /**
     * returns the list of team names in the database
     *
     * @see edu.up.cs371.soccer_application.SoccerDB#getTeams()
     */
    // return list of teams
    @Override
    public HashSet<String> getTeams() {
        return new HashSet<String>();
    }

}
