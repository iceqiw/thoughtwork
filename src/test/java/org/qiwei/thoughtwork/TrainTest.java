package org.qiwei.thoughtwork;


import org.junit.Before;
import org.junit.Test;
import org.qiwei.thoughtwork.domain.Route;
import org.qiwei.thoughtwork.service.TripCountByMaxDistanceService;
import org.qiwei.thoughtwork.service.TripCountByStopService;
import org.qiwei.thoughtwork.service.TripDistanceService;
import org.qiwei.thoughtwork.service.TripShortestDistanceService;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

/**
 * @author qiwei
 * @description
 * @date 2018/9/14 23:06
 */
public class TrainTest {

    protected RailRoadServiceFactory railRoadServiceFactory;


    @Before
    public void init() {
        this.railRoadServiceFactory =new RailRoadServiceFactory("AB5,BC4,CD8,DC8,DE6,AD5,CE2,EB3,AE7");
    }


    /**
     * @param
     * @return
     * @description 1.The distance of the route A-B-C.
     * Expected :Output #1: 9
     * @author qiwei
     * @date 23:09 2018/9/14
     */
    @Test
    public void test1() {
        TripDistanceService service = railRoadServiceFactory.applyTripDistanceService();
        String dis = service.showDistance("A", "B", "C");
        assertEquals("9", dis);
    }

    /**
     * @param
     * @return
     * @description 2.The distance of the route A-D.
     * Expected :Output #2: 5
     * @author qiwei
     * @date 23:09 2018/9/14
     */
    @Test
    public void test2() {
        TripDistanceService service = railRoadServiceFactory.applyTripDistanceService();
        String dis = service.showDistance("A", "D");
        assertEquals("5", dis);
    }

    /**
     * @param
     * @return void
     * @description 3The distance of the route A-D-C
     * Expected :Output #3: 13
     * @author qiwei
     * @date 10:47 2018/9/16
     */
    @Test
    public void test3() {
        TripDistanceService service = railRoadServiceFactory.applyTripDistanceService();
        String dis = service.showDistance("A", "D", "C");
        assertEquals("13", dis);
    }

    /**
     * @param
     * @return
     * @description 4 The distance of the route A-E-B-C-D.
     * Expected :Output #4: 22
     * @author qiwei
     * @date 10:47 2018/9/16
     */
    @Test
    public void test4() {
        TripDistanceService service = railRoadServiceFactory.applyTripDistanceService();
        String dis = service.showDistance("A", "E", "B", "C", "D");
        assertEquals("22", dis);
    }

    /**
     * @param
     * @return
     * @description 5 The distance of the route A-E-D.
     * Expected :Output #5: NO SUCH ROUTE
     * @author qiwei
     * @date 10:47 2018/9/16
     */
    @Test
    public void test5() {
        TripDistanceService service = railRoadServiceFactory.applyTripDistanceService();
        String dis = service.showDistance("A", "E", "D");
        assertEquals("NO SUCH ROUTE", dis);
    }


    /**
     * @param
     * @return
     * @description The number of trips starting at C and ending at C with a maximum of 3 stops.
     * In the sample data below, there are two such trips: C-D-C (2 stops). and C-E-B-C (3 stops).
     * Output #6: 2
     * @author qiwei
     * @date 18:14 2018/9/16
     */
    @Test
    public void test6() {
        TripCountByStopService service = railRoadServiceFactory.applyTripCountByStopService();
        Integer count = service.showMaxStopTripsCount("C", "C", 3);
        assertEquals("2", count.toString());
    }

    /**
     * @param
     * @return
     * @description The number of trips starting at A and ending at C with exactly 4 stops.
     * In the sample data below, there are three such trips: A to C (via B,C,D); A to C (via D,C,D); and A to C (via D,E,B).
     * Output #7: 3
     * @author qiwei
     * @date 18:15 2018/9/16
     */
    @Test
    public void test7() {
        TripCountByStopService service = railRoadServiceFactory.applyTripCountByStopService();
        Integer count = service.showExactlyStopTripsCount("A", "C", 4);
        assertEquals("3", count.toString());
    }


    /**
     * @param
     * @return
     * @description The length of the shortest route (in terms of distance to travel) from A to C.
     * Output #8: 9
     * @author qiwei
     * @date 18:16 2018/9/16
     */
    @Test
    public void test8() {
        TripShortestDistanceService service = railRoadServiceFactory.applyTripShortestDistance();
        Integer dis = service.showShortestTrips("A", "C");
        assertEquals("9", dis.toString());
    }

    /**
     * @param
     * @return
     * @description The length of the shortest route (in terms of distance to travel) from B to B.
     * Output #9: 9
     * @author qiwei
     * @date 18:19 2018/9/16
     */
    @Test
    public void test9() {
        TripShortestDistanceService service = railRoadServiceFactory.applyTripShortestDistance();
        Integer dis = service.showShortestTrips("B", "B");
        assertEquals("9", dis.toString());
    }

    /**
     * @param
     * @return
     * @description The number of different routes from C to C with a distance of less than 30.
     * In the sample data, the trips are: CDC, CEBC, CEBCDC, CDCEBC, CDEBC, CEBCEBC, CEBCEBCEBC.
     * Output #10: 7
     * @author qiwei
     * @date 18:20 2018/9/16
     */
    @Test
    public void test10() {
        TripCountByMaxDistanceService service = railRoadServiceFactory.applyTripCountByMaxDistanceService();
        Integer count = service.showTripsCountByMaxDistance("C", "C", 30);
        assertEquals("7", count.toString());
    }
}
