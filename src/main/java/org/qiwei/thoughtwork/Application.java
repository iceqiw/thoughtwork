package org.qiwei.thoughtwork;

import org.qiwei.thoughtwork.service.TripCountByMaxDistanceService;
import org.qiwei.thoughtwork.service.TripCountByStopService;
import org.qiwei.thoughtwork.service.TripDistanceService;
import org.qiwei.thoughtwork.service.TripShortestDistanceService;

/**
*@description  Application
*
 *  程序主入口
* @author   qiwei
* @date     2018/9/16 21:56
*/
public class Application {

    public static void main(String[] args) {

        RailRoadServiceFactory railRoadServiceFactory =new RailRoadServiceFactory("AB5,BC4,CD8,DC8,DE6,AD5,CE2,EB3,AE7");

        TripDistanceService service = railRoadServiceFactory.applyTripDistanceService();
        System.out.println("1.The distance of the route A-B-C.");
        String output1 = service.showDistance("A", "B", "C");
        System.out.println("Output #1:"+output1);

        System.out.println("2.The distance of the route A-D.");
        String output2 = service.showDistance("A", "D");
        System.out.println("Output #2:"+output2);

        System.out.println("3.The distance of the route A-D-C.");
        String output3 = service.showDistance("A", "D", "C");
        System.out.println("Output #3:"+output3);

        System.out.println("4.The distance of the route A-E-B-C-D.");
        String output4 = service.showDistance("A", "E", "B", "C", "D");
        System.out.println("Output #4:"+output4);

        System.out.println("5.The distance of the route A-E-D.");
        String output5 = service.showDistance("A", "E", "D");
        System.out.println("Output #5:"+output5);

        TripCountByStopService tripCountByStopService = railRoadServiceFactory.applyTripCountByStopService();
        System.out.println("6.The number of trips starting at C and ending at C with a maximum of 3 stops.  In the sample data below, there are two such trips: C-D-C (2 stops). and C-E-B-C (3 stops).");
        Integer output6 = tripCountByStopService.showMaxStopTripsCount("C", "C", 3);
        System.out.println("Output #6:"+output6);


        System.out.println("7.The number of trips starting at A and ending at C with exactly 4 stops.  In the sample data below, there are three such trips: A to C (via B,C,D); A to C (via D,C,D); and A to C (via D,E,B).");
        Integer output7 = tripCountByStopService.showExactlyStopTripsCount("A", "C", 4);
        System.out.println("Output #7:"+output7);

        TripShortestDistanceService tripShortestDistanceService = railRoadServiceFactory.applyTripShortestDistance();
        System.out.println("8.The length of the shortest route (in terms of distance to travel) from A to C.");
        Integer output8 = tripShortestDistanceService.showShortestTrips("A", "C");
        System.out.println("Output #8:"+output8);

        System.out.println("9.The length of the shortest route (in terms of distance to travel) from B to B.");
        Integer output9 = tripShortestDistanceService.showShortestTrips("B", "B");
        System.out.println("Output #9:"+output9);

        TripCountByMaxDistanceService tripCountByMaxDistanceService = railRoadServiceFactory.applyTripCountByMaxDistanceService();
        System.out.println("10.The number of different routes from C to C with a distance of less than 30.  In the sample data, the trips are: CDC, CEBC, CEBCDC, CDCEBC, CDEBC, CEBCEBC, CEBCEBCEBC.");
        Integer output10 = tripCountByMaxDistanceService.showTripsCountByMaxDistance("C", "C", 30);
        System.out.println("Output #10:"+output10);

    }
}
