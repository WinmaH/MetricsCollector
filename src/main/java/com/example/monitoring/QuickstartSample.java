/*
 * Copyright 2017 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.monitoring;

//CHECKSTYLE OFF: VariableDeclarationUsageDistance
// [START monitoring_quickstart]

import com.google.api.Metric;
import com.google.api.MonitoredResource;
import com.google.cloud.monitoring.v3.MetricServiceClient;
import com.google.monitoring.v3.CreateTimeSeriesRequest;
import com.google.monitoring.v3.Point;
import com.google.monitoring.v3.ProjectName;
import com.google.monitoring.v3.TimeInterval;
import com.google.monitoring.v3.TimeSeries;
import com.google.monitoring.v3.TypedValue;
import com.google.protobuf.util.Timestamps;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

// Imports the Google Cloud client library

public class QuickstartSample {


  private static String logDir="/home/sarangan/Applications";
  private static int sequenceNumber = 0;
  private static long outputFileTimeStamp;
  private static Writer fstream = null;


  public static void main(String... args) throws Exception {

    String projectId ="wso2-sp-distributed-216804";

    if (projectId == null) {
      System.err.println("Usage: QuickstartSample -DprojectId=YOUR_PROJECT_ID");
      return;
    }

    QuickstartSample qs1=new QuickstartSample();


    qs1.execute();

    System.out.println(System.currentTimeMillis() - (1538918109.237*1000));






  }



  public void execute() throws IOException{
    QuickstartSample qs=new QuickstartSample();



    //CONTAINER_LEVEL_METRICS



    //CPU_Usage_Time
    File file1 = new File("/home/sarangan/Applications/temp/1.txt");
    File file2 = new File("/home/sarangan/Applications/Results/EmailProcessor/26-09-2018:Test1(15min)/Node1/Container_Level_Metrics/CPU_Usage_Time.csv");
    qs.filewrite("metric.type=\"container.googleapis.com/container/cpu/usage_time\" AND resource.labels.cluster_name=\"wso2-sp-distributed-kubernetes\" AND resource.labels.container_name=\"wso2sp-worker-2\"",
            40,43,47,file1,file2);

    //Memory_Bytes_Used
    File file3 = new File("/home/sarangan/Applications/temp/2.txt");
    File file4 = new File("/home/sarangan/Applications/Results/EmailProcessor/26-09-2018:Test1(15min)/Node1/Container_Level_Metrics/Memory_Bytes_Used.csv");
    qs.filewrite("metric.type=\"container.googleapis.com/container/memory/bytes_used\" AND resource.labels.cluster_name=\"wso2-sp-distributed-kubernetes\" AND resource.labels.container_name=\"wso2sp-worker-2\"",
            4,7,11,file3,file4);




    //NODE LEVEL METRICS



    //CPU_Usage_Time
    File file5 = new File("/home/sarangan/Applications/temp/3.txt");
    File file6 = new File("/home/sarangan/Applications/Results/EmailProcessor/26-09-2018:Test1(15min)/Node1/Node_Level_Metrics/CPU_Usage_Time.csv");
    qs.filewrite("metric.type = \"compute.googleapis.com/instance/cpu/usage_time\" AND\n" +
                    "    metric.label.instance_name =\"gke-wso2-sp-distributed--default-pool-dac73e9c-zn9b\"",
            28,31,35,file5,file6);

    //CPU_Utilization
    File file7 = new File("/home/sarangan/Applications/temp/4.txt");
    File file8 = new File("/home/sarangan/Applications/Results/EmailProcessor/26-09-2018:Test1(15min)/Node1/Node_Level_Metrics/CPU_Utilization.csv");
    qs.filewrite("metric.type = \"compute.googleapis.com/instance/cpu/utilization\" AND\n" +
                    "    metric.label.instance_name =\"gke-wso2-sp-distributed--default-pool-dac73e9c-zn9b\"",
            28,31,35,file7,file8);

    //Network_Received_Bytes_Count,LoadBalanced=true
    File file9 = new File("/home/sarangan/Applications/temp/5.txt");
    File file10 = new File("/home/sarangan/Applications/Results/EmailProcessor/26-09-2018:Test1(15min)/Node1/Node_Level_Metrics/Network_Received_Bytes_count_LBT.csv");
    qs.filewrite("metric.type = \"compute.googleapis.com/instance/network/received_bytes_count\" AND     metric.label.instance_name =\"gke-wso2-sp-distributed--default-pool-dac73e9c-zn9b\" AND  metric.label.loadbalanced=\"true\"",
            32,35,39,file9,file10);

    //Network_Received_Bytes_Count,LoadBalanced=false
    File file11 = new File("/home/sarangan/Applications/temp/6.txt");
    File file12 = new File("/home/sarangan/Applications/Results/EmailProcessor/26-09-2018:Test1(15min)/Node1/Node_Level_Metrics/Network_Received_Bytes_count_LBF.csv");
    qs.filewrite("metric.type = \"compute.googleapis.com/instance/network/received_bytes_count\" AND     metric.label.instance_name =\"gke-wso2-sp-distributed--default-pool-dac73e9c-zn9b\" AND  metric.label.loadbalanced=\"false\"",
            32,35,39,file11,file12);


    //Network_sent_Bytes_Count,LoadBalanced=true
    File file13 = new File("/home/sarangan/Applications/temp/7.txt");
    File file14 = new File("/home/sarangan/Applications/Results/EmailProcessor/26-09-2018:Test1(15min)/Node1/Node_Level_Metrics/Network_Sent_Bytes_count_LBT.csv");
    qs.filewrite("metric.type = \"compute.googleapis.com/instance/network/sent_bytes_count\" AND     metric.label.instance_name =\"ggke-wso2-sp-distributed--default-pool-dac73e9c-zn9b\" AND  metric.label.loadbalanced=\"true\"",
            32,35,39,file13,file14);


    //Network_sent_Bytes_Count,LoadBalanced=false
    File file15 = new File("/home/sarangan/Applications/temp/8.txt");
    File file16 = new File("/home/sarangan/Applications/Results/EmailProcessor/26-09-2018:Test1(15min)/Node1/Node_Level_Metrics/Network_sent_Bytes_count_LBF.csv");
    qs.filewrite("metric.type = \"compute.googleapis.com/instance/network/sent_bytes_count\" AND     metric.label.instance_name =\"gke-wso2-sp-distributed--default-pool-dac73e9c-zn9b\" AND  metric.label.loadbalanced=\"false\"",
            32,35,39,file15,file16);

    //Network_Received_Packets_Count,Loadbalanced=true
    File file17 = new File("/home/sarangan/Applications/temp/9.txt");
    File file18 = new File("/home/sarangan/Applications/Results/EmailProcessor/26-09-2018:Test1(15min)/Node1/Node_Level_Metrics/Network_Received_Packets_count_LBT.csv");
    qs.filewrite("metric.type = \"compute.googleapis.com/instance/network/received_packets_count\" AND     metric.label.instance_name =\"gke-wso2-sp-distributed--default-pool-dac73e9c-zn9b\" AND  metric.label.loadbalanced=\"true\"",
            32,35,39,file17,file18);

    //Network_Received_Packets_Count,Loadbalanced=false
    File file19 = new File("/home/sarangan/Applications/temp/10.txt");
    File file20 = new File("/home/sarangan/Applications/Results/EmailProcessor/26-09-2018:Test1(15min)/Node1/Node_Level_Metrics/Network_Received_Packets_count_LBF.csv");
    qs.filewrite("metric.type = \"compute.googleapis.com/instance/network/received_packets_count\" AND     metric.label.instance_name =\"gke-wso2-sp-distributed--default-pool-dac73e9c-zn9b\" AND  metric.label.loadbalanced=\"false\"",
            32,35,39,file19,file20);

    //Network_sent_Packets_Count,Loadbalanced=true
    File file21 = new File("/home/sarangan/Applications/temp/11.txt");
    File file22 = new File("/home/sarangan/Applications/Results/EmailProcessor/26-09-2018:Test1(15min)/Node1/Node_Level_Metrics/Network_Sent_Packets_count_LBT.csv");
    qs.filewrite("metric.type = \"compute.googleapis.com/instance/network/sent_packets_count\" AND     metric.label.instance_name =\"gke-wso2-sp-distributed--default-pool-dac73e9c-zn9b\" AND  metric.label.loadbalanced=\"true\"",
            32,35,39,file21,file22);

    //Network_sent_Packets_Count,Loadbalanced=false
    File file23 = new File("/home/sarangan/Applications/temp/12.txt");
    File file24 = new File("/home/sarangan/Applications/Results/EmailProcessor/26-09-2018:Test1(15min)/Node1/Node_Level_Metrics/Network_Sent_Packets_count_LBF.csv");
    qs.filewrite("metric.type = \"compute.googleapis.com/instance/network/sent_packets_count\" AND     metric.label.instance_name =\"gke-wso2-sp-distributed--default-pool-dac73e9c-zn9b\" AND  metric.label.loadbalanced=\"false\"",
            32,35,39,file23,file24);


  }



  public void filewrite(String metrics_type,int start_count,int end_count,int value_count,File file_json,File file_csv) throws  IOException {
    Snippets snippets = new Snippets();
    snippets.listTimeSeries(metrics_type, file_json);
    int stc = start_count;
    try (BufferedReader reader = new BufferedReader(new FileReader(file_json))) {


      int count = 0;
      int temp_count = 0;
      ArrayList<Long> avg = new ArrayList<Long>();
      StringBuilder temp = new StringBuilder();
      BufferedWriter bw = null;
      FileWriter fw = null;

      if (!file_csv.exists()) {
        file_csv.createNewFile();
      }

      fw = new FileWriter(file_csv.getAbsoluteFile(), true);
      bw = new BufferedWriter(fw);

      bw.write(" Start time, End time, Average time, " + metrics_type);
      bw.write("\n");
      bw.write("\n");
      bw.flush();


      while (true) {

        count = count + 1;

        String line = reader.readLine();
        if (line == null) {
          break;
        }

        if (line.contains("evictable") ) {
          start_count=start_count+40;
          end_count=end_count+40;
          value_count=value_count+40;
        }
        if (line.contains("non-evictable") ) {
          break;
        }




        try {
          if (count == start_count) {
            if (line.contains("seconds")) {
              if (start_count == stc) {
                long i = Integer.parseInt(line.substring(15, line.length()));
                System.out.println(i);
                temp.append(" " + i);
                avg.add(i);
                temp.append(", ");
                start_count = start_count + 13;
                temp_count = temp_count + 1;

              } else {
                long i = Integer.parseInt(line.substring(15, line.length()));
                System.out.println("start time: " + i);
                temp.append(i);
                avg.add(i);
                temp.append(", ");
                start_count = start_count + 13;
                temp_count = temp_count + 1;
              }

            }
          }

          try {

            if (count == end_count) {
              if (line.contains("seconds")) {
                long j = Integer.parseInt(line.substring(15, (line.length())));
                System.out.println("End time: " + j);
                temp.append(j);
                temp.append(", ");
                end_count = end_count + 13;
                temp_count = temp_count + 1;

                if (avg.size() == 1) {
                  long m = avg.get(0);
                  long aver = m+j;
                  aver = aver / 2;
                  temp.append(aver);
                  temp.append(", ");
                  avg.clear();
                }

              }
            }
          } catch (NumberFormatException e) {
          }


          if (count == value_count) {

            try {
              System.out.println("Value: " + line.substring(17, line.length()));
              temp.append(line.substring(17, line.length()));
              temp.append(", ");
              value_count = value_count + 13;
              temp_count = temp_count + 1;
            } catch (StringIndexOutOfBoundsException e) {

            }
          }


          if (temp_count == 3 && temp != null) {
            bw.write(temp.toString());
            bw.write("\n");
            bw.flush();
            System.out.println("Done writing csv_string" + "\n");
            temp.delete(0, temp.length() - 1);
            temp_count = temp_count - 3;
          }
        } catch (IndexOutOfBoundsException e) {

        }


      }
    }catch(FileNotFoundException e){}


  }



}

