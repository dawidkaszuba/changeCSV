package pl.dawidkaszuba;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CSVChanger {

    public static void removeCharsByRegex(String regex, String file, String newFile, int columnNumber){

        try {

            FileReader filereader = new FileReader(file);


            CSVReader csvReader = new CSVReader(filereader);
            String[] nextRecord;
            String cell;

            while ((nextRecord = csvReader.readNext()) != null) {

                StringBuilder stringBuilder = new StringBuilder();

                for (int i = 0; i < nextRecord.length; i++) {
                    stringBuilder.append(nextRecord[i]).append(';');
                }

                String[] parts = stringBuilder.toString().split(";");

                for(int j = 0; j < parts.length; j++){

                    if(j == columnNumber-1){
                        Pattern patt = Pattern.compile(regex);
                        Matcher matcher = patt.matcher(parts[j]);


                        if(matcher.find()){

                            cell = parts[j].replaceAll(regex, "");
                            parts[j] = cell;

                        }
                    }
                }

                saveRowtoFile(newFile,parts);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void removeNumbers(String file, String newFile, int columnNumber){

        try {

            FileReader filereader = new FileReader(file);


            CSVReader csvReader = new CSVReader(filereader);
            String[] nextRecord;
            String pattern =" \\d+\\/\\d+\\w+| \\d+ \\w+| \\d+\\w+\\/\\d| \\d+\\/\\d+| \\d+\\w+| \\d+";
            String cell;

            while ((nextRecord = csvReader.readNext()) != null) {

                StringBuilder stringBuilder = new StringBuilder();

                for (int i = 0; i < nextRecord.length; i++) {
                    stringBuilder.append(nextRecord[i]).append(';');
                }

                String[] parts = stringBuilder.toString().split(";");

                for(int j = 0; j < parts.length; j++){

                    if(j == columnNumber-1){
                        Pattern patt = Pattern.compile(pattern);
                        Matcher matcher = patt.matcher(parts[j]);

                        Pattern pattern1 = Pattern.compile(" \\d+\\/\\d+\\w+");
                        Pattern pattern2 = Pattern.compile(" \\d+\\w+\\/\\d");
                        Pattern pattern3 = Pattern.compile(" \\d+\\/\\d+");

                        Matcher matcher1 = pattern1.matcher(parts[j]);
                        Matcher matcher2 = pattern2.matcher(parts[j]);
                        Matcher matcher3 = pattern3.matcher(parts[j]);

                        if(matcher.find()){
                            if(matcher1.find()){

                                String flatNo = matcher1.group();
                                int sign = flatNo.indexOf("/");
                                parts[columnNumber]=flatNo.substring(0,sign);
                                parts[columnNumber+1]=flatNo.substring(sign+1);
                                cell = parts[j].replaceAll(pattern, "");
                                parts[j] = cell;

                            } else if(matcher2.find()){

                                String flatNo = matcher2.group();
                                int sign = flatNo.indexOf("/");
                                parts[columnNumber]=flatNo.substring(0,sign);
                                parts[columnNumber+1]=flatNo.substring(sign+1);
                                cell = parts[j].replaceAll(pattern, "");
                                parts[j] = cell;

                            }else if(matcher3.find()){

                                String flatNo = matcher3.group();
                                int sign = flatNo.indexOf("/");
                                parts[columnNumber]=flatNo.substring(0,sign);
                                parts[columnNumber+1]=flatNo.substring(sign+1);
                                cell = parts[j].replaceAll(pattern, "");
                                parts[j] = cell;

                            }else {
                                cell = parts[j].replaceAll(pattern, "");
                                parts[j] = cell;
                                String number = matcher.group();
                                parts[columnNumber] = number;
                            }
                        }
                    }
                }

                saveRowtoFile(newFile,parts);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void copyNumbers(String file, String newFile, int columnNumber){

        try {

            FileReader filereader = new FileReader(file);


            CSVReader csvReader = new CSVReader(filereader);
            String[] nextRecord;
            String pattern ="\\d+| \\d+\\/\\d+\\w+| \\d+ \\w+| \\d+\\w+\\/\\d| \\d+\\/\\d+| \\d+\\w+| \\d+";


            while ((nextRecord = csvReader.readNext()) != null) {

                StringBuilder stringBuilder = new StringBuilder();

                for (int i = 0; i < nextRecord.length; i++) {
                    stringBuilder.append(nextRecord[i]).append(';');
                }

                String[] parts = stringBuilder.toString().split(";");

                for(int j = 0; j < parts.length; j++){

                    if(j == columnNumber-1){
                        Pattern patt = Pattern.compile(pattern);
                        Matcher matcher = patt.matcher(parts[j]);

                        Pattern pattern1 = Pattern.compile(" \\d+\\/\\d+\\w+");
                        Pattern pattern2 = Pattern.compile(" \\d+\\w+\\/\\d");
                        Pattern pattern3 = Pattern.compile(" \\d+\\/\\d+");

                        Matcher matcher1 = pattern1.matcher(parts[j]);
                        Matcher matcher2 = pattern2.matcher(parts[j]);
                        Matcher matcher3 = pattern3.matcher(parts[j]);

                        if(matcher.find()){
                            if(matcher1.find()){

                                String flatNo = matcher1.group();
                                int sign = flatNo.indexOf("/");
                                parts[columnNumber]=flatNo.substring(0,sign);
                                parts[columnNumber+1]=flatNo.substring(sign+1);


                            } else if(matcher2.find()){

                                String flatNo = matcher2.group();
                                int sign = flatNo.indexOf("/");
                                parts[columnNumber]=flatNo.substring(0,sign);
                                parts[columnNumber+1]=flatNo.substring(sign+1);

                            }else if(matcher3.find()){

                                String flatNo = matcher3.group();
                                int sign = flatNo.indexOf("/");
                                parts[columnNumber]=flatNo.substring(0,sign);
                                parts[columnNumber+1]=flatNo.substring(sign+1);


                            }else {
                                String number = matcher.group();
                                parts[columnNumber] = number;
                            }
                        }
                    }
                }

                saveRowtoFile(newFile,parts);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void addSignsByStartedIndex(int index,String file, String newFile, int columnNumber,String signs){

        try {

            FileReader filereader = new FileReader(file);


            CSVReader csvReader = new CSVReader(filereader);
            String[] nextRecord;
            String cell;

            while ((nextRecord = csvReader.readNext()) != null) {

                StringBuilder stringBuilder = new StringBuilder();

                for (int i = 0; i < nextRecord.length; i++) {
                    stringBuilder.append(nextRecord[i]).append(';');
                }

                String[] parts = stringBuilder.toString().split(";");

                for(int j = 0; j < parts.length; j++){

                    if(j == columnNumber-1){
                        int indexNumb;

                        if(index==0){
                            cell = signs + parts[j];
                            parts[j] = cell;
                        }
                        else{
                            if(parts[j].length() < index){
                                indexNumb= parts[j].length();
                                cell = parts[j].substring(0,indexNumb) + signs;
                                parts[j] = cell;

                            }else{
                                indexNumb=index;
                                cell = parts[j].substring(0,indexNumb) + signs + parts[j].substring(indexNumb);
                                parts[j] = cell;
                            }
                        }
                    }
                }

                saveRowtoFile(newFile,parts);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }


    }

    public static void multiplyGoupRows(String newFile,String file, int repetitionsNumber, int numberOfAbandonedRows){

        try {

            FileReader filereader = new FileReader(file);


            CSVReader csvReader = new CSVReader(filereader);
            String[] nextRecord;
            int row=0;
            String[][] all = new String[repetitionsNumber+1][];

            while ((nextRecord = csvReader.readNext()) != null) {
                row++;

                StringBuilder stringBuilder = new StringBuilder();

                for (int i = 0; i < nextRecord.length; i++) {
                    stringBuilder.append(nextRecord[i]).append(';');
                }

                String[] parts = stringBuilder.toString().split(";");

                all[row-1] = parts;

            }

            for (int j = 0; j < repetitionsNumber; j++){

                for(int k = 0; k < all.length; k++){
                    if(k > numberOfAbandonedRows-1) {
                        saveRowtoFile(newFile, all[k]);
                    }
                }

            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }



    }

    public static void multiply(String newFile,String file, int repetitionsNumber, int numberOfAbandonedRows){
        try {

            FileReader filereader = new FileReader(file);


            CSVReader csvReader = new CSVReader(filereader);
            String[] nextRecord;
            int row = 0;


            while ((nextRecord = csvReader.readNext()) != null) {
                row++;
                StringBuilder stringBuilder = new StringBuilder();

                for (int i = 0; i < nextRecord.length; i++) {
                    stringBuilder.append(nextRecord[i]).append(';');
                }

                String[] parts = stringBuilder.toString().split(";");

                for(int i = 0; i < repetitionsNumber;i++){
                    if(row > numberOfAbandonedRows) {
                        saveRowtoFile(newFile, parts);
                    }
                }

            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void saveRowtoFile(String file, String[] dataToSave){

        try{

            FileWriter outputfile = new FileWriter(file,true);

            CSVWriter writer = new CSVWriter(outputfile,',');
            writer.writeNext(dataToSave);
            writer.close();

        }   catch (IOException e) {
            e.printStackTrace();
        }
    }

}
