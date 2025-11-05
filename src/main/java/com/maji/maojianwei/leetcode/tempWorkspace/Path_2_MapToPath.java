package com.maji.maojianwei.leetcode.tempWorkspace;

import java.util.*;

/**
 * Class: 将节点父节点对应关系转换为节点的绝对路径，
 * Created by Master SkyWalker
 * May the force be with you !
 * 2020/1/21 , 13:04
 */
public class Path_2_MapToPath {
    public static final String PATH_SEPARATE= "/";
    public static final Map<String, String> MAP = new HashMap<String ,String>() {
        {
            put("A", "root");

            put("B", "A"); put("C", "A"); put("D", "A"); put("E", "A"); put("F", "A");

            put("G", "B"); put("H", "B"); put("I", "B"); put("J", "B");
            put("K", "C"); put("L", "C");
            put("M", "D"); put("N", "D"); put("O", "D");
            put("P", "E"); put("Q", "E"); put("R", "E");
            put("S", "F"); put("T", "F"); put("U", "F"); put("V", "F");

            put("G1", "G"); put("G2", "G"); put("G3", "G"); put("G4", "G"); put("G5", "G");
            put("H1", "H"); put("H2", "H"); put("H3", "H"); put("H4", "H"); put("H5", "H");
            put("I1", "I"); put("I2", "I"); put("I3", "I"); put("I4", "I"); put("I5", "I");
            put("J1", "J"); put("J2", "J"); put("J3", "J"); put("J4", "J"); put("J5", "J");
            put("K1", "K"); put("K2", "K"); put("K3", "K"); put("K4", "K"); put("K5", "K"); 
            put("L1", "L"); put("L2", "L"); put("L3", "L"); put("L4", "L"); put("L5", "L");
            put("M1", "M"); put("M2", "M"); put("M3", "M"); put("M4", "M"); put("M5", "M");
            put("N1", "N"); put("N2", "N"); put("N3", "N"); put("N4", "N"); put("N5", "N");
            put("O1", "O"); put("O2", "O"); put("O3", "O"); put("O4", "O"); put("O5", "O");
            put("P1", "P"); put("P2", "P"); put("P3", "P"); put("P4", "P"); put("P5", "P"); 
            put("Q1", "Q"); put("Q2", "Q"); put("Q3", "Q"); put("Q4", "Q"); put("Q5", "Q");
            put("R1", "R"); put("R2", "R"); put("R3", "R"); put("R4", "R"); put("R5", "R"); 
            put("S1", "S"); put("S2", "S"); put("S3", "S"); put("S4", "S"); put("S5", "S");
            put("T1", "T"); put("T2", "T"); put("T3", "T"); put("T4", "T"); put("T5", "T");
            put("U1", "U"); put("U2", "U"); put("U3", "U"); put("U4", "U"); put("U5", "U");
            put("V1", "V"); put("V2", "V"); put("V3", "V"); put("V4", "V"); put("V5", "V");
            
            put("G1_1", "G1"); put("G1_2", "G1"); put("G1_3", "G1"); put("G1_4", "G1"); put("G1_5", "G1");
            put("G2_1", "G2"); put("G2_2", "G2"); put("G2_3", "G2"); put("G2_4", "G2"); put("G2_5", "G2");
            put("G3_1", "G3"); put("G3_2", "G3"); put("G3_3", "G3"); put("G3_4", "G3"); put("G3_5", "G3");
            put("G4_1", "G4"); put("G4_2", "G4"); put("G4_3", "G4"); put("G4_4", "G4"); put("G4_5", "G4");
            put("G5_1", "G5"); put("G5_2", "G5"); put("G5_3", "G5"); put("G5_4", "G5"); put("G5_5", "G5");
            put("H1_1", "H1"); put("H1_2", "H1"); put("H1_3", "H1"); put("H1_4", "H1"); put("H1_5", "H1");
            put("H2_1", "H2"); put("H2_2", "H2"); put("H2_3", "H2"); put("H2_4", "H2"); put("H2_5", "H2");
            put("H3_1", "H3"); put("H3_2", "H3"); put("H3_3", "H3"); put("H3_4", "H3"); put("H3_5", "H3");
            put("H4_1", "H4"); put("H4_2", "H4"); put("H4_3", "H4"); put("H4_4", "H4"); put("H4_5", "H4");
            put("H5_1", "H5"); put("H5_2", "H5"); put("H5_3", "H5"); put("H5_4", "H5"); put("H5_5", "H5");
            put("I1_1", "I1"); put("I1_2", "I1"); put("I1_3", "I1"); put("I1_4", "I1"); put("I1_5", "I1");
            put("I2_1", "I2"); put("I2_2", "I2"); put("I2_3", "I2"); put("I2_4", "I2"); put("I2_5", "I2");
            put("I3_1", "I3"); put("I3_2", "I3"); put("I3_3", "I3"); put("I3_4", "I3"); put("I3_5", "I3");
            put("I4_1", "I4"); put("I4_2", "I4"); put("I4_3", "I4"); put("I4_4", "I4"); put("I4_5", "I4");
            put("I5_1", "I5"); put("I5_2", "I5"); put("I5_3", "I5"); put("I5_4", "I5"); put("I5_5", "I5");
            put("J1_1", "J1"); put("J1_2", "J1"); put("J1_3", "J1"); put("J1_4", "J1"); put("J1_5", "J1");
            put("J2_1", "J2"); put("J2_2", "J2"); put("J2_3", "J2"); put("J2_4", "J2"); put("J2_5", "J2");
            put("J3_1", "J3"); put("J3_2", "J3"); put("J3_3", "J3"); put("J3_4", "J3"); put("J3_5", "J3");
            put("J4_1", "J4"); put("J4_2", "J4"); put("J4_3", "J4"); put("J4_4", "J4"); put("J4_5", "J4");
            put("J5_1", "J5"); put("J5_2", "J5"); put("J5_3", "J5"); put("J5_4", "J5"); put("J5_5", "J5");
            put("K1_1", "K1"); put("K1_2", "K1"); put("K1_3", "K1"); put("K1_4", "K1"); put("K1_5", "K1");
            put("K2_1", "K2"); put("K2_2", "K2"); put("K2_3", "K2"); put("K2_4", "K2"); put("K2_5", "K2");
            put("K3_1", "K3"); put("K3_2", "K3"); put("K3_3", "K3"); put("K3_4", "K3"); put("K3_5", "K3");
            put("K4_1", "K4"); put("K4_2", "K4"); put("K4_3", "K4"); put("K4_4", "K4"); put("K4_5", "K4");
            put("K5_1", "K5"); put("K5_2", "K5"); put("K5_3", "K5"); put("K5_4", "K5"); put("K5_5", "K5");
            put("L1_1", "L1"); put("L1_2", "L1"); put("L1_3", "L1"); put("L1_4", "L1"); put("L1_5", "L1");
            put("L2_1", "L2"); put("L2_2", "L2"); put("L2_3", "L2"); put("L2_4", "L2"); put("L2_5", "L2");
            put("L3_1", "L3"); put("L3_2", "L3"); put("L3_3", "L3"); put("L3_4", "L3"); put("L3_5", "L3");
            put("L4_1", "L4"); put("L4_2", "L4"); put("L4_3", "L4"); put("L4_4", "L4"); put("L4_5", "L4");
            put("L5_1", "L5"); put("L5_2", "L5"); put("L5_3", "L5"); put("L5_4", "L5"); put("L5_5", "L5");
            put("M1_1", "M1"); put("M1_2", "M1"); put("M1_3", "M1"); put("M1_4", "M1"); put("M1_5", "M1");
            put("M2_1", "M2"); put("M2_2", "M2"); put("M2_3", "M2"); put("M2_4", "M2"); put("M2_5", "M2");
            put("M3_1", "M3"); put("M3_2", "M3"); put("M3_3", "M3"); put("M3_4", "M3"); put("M3_5", "M3");
            put("M4_1", "M4"); put("M4_2", "M4"); put("M4_3", "M4"); put("M4_4", "M4"); put("M4_5", "M4");
            put("M5_1", "M5"); put("M5_2", "M5"); put("M5_3", "M5"); put("M5_4", "M5"); put("M5_5", "M5");
            put("N1_1", "N1"); put("N1_2", "N1"); put("N1_3", "N1"); put("N1_4", "N1"); put("N1_5", "N1");
            put("N2_1", "N2"); put("N2_2", "N2"); put("N2_3", "N2"); put("N2_4", "N2"); put("N2_5", "N2");
            put("N3_1", "N3"); put("N3_2", "N3"); put("N3_3", "N3"); put("N3_4", "N3"); put("N3_5", "N3");
            put("N4_1", "N4"); put("N4_2", "N4"); put("N4_3", "N4"); put("N4_4", "N4"); put("N4_5", "N4");
            put("N5_1", "N5"); put("N5_2", "N5"); put("N5_3", "N5"); put("N5_4", "N5"); put("N5_5", "N5");
            put("O1_1", "O1"); put("O1_2", "O1"); put("O1_3", "O1"); put("O1_4", "O1"); put("O1_5", "O1");
            put("O2_1", "O2"); put("O2_2", "O2"); put("O2_3", "O2"); put("O2_4", "O2"); put("O2_5", "O2");
            put("O3_1", "O3"); put("O3_2", "O3"); put("O3_3", "O3"); put("O3_4", "O3"); put("O3_5", "O3");
            put("O4_1", "O4"); put("O4_2", "O4"); put("O4_3", "O4"); put("O4_4", "O4"); put("O4_5", "O4");
            put("O5_1", "O5"); put("O5_2", "O5"); put("O5_3", "O5"); put("O5_4", "O5"); put("O5_5", "O5");
            put("P1_1", "P1"); put("P1_2", "P1"); put("P1_3", "P1"); put("P1_4", "P1"); put("P1_5", "P1");
            put("P2_1", "P2"); put("P2_2", "P2"); put("P2_3", "P2"); put("P2_4", "P2"); put("P2_5", "P2");
            put("P3_1", "P3"); put("P3_2", "P3"); put("P3_3", "P3"); put("P3_4", "P3"); put("P3_5", "P3");
            put("P4_1", "P4"); put("P4_2", "P4"); put("P4_3", "P4"); put("P4_4", "P4"); put("P4_5", "P4");
            put("P5_1", "P5"); put("P5_2", "P5"); put("P5_3", "P5"); put("P5_4", "P5"); put("P5_5", "P5");
            put("Q1_1", "Q1"); put("Q1_2", "Q1"); put("Q1_3", "Q1"); put("Q1_4", "Q1"); put("Q1_5", "Q1");
            put("Q2_1", "Q2"); put("Q2_2", "Q2"); put("Q2_3", "Q2"); put("Q2_4", "Q2"); put("Q2_5", "Q2");
            put("Q3_1", "Q3"); put("Q3_2", "Q3"); put("Q3_3", "Q3"); put("Q3_4", "Q3"); put("Q3_5", "Q3");
            put("Q4_1", "Q4"); put("Q4_2", "Q4"); put("Q4_3", "Q4"); put("Q4_4", "Q4"); put("Q4_5", "Q4");
            put("Q5_1", "Q5"); put("Q5_2", "Q5"); put("Q5_3", "Q5"); put("Q5_4", "Q5"); put("Q5_5", "Q5");
            put("R1_1", "R1"); put("R1_2", "R1"); put("R1_3", "R1"); put("R1_4", "R1"); put("R1_5", "R1");
            put("R2_1", "R2"); put("R2_2", "R2"); put("R2_3", "R2"); put("R2_4", "R2"); put("R2_5", "R2");
            put("R3_1", "R3"); put("R3_2", "R3"); put("R3_3", "R3"); put("R3_4", "R3"); put("R3_5", "R3");
            put("R4_1", "R4"); put("R4_2", "R4"); put("R4_3", "R4"); put("R4_4", "R4"); put("R4_5", "R4");
            put("R5_1", "R5"); put("R5_2", "R5"); put("R5_3", "R5"); put("R5_4", "R5"); put("R5_5", "R5");
            put("S1_1", "S1"); put("S1_2", "S1"); put("S1_3", "S1"); put("S1_4", "S1"); put("S1_5", "S1");
            put("S2_1", "S2"); put("S2_2", "S2"); put("S2_3", "S2"); put("S2_4", "S2"); put("S2_5", "S2");
            put("S3_1", "S3"); put("S3_2", "S3"); put("S3_3", "S3"); put("S3_4", "S3"); put("S3_5", "S3");
            put("S4_1", "S4"); put("S4_2", "S4"); put("S4_3", "S4"); put("S4_4", "S4"); put("S4_5", "S4");
            put("S5_1", "S5"); put("S5_2", "S5"); put("S5_3", "S5"); put("S5_4", "S5"); put("S5_5", "S5");
            put("T1_1", "T1"); put("T1_2", "T1"); put("T1_3", "T1"); put("T1_4", "T1"); put("T1_5", "T1");
            put("T2_1", "T2"); put("T2_2", "T2"); put("T2_3", "T2"); put("T2_4", "T2"); put("T2_5", "T2");
            put("T3_1", "T3"); put("T3_2", "T3"); put("T3_3", "T3"); put("T3_4", "T3"); put("T3_5", "T3");
            put("T4_1", "T4"); put("T4_2", "T4"); put("T4_3", "T4"); put("T4_4", "T4"); put("T4_5", "T4");
            put("T5_1", "T5"); put("T5_2", "T5"); put("T5_3", "T5"); put("T5_4", "T5"); put("T5_5", "T5");
            put("U1_1", "U1"); put("U1_2", "U1"); put("U1_3", "U1"); put("U1_4", "U1"); put("U1_5", "U1");
            put("U2_1", "U2"); put("U2_2", "U2"); put("U2_3", "U2"); put("U2_4", "U2"); put("U2_5", "U2");
            put("U3_1", "U3"); put("U3_2", "U3"); put("U3_3", "U3"); put("U3_4", "U3"); put("U3_5", "U3");
            put("U4_1", "U4"); put("U4_2", "U4"); put("U4_3", "U4"); put("U4_4", "U4"); put("U4_5", "U4");
            put("U5_1", "U5"); put("U5_2", "U5"); put("U5_3", "U5"); put("U5_4", "U5"); put("U5_5", "U5");
            put("V1_1", "V1"); put("V1_2", "V1"); put("V1_3", "V1"); put("V1_4", "V1"); put("V1_5", "V1");
            put("V2_1", "V2"); put("V2_2", "V2"); put("V2_3", "V2"); put("V2_4", "V2"); put("V2_5", "V2");
            put("V3_1", "V3"); put("V3_2", "V3"); put("V3_3", "V3"); put("V3_4", "V3"); put("V3_5", "V3");
            put("V4_1", "V4"); put("V4_2", "V4"); put("V4_3", "V4"); put("V4_4", "V4"); put("V4_5", "V4");
            put("V5_1", "V5"); put("V5_2", "V5"); put("V5_3", "V5"); put("V5_4", "V5"); put("V5_5", "V5");
            
        }
    };

