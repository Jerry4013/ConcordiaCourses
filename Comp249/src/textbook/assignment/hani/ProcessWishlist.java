package assignment.hani;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ProcessWishlist {
    public static void main(String[] args) {
        ShowList list1 = new ShowList();
        ShowList list2 = new ShowList(list1);

        Scanner fileIn = null;
        try{
            fileIn = new Scanner(new FileInputStream(
                    "files/TVGuide.txt"));
        }catch(FileNotFoundException e){
            System.out.println("Cannot find the file.");
            System.exit(0);
        }

        StringBuilder showListStringBuilder = new StringBuilder();
        while (fileIn.hasNextLine()){
            String line = fileIn.nextLine();
            showListStringBuilder.append(line);
            showListStringBuilder.append("\n");
        }

        String showListString = showListStringBuilder.toString();
        String[] showList = showListString.split("\\n\\n");

        for (String s : showList) {
            String[] component = s.split("\\s");
            String showID = component[0];
            String showName = component[1];
            double startTime = Double.parseDouble(component[3]);
            double endTime = Double.parseDouble(component[5]);
            TVShow tvShow = new TVShow(showID,showName,startTime,endTime);
            if (!list1.contains(tvShow.getShowID())){
                list1.addToStart(tvShow);
            }
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter the file name of your interested TV show:");
        String interestFile = scanner.next();
        
        try{
            fileIn = new Scanner(new FileInputStream(
                    "files/" + interestFile));
        }catch(FileNotFoundException e){
            System.out.println("Cannot find the file.");
            System.exit(0);
        }
        fileIn.next();
        String show = fileIn.next();
        ArrayList<String> watching = new ArrayList<>();
        while(!show.equalsIgnoreCase("Wishlist")){
            watching.add(show);
            show = fileIn.next();
        }

        ArrayList<String> wishlist = new ArrayList<>();
        while(fileIn.hasNext()){
            show = fileIn.next();
            wishlist.add(show);
        }

        process(watching, wishlist, list1);

        System.out.println();
        System.out.println("Please enter a showID: ");
        show = scanner.next();
        while (!show.equals("E")){
            wishlist.clear();
            wishlist.add(show);
            int iteration = process(watching, wishlist, list1);
            System.out.println("We performed " + iteration + " iterations.");
            System.out.println("Please enter a showID: (Enter 'E' to exit) ");
            show = scanner.next();
        }


    }

    private static int process(ArrayList<String> watching,
                     ArrayList<String> wishlist, ShowList list1){
        int iteration = 0;
        outerLoop:
        for (int i = 0; i < wishlist.size(); i++) {
            String s = wishlist.get(i);
            innerLoop:
            for (int j = 0; j < watching.size(); j++) {
                String s1 = watching.get(j);
                TVShow wishShow = list1.findShow(s);
                TVShow watchingShow = list1.findShow(s1);

                if (wishShow.getStartTime() > watchingShow.getStartTime()
                        && wishShow.getStartTime() < watchingShow.getEndTime()) {
                    iteration++;
                    System.out.println("User can't watch show " + s +
                            " as he/she is not finished with a show he/she is watching.");
                    break;
                } else if (wishShow.getEndTime() > watchingShow.getStartTime()
                        && wishShow.getEndTime() < watchingShow.getEndTime()) {
                    iteration++;
                    System.out.println("User can't watch show " + s +
                            " as he/she will begin another show at the same time");
                    break;
                } else if (watchingShow.getStartTime() > wishShow.getStartTime()
                        && watchingShow.getStartTime() < wishShow.getEndTime()) {
                    iteration++;
                    System.out.println("User can't watch show " + s +
                            " as he/she will begin another show at the same time");
                    break;
                } else if (watchingShow.getEndTime() > wishShow.getStartTime()
                        && watchingShow.getEndTime() < wishShow.getEndTime()) {
                    iteration++;
                    System.out.println("User can't watch show " + s +
                            " as he/she is not finished with a show he/she is watching.");
                    break;
                } else if (wishShow.getStartTime() == watchingShow.getStartTime()
                        && wishShow.getEndTime() == watchingShow.getEndTime()) {
                    iteration++;
                    System.out.println("User can't watch show " + s +
                            " as he/she will begin another show at the same time.");
                    break;
                } else {
                    if (j == watching.size() - 1) {
                        iteration++;
                        System.out.println("User can watch show " + s +
                                " as he/she is not watching anything else during that time.");
                    }
                    else{
                        iteration++;
                        continue innerLoop;
                    }
                }
            }
        }
        return iteration;
    }
}
