package com.test;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;


public class StringTest {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
         int Q = Integer.parseInt(br.readLine().trim());
         int[][] query = new int[Q][2];
         for(int i_query = 0; i_query < Q; i_query++)
         {
         	String[] arr_query = br.readLine().split(" ");
         	for(int j_query = 0; j_query < arr_query.length; j_query++)
         	{
         		query[i_query][j_query] = Integer.parseInt(arr_query[j_query]);
         	}
         }

         int[] out_ = elements(Q, query);
         System.out.print(out_[0]);
         for(int i_out_ = 1; i_out_ < out_.length; i_out_++)
         {
         	System.out.print(" " + out_[i_out_]);
         }

         wr.close();
         br.close();
    }
    static int[] elements(int Q, int[][] query){
       
        List<Integer> finalList = new ArrayList<>();
        List<Integer> maxValList = new ArrayList<>();
        List<Integer> tube = new ArrayList<>();
        Map<Integer,Integer> countMap = new HashMap<>();

        for(int num=0;num<Q;num++){
            int x = query[num][0];
            int n = query[num][1];

            if(x == 1){
                tube.add(n);
                countMap.put(n,null != countMap.get(n)?countMap.get(n)+1:1);
            }
            if(x == 2 && n == -1){
                int maxValueInMap=(Collections.max(countMap.values()));
                for (Entry<Integer, Integer> entry : countMap.entrySet()) {
                    if (entry.getValue()==maxValueInMap) {
                        maxValList.add(entry.getKey());  
                    }
                }

                for(int j=tube.size()-1;j>=0;j--){   
                    int val = tube.get(j); 
                    if(maxValList.contains(val)){
                        countMap.put(val,countMap.get(val)-1);
                        finalList.add(tube.get(j));
                        tube.remove(j);
                        maxValList = new ArrayList<>();
                        break;
                    }
                }

            }
        }
        int[] result = new int[finalList.size()];
        for(int k=0;k<finalList.size();k++){
            result[k] = finalList.get(k);
        }
        return result;
    
    }
}