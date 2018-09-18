package org.qiwei.thoughtwork;


import org.junit.Before;
import org.junit.Test;
import org.qiwei.thoughtwork.domain.StrategyParams;
import org.qiwei.thoughtwork.domain.StrategyParamsByDis;
import org.qiwei.thoughtwork.domain.StrategyParamsByStop;
import org.qiwei.thoughtwork.exception.NoSuchRouteException;
import org.qiwei.thoughtwork.service.TripService;

import static org.junit.Assert.assertEquals;

/**
 * 测试用例
 *
 * @author qiwei
 * @description
 * @date 2018/9/14 23:06
 */
public class TrainTest {

    protected RailRoadServiceFactory railRoadServiceFactory;


    @Before
    public void init() {
        this.railRoadServiceFactory = new RailRoadServiceFactory("AB5,BC4,CD8,DC8,DE6,AD5,CE2,EB3,AE7");
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
        TripService<StrategyParamsByStop> service = railRoadServiceFactory.applyTripService(0);
        String[] stations = {"A", "B", "C"};
        String dis = service.doService(new StrategyParamsByStop(stations));
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
        TripService<StrategyParamsByStop> service = railRoadServiceFactory.applyTripService(0);
        String[] stations = {"A", "D"};
        String dis = service.doService(new StrategyParamsByStop(stations));
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
        TripService<StrategyParamsByStop> service = railRoadServiceFactory.applyTripService(0);
        String[] stations = {"A", "D", "C"};
        String dis = service.doService(new StrategyParamsByStop(stations));
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
        TripService<StrategyParamsByStop> service = railRoadServiceFactory.applyTripService(0);
        String[] stations = {"A", "E", "B", "C", "D"};
        String dis = service.doService(new StrategyParamsByStop(stations));
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
        TripService<StrategyParamsByStop> service = railRoadServiceFactory.applyTripService(0);
        String[] stations = {"A", "E", "D"};
        String dis;
        try {
            dis = service.doService(new StrategyParamsByStop(stations));
        } catch (NoSuchRouteException e) {
            dis = e.getMessage();
        }
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
        TripService<StrategyParamsByStop> service = railRoadServiceFactory.applyTripService(1);
        String count = service.doService(new StrategyParamsByStop("C", "C", 3));
        assertEquals("2", count);
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
        TripService<StrategyParamsByStop> service = railRoadServiceFactory.applyTripService(2);
        String count = service.doService(new StrategyParamsByStop("A", "C", 4));
        assertEquals("3", count);
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
        TripService<StrategyParams> service = railRoadServiceFactory.applyTripService(3);
        String count = service.doService(new StrategyParams("A", "C"));
        assertEquals("9", count);
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
        TripService<StrategyParams> service = railRoadServiceFactory.applyTripService(3);
        String count = service.doService(new StrategyParams("B", "B"));
        assertEquals("9", count);
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
        TripService<StrategyParamsByDis> service = railRoadServiceFactory.applyTripService(4);
        String count = service.doService(new StrategyParamsByDis("C", "C", 30));
        assertEquals("7", count);
    }
}
