package org.qiwei.thoughtwork;

import org.qiwei.thoughtwork.service.TripCountByMaxDistanceService;
import org.qiwei.thoughtwork.service.TripCountByStopService;
import org.qiwei.thoughtwork.service.TripDistanceService;
import org.qiwei.thoughtwork.service.TripShortestDistanceService;

/**
*@description  Application
*  
* @author   qiwei
* @date     2018/9/16 21:56
*/
public class Application2 {

    public static void main(String[] args) {

        RailRoadServiceFactory railRoadServiceFactory =new RailRoadServiceFactory("AB5,BC4,CD8,DC8,DE6,AD5,CE2,EB3,AE7");

        TripDistanceService service = railRoadServiceFactory.applyTripDistanceService();
        String output1 = service.showDistance("A", "B", "C");
        System.out.println("Output #1:"+output1);

        String output2 = service.showDistance("A", "D");
        System.out.println("Output #2:"+output2);

        String output3 = service.showDistance("A", "D", "C");
        System.out.println("Output #3:"+output3);

        String output4 = service.showDistance("A", "E", "B", "C", "D");
        System.out.println("Output #4:"+output4);

        String output5 = service.showDistance("A", "E", "D");
        System.out.println("Output #5:"+output5);

        TripCountByStopService tripCountByStopService = railRoadServiceFactory.applyTripCountByStopService();
        Integer output6 = tripCountByStopService.showMaxStopTripsCount("C", "C", 3);
        System.out.println("Output #6:"+output6);


        Integer output7 = tripCountByStopService.showExactlyStopTripsCount("A", "C", 4);
        System.out.println("Output #7:"+output7);

        TripShortestDistanceService tripShortestDistanceService = railRoadServiceFactory.applyTripShortestDistance();
        Integer output8 = tripShortestDistanceService.showShortestTrips("A", "C");
        System.out.println("Output #8:"+output8);

        Integer output9 = tripShortestDistanceService.showShortestTrips("B", "B");
        System.out.println("Output #9:"+output9);

        TripCountByMaxDistanceService tripCountByMaxDistanceService = railRoadServiceFactory.applyTripCountByMaxDistanceService();
        Integer output10 = tripCountByMaxDistanceService.showTripsCountByMaxDistance("C", "C", 30);
        System.out.println("Output #10:"+output10);

    }
}
