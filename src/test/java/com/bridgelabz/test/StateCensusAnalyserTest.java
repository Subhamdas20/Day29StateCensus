package com.bridgelabz.test;

import com.bridgelabz.statecensus.ExceptionType;
import com.bridgelabz.statecensus.StateCensusAnalyser;
import com.bridgelabz.statecensus.StateCensusException;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StateCensusAnalyserTest {
    String filePath = "E:\\Day29StateCencus\\src\\main\\resources\\IndiaStateCensusData.csv";
    @Test
    public void givenStateCensusRecordShouldReturnNumberOfRecords(){
    StateCensusAnalyser obj = new StateCensusAnalyser();
    try {
        int countRecords = obj.readCensusFile(filePath);
        Assert.assertEquals(29, countRecords);
    }
    catch (StateCensusException e){
        System.out.println(e.getMessage());
    }
    }
    @Test
    public void givenIncorrectFileFormatShouldReturnCustomException(){
        StateCensusAnalyser obj = new StateCensusAnalyser();
        try {
            int countRecords = obj.readCensusFile("E:\\Day29StateCencus\\src\\main\\resources\\IndiaStateCensusData");
            Assert.assertEquals("ExceptionType.INVALID_FORMAT:Invalid File Format",countRecords);
        }
        catch (StateCensusException e){
        }
    }
    @Test
    public void givenIncorrectFileTypeShouldReturnCustomException(){
        StateCensusAnalyser obj = new StateCensusAnalyser();
        try {
            int countRecords = obj.readCensusFile("E:\\Day29StateCencus\\src\\main\\resources\\IndiaStateCensusData.pdf");
            Assert.assertEquals("ExceptionType.INVALID_FORMAT:Invalid File Format",countRecords);
        }
        catch (StateCensusException e){
        }
    }
    @Test
    public void givenCorrectFileTypeButIncorrectDelimterShouldReturnCustomException(){
        StateCensusAnalyser obj = new StateCensusAnalyser();
        try {
            int countRecords = obj.readCensusFile("E:\\Day29StateCencus\\src\\main\\resources\\IndiaStateCensusData,pdf");
            Assert.assertEquals("ExceptionType.INVALID_FORMAT:Invalid File Format",countRecords);
        }
        catch (StateCensusException e){
        }
    }
    @Test
    public void givenCorrectFileTypeButIncorrectHeaderShouldReturnCustomException(){
        StateCensusAnalyser obj = new StateCensusAnalyser();
        try {
            String []header = {"State","Population","AreaInSqKm","DensityPerSqKm"} ;
            boolean checkHeader = obj.readHeader("E:\\Day29StateCencus\\src\\main\\resources\\IndiaStateCensusData.csv",header);
           Assert.assertTrue(checkHeader);
        }
        catch (StateCensusException e){
        }
    }
}
