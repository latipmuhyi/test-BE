package com.latipTest.test_plnicon.dto;

import lombok.Data;
import java.util.List;

@Data
public class PTestDto {
    private String officeName;
    private String roomName;
    private int participants;
    private List<Consumption> listConsumption;
}