    public static void main(String[] args) {
        Long start1 = System.currentTimeMillis();
       printPaths( transferInvertedPath( transferMapToPathOneByOne(MAP) ) );
        Long end1 = System.currentTimeMillis();

        Long start2 = System.currentTimeMillis();
        printPaths( transferInvertedPath( transferMapTpPathWithRecord(MAP) ) );
        Long end2 = System.currentTimeMillis();

        System.out.println( "time1:"+ (end1-start1) + " ms， time2:"+ (end2-start2) + " ms" );

       
    }
    
    public static void printPaths(Map<String, String> paths){
        for(Map.Entry<String, String > entry: paths.entrySet()){
            System.out.println(entry.getKey()+": "+ entry.getValue());
        }
    }
    
    public static Map<String, String> transferInvertedPath( Map<String , List<String> > map){
        Map<String , String> mapPath = new HashMap<>();
        for(Map.Entry<String, List<String>> entry : map.entrySet()){
            Collections.reverse(entry.getValue());
            String allPath = "";
            for(String pathNode : entry.getValue()){
                allPath += PATH_SEPARATE + pathNode;
            }
            mapPath.put(entry.getKey(), allPath);
        }
        return mapPath;
   }

    public static Map<String, List<String> > transferMapToPathOneByOne(Map<String, String> map){
        Map<String , List<String> > revertedPaths = new HashMap<>();

        for(Map.Entry<String, String> entry : map.entrySet()){
            String parent = entry.getValue();
            List<String> revertedPath = new ArrayList<>();
            String currentNode = entry.getKey();
            revertedPath.add(entry.getKey());

            while(!parent.equals("root")){
                for(Map.Entry<String, String> tempEntry : map.entrySet()){
                    if( tempEntry.getKey().equals( parent )){
                        revertedPath.add( tempEntry.getKey() );
                        parent = tempEntry.getValue();
                        break;
                    }
                }
            }
            revertedPaths.put(entry.getKey(), revertedPath);
        }
        return revertedPaths;
   }

    public static Map<String, List<String> > transferMapTpPathWithRecord(Map<String, String> map){

        Map<String , List<String> > revertedPaths = new HashMap<>();

        for(Map.Entry<String, String> entry : map.entrySet()){
            if(revertedPaths.containsKey(entry.getKey())){
                continue;
            }
            String parent = entry.getValue();
            List<String> revertedPath = new ArrayList<>();
            String currentNode = entry.getKey();
            revertedPath.add(entry.getKey());

            while(!parent.equals("root")){
                for(Map.Entry<String, String> tempEntry : map.entrySet()){
                    if( tempEntry.getKey().equals( parent )){
                        revertedPath.add( tempEntry.getKey() );
                        parent = tempEntry.getValue();
                        break;
                    }
                }
            }
            /* 需要进行深克隆，否则会产生错误的结果，revertedPath 一直在变 */
            revertedPaths.put(entry.getKey(), new ArrayList<String> (revertedPath));
            revertedPath.remove(0);
            while( revertedPath.size()!=0  && !revertedPaths.containsKey(revertedPath.get(0) ) ){
                revertedPaths.put(revertedPath.get(0), new ArrayList<String> (revertedPath));
                revertedPath.remove(0);
            }
        }
        return revertedPaths;

    }



}
