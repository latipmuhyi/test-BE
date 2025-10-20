package com.latipTest.test_plnicon.service;

import com.latipTest.test_plnicon.library.Response;
import com.latipTest.test_plnicon.library.ResponseCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class LogicalTestService {
    Logger logger = LoggerFactory.getLogger(LogicalTestService.class);
//    soal 1
    public Response<?>balikKalimat(){
        Response<List<Map<String, String>>> response = new Response<>();
        try {
            String[] kalimatTerbalik = {
                    "italem irad irigayaj",
                    "iadab itsap ulalreb",
                    "nalub kusutret gnalali"
            };
            Map<String, String> hasilMap = new LinkedHashMap<>();
            for (int i = 0; i < kalimatTerbalik.length; i++) {
                String kalimatNormal = reverseEachWord(kalimatTerbalik[i]);
                hasilMap.put("kalimat" + (i + 1), kalimatNormal);
            }
            List<Map<String, String>> listHasil = new ArrayList<>();
            listHasil.add(hasilMap);
            response.setData(listHasil);
            response.setResponseCode(ResponseCode.SUCCESS);
        } catch (Exception e) {
            logger.info(e.getMessage());
            response.setResponseCode(ResponseCode.SERVER_ERROR);
        }
        return response;
    }
    private String reverseEachWord(String sentence) {
        if (sentence == null || sentence.isEmpty()) return sentence;
        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();
        for (String word : words) {
            StringBuilder reversed = new StringBuilder(word);
            result.append(reversed.reverse()).append(" ");
        }
        return result.toString().trim();
    }

//    soal 2
    public Response<?> angka() {
        Response<List<String>> response = new Response<>();
        try {
            List<String> hasil = new ArrayList<>();

            for (int i = 1; i <= 100; i++) {
                if (i % 3 == 0 && i % 5 == 0) {
                    hasil.add(i + " FizzBuzz");
                } else if (i % 3 == 0) {
                    hasil.add(i + " Fizz");
                } else if (i % 5 == 0) {
                    hasil.add(i + " Buzz");
                } else {
                    hasil.add(String.valueOf(i));
                }
            }

            response.setData(hasil);
            response.setResponseCode(ResponseCode.SUCCESS);
        } catch (Exception e) {
            logger.info(e.getMessage());
            response.setResponseCode(ResponseCode.SERVER_ERROR);
        }
        return response;
    }

//    soal 3
    public Response<?> jumlah() {
        Response<List<Integer>> response = new Response<>();
        try {
            List<Integer> nilai = new ArrayList<>();

            int n1 = 0, n2 = 1;
            nilai.add(n1);
            nilai.add(n2);

            for (int i = 2; i < 10; i++) {
                int n3 = n1 + n2;
                nilai.add(n3);
                n1 = n2;
                n2 = n3;
            }

            response.setData(nilai);
            response.setResponseCode(ResponseCode.SUCCESS);
        } catch (Exception e) {
            logger.info(e.getMessage());
            response.setResponseCode(ResponseCode.SERVER_ERROR);
        }
        return response;
    }

//  soal 4
    public Response<?> nilaiSaham() {
        Response<List<Integer>> response = new Response<>();
        try {
            int[][] soal = {{7,8,3,10,8},{5,12,11,12,10},{7,18,27,10,29},{20,17,15,14,10}};
            List<Integer> nilai = new ArrayList<>();
            for (int i = 0; i < soal.length; i++) {nilai.add(keuntungan(soal[i]));}
            response.setData(nilai);
            response.setResponseCode(ResponseCode.SUCCESS);
        } catch (Exception e) {
            logger.info(e.getMessage());
            response.setResponseCode(ResponseCode.SERVER_ERROR);
        }
        return response;
    }
    private static int keuntungan(int[] harga){
        if (harga == null || harga.length < 2) return 0;
        int minHarga = harga[0];
        int maxUntung = 0;
        for (int i = 1; i < harga.length; i++) {
            int untungSekarang = harga[i] - minHarga;
            if (untungSekarang > maxUntung) {
                maxUntung = untungSekarang;
            }
            if (harga[i] < minHarga) {
                minHarga = harga[i];
            }
        }
        return maxUntung;
    }

//    soal 5
    public Response<?> hitungAngka() {
        Response<List<Map<String, Integer>>> response = new Response<>();
        try {
            String[] data1 = {"b", "7", "h", "6", "h", "k", "i", "5", "g", "7", "8"};
            String[] data2 = {"7", "b", "8", "5", "6", "9", "n", "f", "y", "6", "9"};
            String[] data3 = {"u", "h", "b", "n", "7", "6", "5", "1", "g", "7", "9"};

            List<Map<String, Integer>> hasil = new ArrayList<>();

            hasil.add(Map.of("data 1", hitungJumlahAngka(data1)));
            hasil.add(Map.of("data 2", hitungJumlahAngka(data2)));
            hasil.add(Map.of("data 3", hitungJumlahAngka(data3)));

            response.setData(hasil);
            response.setResponseCode(ResponseCode.SUCCESS);
        } catch (Exception e) {
            logger.info(e.getMessage());
            response.setResponseCode(ResponseCode.SERVER_ERROR);
        }
        return response;
    }

    private int hitungJumlahAngka(String[] data) {
        int count = 0;
        for (String value : data) {
            if (value.matches("\\d")) {
                count++;
            }
        }
        return count;
    }


}
