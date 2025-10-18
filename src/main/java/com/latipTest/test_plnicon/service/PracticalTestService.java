package com.latipTest.test_plnicon.service;

import com.latipTest.test_plnicon.dto.Consumption;
import com.latipTest.test_plnicon.dto.MasterConsumption;
import com.latipTest.test_plnicon.dto.PTestDto;
import com.latipTest.test_plnicon.library.Response;
import com.latipTest.test_plnicon.library.ResponseCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class PracticalTestService {
    Logger logger = LoggerFactory.getLogger(PracticalTestService.class);
    public Response<?> dashboard() {
        Response<Map<String, Object>> response = new Response<>();
        try {
            RestTemplate restTemplate = new RestTemplate();
            String bookingUrl = "https://66876cc30bc7155dc017a662.mockapi.io/api/dummy-data/bookingList";
            String masterUrl = "https://6686cb5583c983911b03a7f3.mockapi.io/api/dummy-data/masterJenisKonsumsi";

            PTestDto[] bookings = restTemplate.getForObject(bookingUrl,PTestDto[].class);
            MasterConsumption[] masters = restTemplate.getForObject(masterUrl, MasterConsumption[].class);

            Map<String, Integer> consumptionPrice = new HashMap<>();
            for (MasterConsumption m : masters) {
                consumptionPrice.put(m.getName(), m.getMaxPrice());
            }

            int totalBooking = bookings.length;
            int totalParticipants = 0;
            Set<String> uniqueRooms = new HashSet<>();
            Map<String, Integer> officeBookings = new HashMap<>();
            Map<String, Integer> officeParticipants = new HashMap<>();
            Map<String, Integer> consumptionCount = new HashMap<>();

            for (PTestDto b : bookings) {
                totalParticipants += b.getParticipants();
                uniqueRooms.add(b.getRoomName());

                officeBookings.merge(b.getOfficeName(), 1, Integer::sum);
                officeParticipants.merge(b.getOfficeName(), b.getParticipants(), Integer::sum);

                for (Consumption c : b.getListConsumption()) {
                    consumptionCount.merge(c.getName(), 1, Integer::sum);
                }
            }

            List<Map<String, Object>> consumptionSummary = new ArrayList<>();
            for (Map.Entry<String, Integer> entry : consumptionCount.entrySet()) {
                String name = entry.getKey();
                int usage = entry.getValue();
                int price = consumptionPrice.getOrDefault(name, 0);
                consumptionSummary.add(Map.of(
                        "name", name,
                        "totalUsage", usage,
                        "totalCost", usage * price
                ));
            }

            List<Map<String, Object>> officeSummary = new ArrayList<>();
            for (String office : officeBookings.keySet()) {
                officeSummary.add(Map.of(
                        "officeName", office,
                        "totalBooking", officeBookings.get(office),
                        "totalParticipants", officeParticipants.get(office)
                ));
            }

            Map<String, Object> result = new LinkedHashMap<>();
            result.put("totalBooking", totalBooking);
            result.put("totalParticipants", totalParticipants);
            result.put("totalRoomUsed", uniqueRooms.size());
            result.put("consumptionSummary", consumptionSummary);
            result.put("officeSummary", officeSummary);

            response.setData(result);
            response.setResponseCode(ResponseCode.SUCCESS);

        } catch (Exception e) {
            logger.info(e.getMessage());
            response.setResponseCode(ResponseCode.SERVER_ERROR);
        }
        return response;
    }

}
