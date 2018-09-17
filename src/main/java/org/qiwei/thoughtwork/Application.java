package org.qiwei.thoughtwork;

import org.qiwei.thoughtwork.service.TripCountByMaxDistanceService;
import org.qiwei.thoughtwork.service.TripCountByStopService;
import org.qiwei.thoughtwork.service.TripDistanceService;
import org.qiwei.thoughtwork.service.TripShortestDistanceService;

import java.util.Scanner;

/**
 * @author qiwei
 * @description Application
 * <p>
 * 程序主入口
 * @date 2018/9/16 21:56
 */
public class Application {

    public static void main(String[] args) {
        System.out.println("1.The distance of the route A-B-C.");
        System.out.println("2.The distance of the route A-D.");
        System.out.println("3.The distance of the route A-D-C.");
        System.out.println("4.The distance of the route A-E-B-C-D.");
        System.out.println("5.The distance of the route A-E-D.");
        System.out.println("6.The number of trips starting at C and ending at C with a maximum of 3 stops.  In the sample data below, there are two such trips: C-D-C (2 stops). and C-E-B-C (3 stops).");
        System.out.println("7.The number of trips starting at A and ending at C with exactly 4 stops.  In the sample data below, there are three such trips: A to C (via B,C,D); A to C (via D,C,D); and A to C (via D,E,B).");
        System.out.println("8.The length of the shortest route (in terms of distance to travel) from A to C.");
        System.out.println("9.The length of the shortest route (in terms of distance to travel) from B to B.");
        System.out.println("10.The number of different routes from C to C with a distance of less than 30.  In the sample data, the trips are: CDC, CEBC, CEBCDC, CDCEBC, CDEBC, CEBCEBC, CEBCEBCEBC.");

        Scanner sc = new Scanner(System.in);
        System.out.println("default graph：AB5,BC4,CD8,DC8,DE6,AD5,CE2,EB3,AE7");
        System.out.print("Graph：");
        /**
         * "AB5,BC4,CD8,DC8,DE6,AD5,CE2,EB3,AE7"
         */
        String Graph = sc.nextLine();
        if (Graph.equals("")) {
            Graph = "AB5,BC4,CD8,DC8,DE6,AD5,CE2,EB3,AE7";
        }
        try {
            RailRoadServiceFactory railRoadServiceFactory = new RailRoadServiceFactory(Graph);


            System.out.println("Output:");
            TripDistanceService service = railRoadServiceFactory.applyTripDistanceService();

            String output1 = service.showDistance("A", "B", "C");
            System.out.println("Output #1:" + output1);


            String output2 = service.showDistance("A", "D");
            System.out.println("Output #2:" + output2);


            String output3 = service.showDistance("A", "D", "C");
            System.out.println("Output #3:" + output3);


            String output4 = service.showDistance("A", "E", "B", "C", "D");
            System.out.println("Output #4:" + output4);


            String output5 = service.showDistance("A", "E", "D");
            System.out.println("Output #5:" + output5);

            TripCountByStopService tripCountByStopService = railRoadServiceFactory.applyTripCountByStopService();
            Integer output6 = tripCountByStopService.showMaxStopTripsCount("C", "C", 3);
            System.out.println("Output #6:" + output6);


            Integer output7 = tripCountByStopService.showExactlyStopTripsCount("A", "C", 4);
            System.out.println("Output #7:" + output7);

            TripShortestDistanceService tripShortestDistanceService = railRoadServiceFactory.applyTripShortestDistance();
            Integer output8 = tripShortestDistanceService.showShortestTrips("A", "C");
            System.out.println("Output #8:" + output8);

            Integer output9 = tripShortestDistanceService.showShortestTrips("B", "B");
            System.out.println("Output #9:" + output9);

            TripCountByMaxDistanceService tripCountByMaxDistanceService = railRoadServiceFactory.applyTripCountByMaxDistanceService();
            Integer output10 = tripCountByMaxDistanceService.showTripsCountByMaxDistance("C", "C", 30);
            System.out.println("Output #10:" + output10);
        } catch (Exception e) {
            System.out.println("wrong railroad");
            System.out.println("quit service");
        }
    }
}
