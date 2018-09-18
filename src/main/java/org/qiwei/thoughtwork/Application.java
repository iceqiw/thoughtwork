package org.qiwei.thoughtwork;

import org.qiwei.thoughtwork.domain.StrategyParamsByStop;
import org.qiwei.thoughtwork.service.TripService;

import java.io.*;
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
        System.out.println("-------------------------------------------------------------------------------");
        Scanner sc = new Scanner(System.in);
        System.out.print("please input graph file path：");
        /**
         * "AB5,BC4,CD8,DC8,DE6,AD5,CE2,EB3,AE7"
         */
        String graphFileName = sc.nextLine();

        String graph = Application.readGraphFile(graphFileName);

        if (graph.equals("")) {
            System.out.println("no file found");
            return;
        }

        System.out.println("Graph:" + graph);
        try {
            RailRoadServiceFactory railRoadServiceFactory = new RailRoadServiceFactory(graph);


            System.out.println("Output:");

            TripService<StrategyParamsByStop> service = railRoadServiceFactory.applyTripService(0);
            String[] stations = {"A", "B", "C"};
            service.doService(new StrategyParamsByStop(stations));

        } catch (Exception e) {
            System.out.println("wrong railroad");
            System.out.println("quit service");
        }
    }

    public static String readGraphFile(String path) {
        StringBuilder Graph = new StringBuilder();
        String tempString;
        File file = new File(path);
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            while ((tempString = reader.readLine()) != null) {
                Graph.append(tempString);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return Graph.toString();
    }
}
